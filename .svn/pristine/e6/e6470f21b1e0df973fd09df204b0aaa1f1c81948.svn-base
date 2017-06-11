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
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.QueryReportDetail;
import com.thinkgem.jeesite.sierac.service.QueryReportDetailService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/queryReportDetail")
public class QueryReportDetailController extends BaseController {

    @Autowired
    private QueryReportDetailService queryReportDetailService;

    @RequiresPermissions("sierac:queryReportDetail:view")
    @RequestMapping(value = { "list", "" })
    public String list(QueryReportDetail queryReportDetail, HttpServletRequest request, HttpServletResponse response,
            Model model, String id) {
        queryReportDetail.setQrId(id);
        Page<QueryReportDetail> page = queryReportDetailService.findPage(
                new Page<QueryReportDetail>(request, response), queryReportDetail);
        // Page<QueryReport> page = queryReportService.findPage(new
        // Page<QueryReport>(request, response), queryReport);
        model.addAttribute("page", page);
        return "sierac/queryReportDetailList";
    }

}