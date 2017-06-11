/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.MacUtils;
import com.thinkgem.jeesite.common.utils.ValidateToken;
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
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiQueryFakeController extends BaseController {
    private int flag = 0;
    @Autowired
    private QueryFakeService queryFakeService;
    @Autowired
    private QueryReportService queryReportService;
    @Autowired
    private QueryReportDetailService queryReportDetailService;
    private JsonMapper JsonMapper;

    @SuppressWarnings("static-access")
    @RequestMapping(value = "/queryFake/list", method = RequestMethod.GET)
    @ResponseBody
    public String list(QueryFake queryFake, HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam String code) throws UnknownHostException {
        if (ValidateToken.isToken(request, response)) {
            queryFake.setcCode(code);
            Page<QueryFake> page = queryFakeService.findPage(new Page<QueryFake>(request, response), queryFake);
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            model.addAttribute("page", page);
            List<QueryFake> list = new ArrayList<QueryFake>();
            if (page != null) {
                for (int i = 0; i < page.getList().size(); i++) {
                    QueryReport queryReport = new QueryReport();
                    QueryFake queryFakeDemo = new QueryFake();
                    queryFakeDemo = page.getList().get(i);
                    queryReport.setqCode(queryFakeDemo.getcCode());
                    if (queryReportService.findAll(queryReport).size() == 0) {
                        queryReportService.save(queryReport);
                        flag = 1;
                    }
                    queryReportService.updateByMine(queryReport);
                    InetAddress queryIp = InetAddress.getLocalHost();// 获取IP地址
                    QueryReportDetail queryReportDetail = new QueryReportDetail();
                    queryReportDetail.setQueryTime(new Date());
                    queryReportDetail.setQueryIp(queryIp.toString());
                    MacUtils mac = new MacUtils();// 获取网卡地址
                    String sysName = mac.getOSName();
                    String location = null;
                    if (sysName.equals("windows 7")) {
                        location = mac.getWindowsMACAddress();
                    }
                    if (sysName.equals("Unix")) {
                        location = mac.getUnixMACAddress();
                    }
                    if (sysName.equals("Linux")) {
                        location = mac.getLinuxMACAddress();
                    }
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
                    // QueryReport queryReport = new QueryReport();
                    queryReport.setqCode(queryFake.getcCode());
                    if (queryReportService.findList(queryReport).size() != 0) {
                        int qty = queryReportService.findList(queryReport).get(0).getqQty();
                        queryFake.setqQty(qty);
                        page.getList().get(0).setqQty(qty);
                    }
                    list.add(page.getList().get(0));
                }
            }
            return JsonMapper.getInstance().toJson(list);
        }
        response.setStatus(403);
        return "403";
    }
}