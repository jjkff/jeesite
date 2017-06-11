/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.thinkgem.jeesite.common.utils.ValidateToken;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.RdcOutHeader;
import com.thinkgem.jeesite.sierac.service.RdcOutHeaderService;

/**
 * CRUD操作Controller
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiWarehouseOutListController extends BaseController {

    @Autowired
    private RdcOutHeaderService rdcOutHeaderService;

    private JsonMapper JsonMapper;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @SuppressWarnings("static-access")
    @RequestMapping(value = "/warehouse/out/list", method = RequestMethod.POST, headers = { "Accept=application/json" })
    @ResponseBody
    public String list(RdcOutHeader rdcOutHeader, HttpServletRequest request, HttpServletResponse response,
            @RequestBody String JsonParam) throws JsonParseException, JsonMappingException, IOException {
        if (ValidateToken.isToken(request, response)) {
            JavaType javaType = getCollectionType(ArrayList.class, RdcOutHeader.class);
            @SuppressWarnings("unchecked")
            List<RdcOutHeader> listDemo = (List<RdcOutHeader>) objectMapper.readValue(JsonParam, javaType);
            List<List<RdcOutHeader>> list = new ArrayList<List<RdcOutHeader>>();
            for (int i = 0; i < listDemo.size(); i++) {
                rdcOutHeader = listDemo.get(i);
                List<RdcOutHeader> rdcOutHeaderList = rdcOutHeaderService.findAll(rdcOutHeader);
                list.add(rdcOutHeaderList);
            }
            return JsonMapper.getInstance().toJson(list);
        }
        response.setStatus(403);
        return "error/403";
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}