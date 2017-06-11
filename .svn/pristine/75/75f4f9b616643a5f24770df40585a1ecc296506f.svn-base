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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.common.utils.ValidateToken;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.CodeData;
import com.thinkgem.jeesite.sierac.service.CodeDataService;

@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiCodeDataController extends BaseController {
    @Autowired
    private CodeDataService codeDataService;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/pack/codes/upload", method = RequestMethod.POST, headers = { "Accept=application/json" })
    public String upload(HttpServletRequest request, HttpServletResponse response, @RequestBody String JsonParam)
            throws JsonParseException, JsonMappingException, IOException {
        if (ValidateToken.isToken(request, response)) {

            JavaType javaType = getCollectionType(ArrayList.class, CodeData.class);
            @SuppressWarnings("unchecked")
            List<CodeData> lst = (List<CodeData>) objectMapper.readValue(JsonParam, javaType);
            for (CodeData codeData2 : lst) {
                codeDataService.save(codeData2);// 增加
            }

            return "增加成功";
        }
        return "403";
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}
