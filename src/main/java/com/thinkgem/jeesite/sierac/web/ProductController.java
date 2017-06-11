package com.thinkgem.jeesite.sierac.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.beanvalidator.BeanValidators;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.service.ProductService;

/**
 * 产品管理Controller
 * 
 * @author wgc
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/product")
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;

    @ModelAttribute
    public Product get(@RequestParam(required = false) String id) {
        Product entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = productService.get(id);
        }
        if (entity == null) {
            entity = new Product();
        }
        return entity;
    }

    /**
     * 获取产品列表信息接口
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getProductList", method = RequestMethod.GET, headers = { "Accept=application/json" })
    @ResponseBody
    public Map<String, List<Product>> getProductList(Product product, HttpServletRequest request,
            HttpServletResponse response) {

        Page<Product> page = productService.findPage(new Page<Product>(request, response), product);

        Map<String, List<Product>> returnMap = new HashMap<String, List<Product>>();
        List<Product> products = page.getList();
        returnMap.put("data", products);

        return returnMap;

    }

    @RequiresPermissions("sierac:product:view")
    @RequestMapping(value = { "list", "" })
    public String list(Product product, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Product> page = productService.findPage(new Page<Product>(request, response), product);
        model.addAttribute("page", page);
        return "sierac/productList";
    }

    @RequiresPermissions("sierac:product:view")
    @RequestMapping(value = "form")
    public String form(Product product, Model model) {
        model.addAttribute("product", product);
        return "sierac/productForm";
    }

    @RequiresPermissions("sierac:product:edit")
    @RequestMapping(value = "save")
    public String save(Product product, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request,
            HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
//        String str = new String((request.getParameter("bigQuestionTypeName")).getBytes("iso-8859-1"),"utf-8");

        if (!beanValidator(model, product)) {
            return form(product, model);
        }
        System.out.print(product);
        productService.save(product);
        addMessage(redirectAttributes, "保存产品成功");
        return "redirect:" + Global.getAdminPath() + "/sierac/product/?repage";
    }

    @RequiresPermissions("sierac:product:edit")
    @RequestMapping(value = "delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.delete(product);
        addMessage(redirectAttributes, "删除产品成功");
        return "redirect:" + Global.getAdminPath() + "/sierac/product/?repage";
    }

    /**
     * 导出产品数据
     * 
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:product:view")
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String exportFile(Product product, HttpServletRequest request, HttpServletResponse response,
            RedirectAttributes redirectAttributes) {
        try {
            String fileName = "产品数据" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            Page<Product> page = productService.findPage(new Page<Product>(request, response, -1), product);
            new ExportExcel("产品数据", Product.class).setDataList(page.getList()).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导出产品失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + Global.getAdminPath() + "/sierac/product/?repage";
    }

    /**
     * 导入产品数据
     * 
     * @param file
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:product:edit")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + Global.getAdminPath() + "/sierac/product/?repage";
        }
        try {
            int successNum = 0;
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();
            ImportExcel ei = new ImportExcel(file, 1, 0);
            List<Product> list = ei.getDataList(Product.class);
            for (Product product : list) {
                try {
                    if ("".equals(product.getCode())) {

                        failureMsg.append("<br/>产品代码" + product.getCode() + "不能为空 ");
                        failureNum++;
                        continue;
                    } else if ("true".equals(checkcode(product.getCode()))) {
                        BeanValidators.validateWithException(validator, product);
                        productService.save(product);
                        successNum++;
                    }

                    else {
                        failureMsg.append("<br/>产品代码 " + product.getCode() + " 已存在; ");
                        failureNum++;
                    }
                } catch (ConstraintViolationException ex) {
                    failureMsg.append("<br/>产品代码 " + product.getCode() + " 导入失败：");
                    List<String> messageList = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
                    for (String message : messageList) {
                        failureMsg.append(message + "; ");
                        failureNum++;
                    }
                } catch (Exception ex) {
                    failureMsg.append("<br/>产品代码 " + product.getCode() + " 导入失败：" + ex.getMessage());
                }
            }
            if (failureNum > 0) {
                failureMsg.insert(0, "，失败 " + failureNum + " 条产品，导入信息如下：");
            }
            addMessage(redirectAttributes, "已成功导入 " + successNum + " 条产品" + failureMsg);
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入产品失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + Global.getAdminPath() + "/sierac/product/?repage";
    }

    /**
     * 下载导入产品数据模板
     * 
     * @return
     */
    /*
     * @RequiresPermissions("sierac:product:view")
     * 
     * @RequestMapping(value = "import/template") public String
     * importFileTemplate(HttpServletResponse response, RedirectAttributes
     * redirectAttributes) { try { String fileName = "产品数据导入模板.xlsx";
     * List<Product> list = Lists.newArrayList();
     * list.add(ProductUtils.getProduct()); new ExportExcel("产品数据",
     * Product.class, 2).setDataList(list).write(response, fileName).dispose();
     * return null; } catch (Exception e) { addMessage(redirectAttributes,
     * "导入模板下载失败！失败信息："+e.getMessage()); } return
     * "redirect:"+Global.getAdminPath()+"/sierac/product/?repage"; }
     */
    // 验证产品代码是否唯一
    @ResponseBody
    @RequiresPermissions("sierac:product:edit")
    @RequestMapping(value = "checkcode")
    public String checkcode(String code) {
        Product product = new Product();
        product.setCode(code);
        List<Product> list = productService.findList(product);
        for (Product product2 : list) {
            if (product2 != null) {
                return "false";
            }
        }
        return "true";
    }
    @ResponseBody
    @RequiresPermissions("sierac:product:edit")
    @RequestMapping(value = "check")
    public String check(HttpServletRequest request ,String oldcode, String code) throws UnsupportedEncodingException {
        String s = new String(request.getParameter("code").getBytes("ISO8859-1"), "UTF-8");//encodeURIComponent编码转换
        if (s !=null && s.equals(oldcode)) {
			return "true";//不重复
		} else if (s !=null && productService.findByCode(s)==null) {
			return "true"; //不重复
		}
		return "false"; //重复
	}

    /**
     * 下载导入用户数据模板
     * 
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:rdcWarehouse:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
        try {
            String fileName = "产品数据.xlsx";
            List<Product> list = Lists.newArrayList();
            Product product = new Product();
            product = productService.findList(new Product()).get(0);
            list.add(product);
            new ExportExcel("产品数据", Product.class, 2).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + adminPath + "/sierac/rdcOutHeader/?repage";
    }

    /**
     * 获取产品名称
     */
    /*
     * @RequiresPermissions("productiontask")
     * 
     * @ResponseBody
     * 
     * @RequestMapping(value = "treeData") public List<Map<String, Object>>
     * treeData(@RequestParam(required=false) String extId,
     * 
     * @RequestParam(required=false) String type,
     * 
     * @RequestParam(required=false) Long grade, @RequestParam(required=false)
     * Boolean isAll, HttpServletResponse response) { List<Map<String, Object>>
     * mapList = Lists.newArrayList(); List<Product> list =
     * productService.findList(isAll); for (int i=0; i<list.size(); i++){
     * Product e = list.get(i); Map<String, Object> map = Maps.newHashMap();
     * map.put("id", e.getId()); map.put("name", e.getName()); mapList.add(map);
     * } return mapList; }
     */
}
