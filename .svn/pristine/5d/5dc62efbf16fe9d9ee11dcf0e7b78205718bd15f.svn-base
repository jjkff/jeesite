/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.common.utils.ValidateToken;
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
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.ApiWarehouseOutScanCheck;
import com.thinkgem.jeesite.sierac.service.ApiWarehouseOutScanCheckService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiWarehouseOutScanCheckController extends BaseController {

    @Autowired
    private ApiWarehouseOutScanCheckService apiWarehouseOutScanCheckService;

    private JsonMapper JsonMapper;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @SuppressWarnings("static-access")
    @RequestMapping(value = "/warehouse/out/scan_check", method = RequestMethod.POST, headers = { "Accept=application/json" })
    @ResponseBody
    public String list(ApiWarehouseOutScanCheck apiWarehouseOutScanCheck, HttpServletRequest request,
            HttpServletResponse response, @RequestBody String JsonParam) throws JsonParseException,
            JsonMappingException, IOException {
        if (ValidateToken.isToken(request, response)) {


            JavaType javaType = getCollectionType(ArrayList.class, ApiWarehouseOutScanCheck.class);
            @SuppressWarnings("unchecked")
            List<ApiWarehouseOutScanCheck> listDemo = (List<ApiWarehouseOutScanCheck>) objectMapper.readValue(JsonParam,
                    javaType);
            List<List<ApiWarehouseOutScanCheck>> list = new ArrayList <List<ApiWarehouseOutScanCheck>>();
            for (int i = 0; i < listDemo.size(); i++) {
                apiWarehouseOutScanCheck = listDemo.get(i);
                List<ApiWarehouseOutScanCheck> apiWarehouseOutScanCheckList = apiWarehouseOutScanCheckService
                        .findAll(apiWarehouseOutScanCheck);
                list.add(apiWarehouseOutScanCheckList);
            }
            return JsonMapper.getInstance().toJson(list);
        }
        response.setStatus(403);
        return "403";
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}