package com.thinkgem.jeesite.sierac.unitTest;

import com.thinkgem.jeesite.sierac.dao.ProductionTaskDao;
import com.thinkgem.jeesite.sierac.dao.RdcOutHeaderDao;
import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.entity.ProductionTask;
import com.thinkgem.jeesite.sierac.entity.RdcOutHeader;
import com.thinkgem.jeesite.sierac.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jkf on 2017/4/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class TestFindByCode {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductionTaskDao productionTaskDao;

    @Autowired
    private RdcOutHeaderDao rdcOutHeaderDao;

    @Test
    public void testfindByCode(){

//        ProductionTask productionTask = productionTaskDao.findByCode("3232www");
//        System.out.print(productionTask.getName());
//          if(productionTaskDao.findByCode("3232www") == null){
//            System.out.print(0);
//        }

//        if(productService.findByCode("1212121")== null){
//            System.out.print(0);
//        }
//
//        Product product = productService.findByCode("1212121");

        RdcOutHeader rdcOutHeader =  rdcOutHeaderDao.findByCode("零零落落啊");


    }


}
