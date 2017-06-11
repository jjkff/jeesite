/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.net.UnknownHostException;

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

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.QueryReport;
import com.thinkgem.jeesite.sierac.service.QueryReportDetailService;
import com.thinkgem.jeesite.sierac.service.QueryReportService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/queryReport")
public class QueryReportController extends BaseController {

    @Autowired
    private QueryReportService queryReportService;

    @Autowired
    private QueryReportDetailService queryReportDetailService;

    @ModelAttribute
    public QueryReport get(@RequestParam(required = false) String id) {
        QueryReport entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = queryReportService.get(id);
        }
        if (entity == null) {
            entity = new QueryReport();
        }
        return entity;
    }

    @RequiresPermissions("sierac:queryReport:view")
    @RequestMapping(value = { "list", "" })
    public String list(QueryReport queryReport, HttpServletRequest request, HttpServletResponse response, Model model)
            throws UnknownHostException {
        Page<QueryReport> page = queryReportService.findPage(new Page<QueryReport>(request, response), queryReport);
        model.addAttribute("page", page);
        return "sierac/queryReportList";
    }

    @RequiresPermissions("sierac:queryReport:view")
    @RequestMapping(value = "form")
    public String form(String id, Model model) {
        QueryReport rueryReport = queryReportService.get(id);
        model.addAttribute("rdcOutDetail", rueryReport);
        return "sierac/rdcOutDetailForm";
    }

    /**
     * 导出条码信息
     * 
     * @param user
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sierac:queryReport:view")
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String exportFile(QueryReport queryReport, HttpServletRequest request, HttpServletResponse response,
            RedirectAttributes redirectAttributes) {
        try {
            String fileName = "条码信息" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            Page<QueryReport> page = queryReportService.findPage(new Page<QueryReport>(request, response, -1),
                    queryReport);
            new ExportExcel("条码信息", QueryReport.class).setDataList(page.getList()).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导出条码信息失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + Global.getAdminPath() + "/sierac/queryReport?repage";
    }

    /**
     * 
     * Description:添加详情 <br/>
     *
     * @author majiaJun
     * @throws UnknownHostException
     */
    public void insertDetail() throws UnknownHostException {

        // queryReportDetailService.save(queryReportDetail);
    }
}