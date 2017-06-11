/**
 * Project Name:JeeSite
 * File Name:CleanSql.java
 * Package Name:com.thinkgem.jeesite.sierac.unitTest
 * Date:2017年4月20日上午10:13:29
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.sierac.unitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkgem.jeesite.sierac.dao.CodeDataDao;
import com.thinkgem.jeesite.sierac.dao.ProductDao;
import com.thinkgem.jeesite.sierac.dao.ProductionTaskDao;
import com.thinkgem.jeesite.sierac.dao.QueryReportDao;
import com.thinkgem.jeesite.sierac.dao.QueryReportDetailDao;
import com.thinkgem.jeesite.sierac.dao.RdcOutDetailDao;
import com.thinkgem.jeesite.sierac.dao.RdcOutHeaderDao;
import com.thinkgem.jeesite.sierac.dao.RdcReturnDetailDao;
import com.thinkgem.jeesite.sierac.dao.RdcReturnHeaderDao;
import com.thinkgem.jeesite.sierac.dao.RdcWarehouseDao;
import com.thinkgem.jeesite.sierac.dao.rdcUserDao;

/**
 * Description: <br/>
 * Date: 2017年4月20日 上午10:13:29 <br/>
 * 
 * @author mjj
 * @version
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class CleanSql {
    @Autowired
    RdcWarehouseDao rdcWarehouseDao;

    @Autowired
    CodeDataDao codeDataDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductionTaskDao productionTaskDao;

    @Autowired
    RdcOutHeaderDao rdcOutHeaderDao;

    @Autowired
    RdcOutDetailDao rdcOutDetailDao;

    @Autowired
    RdcReturnHeaderDao rdcReturnHeaderDao;

    @Autowired
    RdcReturnDetailDao rdcReturnDetailDao;

    @Autowired
    QueryReportDao queryReportDao;

    @Autowired
    QueryReportDetailDao queryReportDetailDao;

    @Autowired
    rdcUserDao rdcuserDao;

    @Test
    public void test() {
        rdcWarehouseDao.truncate("rdc_warehouse");
        codeDataDao.truncate("code_data");
        productDao.truncate("product");
        productionTaskDao.truncate("productiontask");
        rdcOutHeaderDao.truncate("rdc_out_header");
        rdcOutDetailDao.truncate("rdc_out_detail");
        rdcReturnHeaderDao.truncate("rdc_return_header");
        rdcReturnDetailDao.truncate("rdc_return_detail");
        queryReportDao.truncate("query_report");
        queryReportDetailDao.truncate("query_report_detail");
        rdcuserDao.truncate("user_warehouse");
    }

}
