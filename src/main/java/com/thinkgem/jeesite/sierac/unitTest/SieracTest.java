/**
 * Project Name:JeeSite
 * File Name:TestFileUpload.java
 * Package Name:com.thinkgem.jeesite.sierac.web
 * Date:2017年3月2日下午1:35:50
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 */

package com.thinkgem.jeesite.sierac.unitTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkgem.jeesite.sierac.entity.QueryFake;
import com.thinkgem.jeesite.sierac.entity.QueryReport;
import com.thinkgem.jeesite.sierac.entity.RdcOutDetail;
import com.thinkgem.jeesite.sierac.entity.RdcOutHeader;
import com.thinkgem.jeesite.sierac.entity.RdcReturnDetail;
import com.thinkgem.jeesite.sierac.entity.RdcReturnHeader;
import com.thinkgem.jeesite.sierac.entity.RdcWarehouse;
import com.thinkgem.jeesite.sierac.service.QueryFakeService;
import com.thinkgem.jeesite.sierac.service.QueryReportDetailService;
import com.thinkgem.jeesite.sierac.service.QueryReportService;
import com.thinkgem.jeesite.sierac.service.RdcOutDetailService;
import com.thinkgem.jeesite.sierac.service.RdcOutHeaderService;
import com.thinkgem.jeesite.sierac.service.RdcReturnDetailService;
import com.thinkgem.jeesite.sierac.service.RdcReturnHeaderService;
import com.thinkgem.jeesite.sierac.service.RdcWarehouseService;

/**
 * Description: <br/>
 * Date: 2017年3月2日 下午1:35:50 <br/>
 * 
 * @author mjj
 * @version
 * 
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class SieracTest {
    @Autowired
    private RdcWarehouseService rdcWarehouseService;

    @Autowired
    private RdcOutHeaderService rdcOutHeaderService;

    @Autowired
    private RdcOutDetailService rdcOutDetailService;

    @Autowired
    private RdcReturnHeaderService rdcReturnHeaderService;

    @Autowired
    private RdcReturnDetailService rdcReturnDetailService;

    @Autowired
    private QueryReportService queryReportService;

    @Autowired
    private QueryReportDetailService queryReportDetailService;

    @Autowired
    private QueryFakeService queryFakeService;

    /**
     * 
     * Description: 仓库管理<br/>
     * 
     * @author mjj
     */
    @Test
    public void test01() {
        RdcWarehouse rdcWarehouse = new RdcWarehouse();
        List<RdcWarehouse> list = rdcWarehouseService.findList(rdcWarehouse);
        System.out.println(list.size());
    }

    /**
     * 
     * Description: 出库单据<br/>
     * 
     * @author mjj
     */
    @Test
    public void test02() {
        RdcOutHeader rdcOutHeader = new RdcOutHeader();
        List<RdcOutHeader> list = rdcOutHeaderService.findList(rdcOutHeader);
        System.out.println(list.size());
    }

    /**
     * 
     * Description: 出库单据明细<br/>
     * 
     * @author mjj
     */
    @Test
    public void test03() {
        RdcOutDetail rdcOutDetail = new RdcOutDetail();
        List<RdcOutDetail> list = rdcOutDetailService.findList(rdcOutDetail);
        System.out.println(list.size());
    }

    /**
     * 
     * Description: 退货单据<br/>
     * 
     * @author mjj
     */
    @Test
    public void test04() {
        RdcReturnHeader rdcReturnHeader = new RdcReturnHeader();
        List<RdcReturnHeader> list = rdcReturnHeaderService.findList(rdcReturnHeader);
        System.out.println(list.size());
    }

    /**
     * 
     * Description: 退货单据明细<br/>
     * 
     * @author mjj
     */
    @Test
    public void test05() {
        RdcReturnDetail rdcReturnDetail = new RdcReturnDetail();
        List<RdcReturnDetail> list = rdcReturnDetailService.findList(rdcReturnDetail);
        System.out.println(list.size());
    }

    /**
     * 
     * Description: 条码查询统计<br/>
     * 
     * @author mjj
     */
    @Test
    public void test06() {
        QueryReport queryReport = new QueryReport();
        List<QueryReport> list = queryReportService.findList(queryReport);
        System.out.println(list.size());
    }

    /**
     * 
     * Description: 防窜货查询<br/>
     * 
     * @author mjj
     */
    @Test
    public void test07() {
        QueryFake queryFake = new QueryFake();
        List<QueryFake> list = queryFakeService.findList(queryFake);
        System.out.println(list.size());
    }

}
