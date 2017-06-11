/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.sierac.entity.*;
import com.thinkgem.jeesite.sierac.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.common.utils.ValidateToken;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * CRUD操作Controller
 * 出库
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiWarehouseOutUpdateController extends BaseController {

    @Autowired
    private RdcOutHeaderService rdcOutHeaderService;

    @Autowired
    private RdcOutDetailService rdcOutDetailService;



    @Autowired
    private ApiRdcOutHeaderService apiRdcOutHeaderService;

    @Autowired
    private ApiRdcOutDetailService apiRdcOutDetailService;

    @Autowired
    private ApiRdcOutDataService apiRdcOutDataService;

    @Autowired
    private CodeDataService codeDataService;

    private static ObjectMapper objectMapper = new ObjectMapper();



    @RequestMapping(value = "/warehouse/out/update", method = RequestMethod.POST, headers = { "Accept=application/json" })
    @ResponseBody
    public void list(ApiRdcOutHeader apiRdcOutHeader, HttpServletRequest request, HttpServletResponse response,
            @RequestBody String JsonParam) throws JsonParseException, JsonMappingException, IOException {
        // apiRdcOutHeader = objectMapper.readValue(JsonParam,
        // ApiRdcOutHeader.class);
        if (ValidateToken.isToken(request, response)) {
            JavaType javaType = getCollectionType(ArrayList.class, ApiRdcOutHeader.class);
            @SuppressWarnings("unchecked")
            List<ApiRdcOutHeader> list = (List<ApiRdcOutHeader>) objectMapper.readValue(JsonParam, javaType);//有个json参数传过来
            CodeData codeData = new CodeData();
            for (int i = 0; i < list.size(); i++) { //遍历这个json
                apiRdcOutHeader = list.get(i);//获取一条数据
                apiRdcOutHeader.setCreateDate(new Date());//设置时间
                apiRdcOutHeader.setUpdateDate(new Date());
                apiRdcOutHeaderService.save(apiRdcOutHeader);//保存
                codeData.setOutHeaderId(apiRdcOutHeader.getId());//设置生产数据的outHeaderId,因为apiRdcOutHeader和codeData有关联
                codeData.setProductId(apiRdcOutHeader.getProduct_id());//设置产品的ProductId因为codeData和product还有关联
                for (int j = 0; j < apiRdcOutHeader.getDetail_list().size(); j++) {
                    //apiRdcOutHeader和ApiRdcOutDetail是一对多关系。
                    ApiRdcOutDetail apiRdcOutDetail = apiRdcOutHeader.getDetail_list().get(j);//取一条
                    apiRdcOutDetailService.save(apiRdcOutDetail);//保存
                    for (int k = 0; k < apiRdcOutDetail.getData_list().size(); k++) {
                        //ApiRdcOutDetail和ApiRdcOutData存在一对多关系
                        ApiRdcOutData apiRdcOutData = apiRdcOutDetail.getData_list().get(k);//取一条
                        codeData.setScan_code(apiRdcOutData.getScan_code());
                        Date date = new Date();
                        codeData.setUpdateDate(date);
                        codeData.setCreateDate(date);
                        codeDataService.updateAll(codeData); //这里肯定没有执行
                        apiRdcOutDataService.save(apiRdcOutData);
                    }
                }
            }
        }
        else{
            response.setStatus(403);
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}