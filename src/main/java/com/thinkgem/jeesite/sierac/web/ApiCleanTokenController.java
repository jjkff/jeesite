package com.thinkgem.jeesite.sierac.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.utils.CookieUtils;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiCleanTokenController extends BaseController {
    @RequestMapping(value = "/pack/user/cleanToken", method = RequestMethod.GET)
    @ResponseBody
    public void cleanToken(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("start");
        System.out.println("==========================================");
        Cookie[] cookie1 = request.getCookies();
        System.out.println("长度为:" + cookie1.length);
        for (int i = 0; i < cookie1.length; i++) {
            Cookie cook = cookie1[i];
            System.out.println(cook.getName() + "-------------------" + cook.getValue().toString());
        }
        System.out.println("==========================================");
        // CleanCookieByMjj.remove(request, response, "cookieToken");
        // CleanCookieByMjj.clear(request, response);
        CookieUtils.getCookie(request, response, "cookieToken", true);
        System.out.println("end");
        Cookie[] cookie = request.getCookies();
        System.out.println("长度为:" + cookie.length);
        for (int i = 0; i < cookie.length; i++) {
            Cookie cook = cookie[i];
            System.out.println(cook.getName() + "-------------------" + cook.getValue().toString());
        }
        System.out.println("==========================================");
    }
}