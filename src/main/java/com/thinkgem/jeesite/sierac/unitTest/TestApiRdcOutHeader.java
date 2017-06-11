package com.thinkgem.jeesite.sierac.unitTest;

import com.thinkgem.jeesite.sierac.entity.ApiRdcOutHeader;
import com.thinkgem.jeesite.sierac.service.ApiRdcOutHeaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jkf on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class TestApiRdcOutHeader {

    @Autowired
    private ApiRdcOutHeaderService apiRdcOutHeaderService;
    @Test
    public void testRdcOut(){
        ApiRdcOutHeader rdcOutHeader = new ApiRdcOutHeader();
        rdcOutHeader.setId("aaa");
        rdcOutHeader.setCode("0909090");
        apiRdcOutHeaderService.save(rdcOutHeader);

//          ApiRdcOutHeader apiRdcOutHeader =  apiRdcOutHeaderService.get("123");
//          System.out.print(apiRdcOutHeader);
    }

}
