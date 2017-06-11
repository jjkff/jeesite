/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.AddressUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.UserIP;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.QueryFake;
import com.thinkgem.jeesite.sierac.entity.QueryReport;
import com.thinkgem.jeesite.sierac.entity.QueryReportDetail;
import com.thinkgem.jeesite.sierac.service.QueryFakeService;
import com.thinkgem.jeesite.sierac.service.QueryReportDetailService;
import com.thinkgem.jeesite.sierac.service.QueryReportService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/queryFake")
public class QueryFakeController extends BaseController {
    private int flag = 0;

    @Autowired
    private QueryFakeService queryFakeService;

    @Autowired
    private QueryReportService queryReportService;

    @Autowired
    private QueryReportDetailService queryReportDetailService;

    @ModelAttribute
    public QueryFake get(@RequestParam(required = false) String id) {
        QueryFake entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = queryFakeService.get(id);
        }
        if (entity == null) {
            entity = new QueryFake();
        }
        return entity;
    }

    @RequiresPermissions("sierac:queryFake:view")
    @RequestMapping(value = { "list", "" })
    public String list(QueryFake queryFake, HttpServletRequest request, HttpServletResponse response, Model model)
            throws UnknownHostException, UnsupportedEncodingException {
        Page<QueryFake> page = queryFakeService.findPage(new Page<QueryFake>(request, response), queryFake);
        if (page.getList().size() == 1) {
            queryFake = page.getList().get(0);
            QueryReport queryReport = new QueryReport();
            queryReport.setqCode(queryFake.getcCode());
            if (queryReportService.findAll(queryReport).size() == 0) {
                queryReportService.save(queryReport);
                flag = 1;
            }
            queryReportService.updateByMine(queryReport);
            String queryIp = UserIP.getIP();// 获取IP地址
            QueryReportDetail queryReportDetail = new QueryReportDetail();
            queryReportDetail.setQueryTime(new Date());// 获取时间
            queryReportDetail.setQueryIp(queryIp);
            String location = new AddressUtils().getAddresses("ip=" + queryIp, "utf-8");// 根据ip获取所在地
            System.out.println("----------------------" + location);
            queryReportDetail.setLocation(location);
            if (flag == 0) {
                queryReportDetail.setQueryReportId(queryReportService.findAll(queryReport).get(0).getId());
            } else {
                queryReportDetail.setQueryReportId(queryReport.getId());
                flag = 0;
            }
            queryReportDetailService.save(queryReportDetail);

            /**
             * 获取查询次数
             */
            QueryReport queryReport1 = new QueryReport();
            queryReport1.setqCode(queryFake.getcCode());
            if (queryReportService.findList(queryReport1).size() != 0) {
                int qty = queryReportService.findList(queryReport1).get(0).getqQty();
                queryFake.setqQty(qty);
            }
        }
        model.addAttribute("queryFake", queryFake);
        return "sierac/queryFakeList";
    }
}