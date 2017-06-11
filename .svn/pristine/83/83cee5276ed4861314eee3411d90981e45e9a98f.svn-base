/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

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
import com.google.gson.Gson;
import com.thinkgem.jeesite.common.beanvalidator.BeanValidators;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.RdcReturnHeader;
import com.thinkgem.jeesite.sierac.entity.RdcWarehouse;
import com.thinkgem.jeesite.sierac.service.RdcReturnHeaderService;
import com.thinkgem.jeesite.sierac.service.RdcWarehouseService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-14
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/rdcReturnHeader")
public class RdcReturnHeaderController extends BaseController {

    @Autowired
    private RdcReturnHeaderService rdcReturnHeaderService;

    @Autowired
    private RdcWarehouseService rdcWarehouseService;

    @ModelAttribute
    public RdcReturnHeader get(@RequestParam(required = false) String id) {
        RdcReturnHeader entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = rdcReturnHeaderService.get(id);
        }
        if (entity == null) {
            entity = new RdcReturnHeader();
        }
        return entity;
    }

    @RequiresPermissions("sierac:rdcReturnHeader:view")
    @RequestMapping(value = { "list", "" })
    public String list(RdcReturnHeader rdcReturnHeader, HttpServletRequest request, HttpServletResponse response,
            Model model) {
        Page<RdcReturnHeader> page = rdcReturnHeaderService.findPage(new Page<RdcReturnHeader>(request, response),
                rdcReturnHeader);
        model.addAttribute("page", page);
        return "sierac/rdcReturnHeaderList";
    }

    @RequiresPermissions("sierac:rdcReturnHeader:view")
    @RequestMapping(value = "form")
    public String form(RdcReturnHeader rdcReturnHeader, Model model) {
        model.addAttribute("rdcReturnHeader", rdcReturnHeader);
        RdcWarehouse rdcWarehouse = new RdcWarehouse();
        rdcWarehouse.setDelFlag("0");
        List<RdcWarehouse> warehouse = rdcWarehouseService.findList(rdcWarehouse);
        model.addAttribute("warehouse", warehouse);
        return "sierac/rdcReturnHeaderForm";
    }

    @RequiresPermissions("sierac:rdcReturnHeader:view")
    @ResponseBody
    @RequestMapping(value = "ajax")
    public String ajax(String name, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RdcWarehouse rdcWarehouse = new RdcWarehouse();
        rdcWarehouse.setName(name);
        List<RdcWarehouse> warehouse = rdcWarehouseService.findList(rdcWarehouse);
        return new Gson().toJson(warehouse.get(0));
    }

    @RequiresPermissions("sierac:rdcReturnHeader:view")
    @ResponseBody
    @RequestMapping(value = "ajaxOrderCode")
    public boolean ajaxOrderCode(String orderCode, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        RdcWarehouse rdcWarehouse = new RdcWarehouse();
        rdcWarehouse.setCode(orderCode);
        List<RdcWarehouse> warehouse = rdcWarehouseService.findList(rdcWarehouse);
        if (warehouse.size() == 0)
            return true;
        return false;
    }

    @RequiresPermissions("sierac:rdcReturnHeader:edit")
    @RequestMapping(value = "save")
    public String save(RdcReturnHeader rdcReturnHeader, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, rdcReturnHeader)) {
            return form(rdcReturnHeader, model);
        }
        rdcReturnHeaderService.save(rdcReturnHeader);
        addMessage(redirectAttributes, "保存退货单据信息成功");
        return "redirect:" + Global.getAdminPath() + "/sierac/rdcReturnHeader/?repage";
    }

    @RequiresPermissions("sierac:rdcReturnHeader:edit")
    @RequestMapping(value = "delete")
    public String delete(RdcReturnHeader rdcReturnHeader, RedirectAttributes redirectAttributes) {
        rdcReturnHeaderService.delete(rdcReturnHeader);
        addMessage(redirectAttributes, "删除退货单据信息成功");
        return "redirect:" + Global.getAdminPath() + "/sierac/rdcReturnHeader/?repage";
    }

    /**
     * 导出退货单据数据
     * 
     * @param user
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:rdcReturnHeader:view")
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String exportFile(RdcReturnHeader rdcReturnHeader, HttpServletRequest request, HttpServletResponse response,
            RedirectAttributes redirectAttributes) {
        try {
            String fileName = "退货单据信息" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            Page<RdcReturnHeader> page = rdcReturnHeaderService.findPage(new Page<RdcReturnHeader>(request, response,
                    -1), rdcReturnHeader);
            new ExportExcel("退货单据信息", RdcReturnHeader.class).setDataList(page.getList()).write(response, fileName)
                    .dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导出退货单据信息失败！失败信息：" + e.getMessage());
        }
        return "sierac/rdcReturnHeaderList";
    }

    /**
     * 导入退货单据信息数据
     * 
     * @param file
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:rdcReturnHeader:edit")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "sierac/rdcReturnHeaderList";
        }
        try {
            int successNum = 0;
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();
            ImportExcel ei = new ImportExcel(file, 1, 0);
            List<RdcReturnHeader> list = ei.getDataList(RdcReturnHeader.class);
            for (RdcReturnHeader rdcReturnHeader : list) {
                try {
                    if ("".equals(rdcReturnHeader.getOrderCode())) {
                        failureMsg.append("<br/>退货单号 " + rdcReturnHeader.getOrderCode() + " 不能为空; ");
                        failureNum++;
                        continue;
                    } else if ("true".equals(check(rdcReturnHeader.getOrderCode()))) {
                        BeanValidators.validateWithException(validator, rdcReturnHeader);
                        rdcReturnHeaderService.save(rdcReturnHeader);
                        System.out.println("32143512421351242141241");
                        successNum++;
                    } else {
                        failureMsg.append("<br/>退货单号 " + rdcReturnHeader.getOrderCode() + " 已存在; ");
                        failureNum++;
                    }
                } catch (ConstraintViolationException ex) {
                    failureMsg.append("<br/>退货单号 " + rdcReturnHeader.getOrderCode() + " 导入失败：");
                    List<String> messageList = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
                    for (String message : messageList) {
                        failureMsg.append(message + "; ");
                        failureNum++;
                    }
                } catch (Exception ex) {
                    failureMsg.append("<br/>退货单号 " + rdcReturnHeader.getOrderCode() + " 导入失败：" + ex.getMessage());
                }
            }
            if (failureNum > 0) {
                failureMsg.insert(0, "，失败 " + failureNum + " 条退货单据信息，导入信息如下：");
            }
            addMessage(redirectAttributes, "已成功导入 " + successNum + " 条退货单据信息" + failureMsg);
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入退货单据信息失败！失败信息：" + e.getMessage());
        }

        return "redirect:" + Global.getAdminPath() + "/sierac/rdcReturnHeader/?repage";
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
    @RequiresPermissions("sierac:rdcReturnHeader:edit")
    @RequestMapping(value = "check")
    public String check(String code) {
        RdcReturnHeader rdcReturnHeader = new RdcReturnHeader();
        rdcReturnHeader.setOrderCode(code);
        List<RdcReturnHeader> list = rdcReturnHeaderService.findList(rdcReturnHeader);
        for (RdcReturnHeader rdcReturnHeaderDemo : list) {
            if (rdcReturnHeaderDemo != null)
                return "false";
        }
        return "true";
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
            String fileName = "退货单据.xlsx";
            List<RdcReturnHeader> list = Lists.newArrayList();
            RdcReturnHeader rdcReturnHeader = new RdcReturnHeader();
            rdcReturnHeader = rdcReturnHeaderService.findList(new RdcReturnHeader()).get(0);
            list.add(rdcReturnHeader);
            new ExportExcel("退货单据", RdcReturnHeader.class, 2).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + adminPath + "/sierac/rdcOutHeader/?repage";
    }

    @ResponseBody
    @RequiresPermissions("sierac:product:edit")
    @RequestMapping(value = "checkOrderCode")
    public String checkOrderCode(HttpServletRequest request ,String oldcode, String orderCode) throws UnsupportedEncodingException {
        String s = new String(request.getParameter("orderCode").getBytes("ISO8859-1"), "UTF-8");//encodeURIComponent编码转换
        if (s !=null && s.equals(oldcode)) {
            return "true";//不重复
        } else if (s !=null && rdcReturnHeaderService.findByCode(s)==null) {
            return "true"; //不重复
        }
        return "false"; //重复
    }
}