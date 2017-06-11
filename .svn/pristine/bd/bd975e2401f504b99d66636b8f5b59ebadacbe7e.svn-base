/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.RdcOutDetail;
import com.thinkgem.jeesite.sierac.service.RdcOutDetailService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/rdcOutDetail")
public class RdcOutDetailController extends BaseController {

    @Autowired
    private RdcOutDetailService rdcOutDetailService;

    @ModelAttribute
    public RdcOutDetail get(@RequestParam(required = false) String id) {
        RdcOutDetail entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = rdcOutDetailService.get(id);
        }
        if (entity == null) {
            entity = new RdcOutDetail();
        }
        return entity;
    }

    @RequiresPermissions("sierac:rdcOutDetail:view")
    @RequestMapping(value = { "list", "" })
    public String list(RdcOutDetail rdcOutDetail, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<RdcOutDetail> page = rdcOutDetailService.findPage(new Page<RdcOutDetail>(request, response), rdcOutDetail);
        model.addAttribute("page", page);
        return "sierac/rdcOutDetailList";
    }

    @RequiresPermissions("sierac:rdcOutDetail:view")
    @RequestMapping(value = "form")
    public String form(String id, Model model) {
        RdcOutDetail rdcOutDetail = rdcOutDetailService.get(id);
        model.addAttribute("rdcOutDetail", rdcOutDetail);
        return "sierac/rdcOutDetailForm";
    }

    /**
     * 导出出库单明细数据
     * 
     * @param user
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:rdcOutDetail:view")
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String exportFile(RdcOutDetail rdcOutDetail, HttpServletRequest request, HttpServletResponse response,
            RedirectAttributes redirectAttributes) {
        try {
            String fileName = "出库单明细数据" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            Page<RdcOutDetail> page = rdcOutDetailService.findPage(new Page<RdcOutDetail>(request, response, -1),
                    rdcOutDetail);
            new ExportExcel("出库单明细数据", RdcOutDetail.class).setDataList(page.getList()).write(response, fileName)
                    .dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导出出库单明细失败！失败信息：" + e.getMessage());
        }
        return "sierac/rdcOutDetailList";
    }
}