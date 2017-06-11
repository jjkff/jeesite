/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.RdcReturnDetail;
import com.thinkgem.jeesite.sierac.service.RdcReturnDetailService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/rdcReturnDetail")
public class RdcReturnDetailController extends BaseController {

    @Autowired
    private RdcReturnDetailService rdcReturnDetailService;

    @ModelAttribute
    public RdcReturnDetail get(@RequestParam(required = false) String id) {
        RdcReturnDetail entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = rdcReturnDetailService.get(id);
        }
        if (entity == null) {
            entity = new RdcReturnDetail();
        }
        return entity;
    }

    @RequiresPermissions("sierac:rdcReturnDetail:view")
    @RequestMapping(value = { "list", "" })
    public String list(RdcReturnDetail rdcReturnDetail, HttpServletRequest request, HttpServletResponse response,
            Model model) {
        Page<RdcReturnDetail> page = rdcReturnDetailService.findPage(new Page<RdcReturnDetail>(request, response),
                rdcReturnDetail);
        model.addAttribute("page", page);
        return "sierac/rdcReturnDetailList";
    }

    @RequiresPermissions("sierac:rdcReturnDetail:view")
    @RequestMapping(value = "form")
    public String form(String id, Model model) {
        RdcReturnDetail rdcReturnDetail = rdcReturnDetailService.get(id);
        model.addAttribute("rdcReturnDetail", rdcReturnDetail);
        return "sierac/rdcReturnDetailForm";
    }

    /**
     * 导出用户数据
     * 
     * @param user
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:rdcReturnDetail:view")
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String exportFile(RdcReturnDetail rdcReturnDetail, HttpServletRequest request, HttpServletResponse response,
            RedirectAttributes redirectAttributes) {
        try {
            String fileName = "退货单据明细" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            Page<RdcReturnDetail> page = rdcReturnDetailService.findPage(new Page<RdcReturnDetail>(request, response,
                    -1), rdcReturnDetail);
            new ExportExcel("退货单据明细", RdcReturnDetail.class).setDataList(page.getList()).write(response, fileName)
                    .dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导出退货单据明细失败！失败信息：" + e.getMessage());
        }
        return "sierac/rdcReturnDetailList";
    }

    /**
     * 导入用户数据
     * 
     * @param file
     * @param redirectAttributes
     * @return
     */
    // @RequiresPermissions("sierac:rdcOutDetail:edit")
    // @RequestMapping(value = "import", method = RequestMethod.POST)
    // public String importFile(MultipartFile file, RedirectAttributes
    // redirectAttributes) {
    // if (Global.isDemoMode()) {
    // addMessage(redirectAttributes, "演示模式，不允许操作！");
    // return "sierac/rdcOutDetailList";
    // }
    // try {
    // int successNum = 0;
    // int failureNum = 0;
    // StringBuilder failureMsg = new StringBuilder();
    // ImportExcel ei = new ImportExcel(file, 1, 0);
    // List<RdcOutDetail> list = ei.getDataList(RdcOutDetail.class);
    // for (RdcOutDetail rdcOutDetail : list) {
    // try {
    // if ("true".equals(checkOrderCode(rdcOutDetail.getOrderCode()))) {
    //
    // BeanValidators.validateWithException(validator, rdcOutDetail);
    // rdcOutDetailService.save(rdcOutDetail);
    // successNum++;
    // } else {
    // failureMsg.append("<br/>登录名 " + rdcOutDetail.getOrderCode() + " 已存在; ");
    // failureNum++;
    // }
    // } catch (ConstraintViolationException ex) {
    // failureMsg.append("<br/>登录名 " + rdcOutDetail.getOrderCode() + " 导入失败：");
    // List<String> messageList =
    // BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
    // for (String message : messageList) {
    // failureMsg.append(message + "; ");
    // failureNum++;
    // }
    // } catch (Exception ex) {
    // failureMsg.append("<br/>登录名 " + rdcOutDetail.getOrderCode() + " 导入失败：" +
    // ex.getMessage());
    // }
    // }
    // if (failureNum > 0) {
    // failureMsg.insert(0, "，失败 " + failureNum + " 条用户，导入信息如下：");
    // }
    // addMessage(redirectAttributes, "已成功导入 " + successNum + " 条用户" +
    // failureMsg);
    // } catch (Exception e) {
    // addMessage(redirectAttributes, "导入用户失败！失败信息：" + e.getMessage());
    // }
    // return "sierac/rdcOutDetailList";
    // }

    /**
     * 下载导入用户数据模板
     *
     * @param response
     * @param redirectAttributes
     * @return
     */
    // @RequiresPermissions("sys:user:view")
    // @RequestMapping(value = "import/template")
    // public String importFileTemplate(HttpServletResponse response,
    // RedirectAttributes redirectAttributes) {
    // try {
    // String fileName = "用户数据导入模板.xlsx";
    // List<User> list = Lists.newArrayList();
    // list.add(UserUtils.getUser());
    // new ExportExcel("用户数据", User.class, 2).setDataList(list).write(response,
    // fileName).dispose();
    // return null;
    // } catch (Exception e) {
    // addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
    // }
    // return "redirect:" + adminPath + "/sys/user/list?repage";
    // }
    /**
 * 
 */
    @ResponseBody
    @RequiresPermissions("sierac:rdcOutDetail:edit")
    @RequestMapping(value = "checkOrderCode")
    public String checkOrderCode(String orderCode) {
        RdcReturnDetail rdcReturnDetail = new RdcReturnDetail();
        if (orderCode != null) {
            rdcReturnDetail.setOrderCode(orderCode);
            List<RdcReturnDetail> list = rdcReturnDetailService.findList(rdcReturnDetail);
            for (RdcReturnDetail rdcReturnDetailDemo : list) {
                if (rdcReturnDetailDemo.getOrderCode() == null)
                    return "true";
                else
                    return "false";
            }
        }
        return "true";
    }
}