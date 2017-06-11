/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import com.google.gson.Gson;
import com.thinkgem.jeesite.sierac.entity.RdcOutHeader;
import com.thinkgem.jeesite.sierac.service.RdcOutHeaderService;
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
import com.thinkgem.jeesite.sierac.entity.RdcWarehouse;
import com.thinkgem.jeesite.sierac.service.RdcWarehouseService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/rdcWarehouse")
public class RdcWarehouseController extends BaseController {

    @Autowired
    private RdcWarehouseService rdcWarehouseService;


    @ModelAttribute
    public RdcWarehouse get(@RequestParam(required = false) String id) {
        RdcWarehouse entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = rdcWarehouseService.get(id);
        }
        if (entity == null) {
            entity = new RdcWarehouse();
        }
        return entity;
    }

    @RequiresPermissions("sierac:rdcWarehouse:view")
    @RequestMapping(value = { "list", "" })
    public String list(RdcWarehouse rdcWarehouse, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<RdcWarehouse> page = rdcWarehouseService.findPage(new Page<RdcWarehouse>(request, response), rdcWarehouse);
        model.addAttribute("page", page);
        return "sierac/rdcWarehouseList";
    }

    @RequiresPermissions("sierac:rdcWarehouse:view")
    @RequestMapping(value = "form")
    public String form(RdcWarehouse rdcWarehouse, Model model) {
        model.addAttribute("rdcWarehouse", rdcWarehouse);
        rdcWarehouse.setDelFlag("0");
        List<RdcWarehouse> warehouse = rdcWarehouseService.findList(rdcWarehouse);
        RdcWarehouse rdcWarehouse1 =  warehouse.get(0);

        //获取所有warehouse
        List<RdcWarehouse> rs = rdcWarehouseService.findList(new RdcWarehouse());
        List<RdcWarehouse> rs2 = rdcWarehouseService.findList(new RdcWarehouse());
        rs.clear();//清空第一个的所有
        rs.add(rdcWarehouse1);//把修改后的仓库名置于第一个
        for(RdcWarehouse r : rs2){ //将rs2的数据循环加入rs中
            rs.add(r);
        }
        model.addAttribute("warehouse", rs);
        return "sierac/rdcWarehouseForm";
    }

    @RequiresPermissions("sierac:rdcOutHeader:view")
    @ResponseBody
    @RequestMapping(value = "ajax")
    public String ajax(String name, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // String newnameString = new String(name.getBytes("ISO-8859-1"),
        // "UTF-8");
        RdcWarehouse rdcWarehouse = new RdcWarehouse();
        rdcWarehouse.setName(name);
        List<RdcWarehouse> warehouse = rdcWarehouseService.findList(rdcWarehouse);
        return new Gson().toJson(warehouse.get(0));
    }

    @RequiresPermissions("sierac:rdcWarehouse:edit")
    @RequestMapping(value = "save")
    public String save(RdcWarehouse rdcWarehouse, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, rdcWarehouse)) {
            return form(rdcWarehouse, model);
        }
        rdcWarehouseService.save(rdcWarehouse);

        addMessage(redirectAttributes, "保存仓库信息成功");
        return "redirect:" + Global.getAdminPath() + "/sierac/rdcWarehouse/?repage";
    }

    @RequiresPermissions("sierac:rdcWarehouse:edit")
    @RequestMapping(value = "delete")
    public String delete(RdcWarehouse rdcWarehouse, RedirectAttributes redirectAttributes) {
        rdcWarehouseService.delete(rdcWarehouse);
        addMessage(redirectAttributes, "删除仓库信息成功");
        return "redirect:" + Global.getAdminPath() + "/sierac/rdcWarehouse/?repage";
    }

    ///
    @RequiresPermissions("sierac:rdcWarehouse:edit")
    @ResponseBody
    @RequestMapping(value = "checkOrderCode")
    public String checkOrderCode(String oldcode, String code,HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println(oldcode + "," + code);
//        if (code != null && code.equals(oldcode)) {
//            return "true";
//        } else if (code != null && rdcWarehouseService.findByCode(code) == null) {
//            return "true";
//        }
//        return "false";
        String s = new String(request.getParameter("orderCode").getBytes("ISO8859-1"), "UTF-8");// encodeURIComponent编码转换
        if (s != null && s.equals(oldcode)) {
            return "true";// 不重复
        } else if (s != null && rdcWarehouseService.findByCode(s) == null) {
            return "true"; // 不重复
        }
        return "false"; // 重复

    }

    /**
     * 导出仓库数据
     * 
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:rdcWarehouse:view")
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String exportFile(RdcWarehouse rdcWarehouse, HttpServletRequest request, HttpServletResponse response,
            RedirectAttributes redirectAttributes) {
        try {
            String fileName = "仓库信息" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            Page<RdcWarehouse> page = rdcWarehouseService.findPage(new Page<RdcWarehouse>(request, response, -1),
                    rdcWarehouse);
            new ExportExcel("仓库信息", RdcWarehouse.class).setDataList(page.getList()).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导出仓库信息失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + Global.getAdminPath() + "/sierac/rdcWarehouseList?repage";
    }

    /**
     * 导入仓库信息数据
     * 
     * @param file
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:rdcWarehouse:edit")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "sierac/rdcWarehouseList";
        }
        try {
            int successNum = 0;
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();
            ImportExcel ei = new ImportExcel(file, 1, 0);
            List<RdcWarehouse> list = ei.getDataList(RdcWarehouse.class);
            for (RdcWarehouse rdcWarehouse : list) {
                try {
                    if ("".equals(rdcWarehouse.getCode())) {
                        failureMsg.append("<br/>仓库代码 " + rdcWarehouse.getCode() + " 不能为空; ");
                        failureNum++;
                        continue;
                    } else if ("true".equals(check(rdcWarehouse.getCode()))) {
                        BeanValidators.validateWithException(validator, rdcWarehouse);
                        rdcWarehouseService.save(rdcWarehouse);
                        successNum++;
                    } else {
                        failureMsg.append("<br/>仓库代码 " + rdcWarehouse.getCode() + " 已存在; ");
                        failureNum++;
                    }
                } catch (ConstraintViolationException ex) {
                    failureMsg.append("<br/>仓库代码 " + rdcWarehouse.getCode() + " 导入失败：");
                    List<String> messageList = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
                    for (String message : messageList) {
                        failureMsg.append(message + "; ");
                        failureNum++;
                    }
                } catch (Exception ex) {
                    failureMsg.append("<br/>仓库代码 " + rdcWarehouse.getCode() + " 导入失败：" + ex.getMessage());
                }
            }
            if (failureNum > 0) {
                failureMsg.insert(0, "，失败 " + failureNum + " 条仓库信息，导入信息如下：");
            }
            addMessage(redirectAttributes, "已成功导入 " + successNum + " 条仓库信息" + failureMsg);
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入仓库信息失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + Global.getAdminPath() + "/sierac/rdcWarehouse/?repage";
    }

    /**
     * 
     * Description: <br/>
     * 
     * @author majiaJun
     * @param code
     * @return
     */
    @ResponseBody
    @RequiresPermissions("sierac:rdcWarehouse:edit")
    @RequestMapping(value = "check")
    public String check(String code) {
        RdcWarehouse rdcWarehouse = new RdcWarehouse();
        rdcWarehouse.setCode(code);
        List<RdcWarehouse> list = rdcWarehouseService.findList(rdcWarehouse);
        for (RdcWarehouse rdcWarehouseDemo : list) {
            if (rdcWarehouseDemo != null)
                return "false";
        }
        return "true";
    }

    /**
     * 关联用户的操作
     */
    @RequiresPermissions("sierac:rdcWarehouse:view")
    @RequestMapping(value = "formuser")
    public String formuser(RdcWarehouse rdcUser, HttpServletRequest request, HttpServletResponse response, Model model) {// 根据仓库id查询用户信息，返回到关联用户List

        Page<RdcWarehouse> page = rdcWarehouseService.findPageuser(new Page<RdcWarehouse>(request, response), rdcUser);

        model.addAttribute("page", page);
        return "sierac/rdcWarehouseFormuser";
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
            String fileName = "仓库信息.xlsx";
            List<RdcWarehouse> list = Lists.newArrayList();
            RdcWarehouse rdcWarehouse = new RdcWarehouse();
            rdcWarehouse = rdcWarehouseService.findList(new RdcWarehouse()).get(0);
            list.add(rdcWarehouse);
            new ExportExcel("仓库信息", RdcWarehouse.class, 2).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + adminPath + "/sierac/rdcWarehouse/?repage";
    }
}