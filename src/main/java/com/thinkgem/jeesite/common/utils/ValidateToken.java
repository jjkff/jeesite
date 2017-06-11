/**
 * Project Name:JeeSite
 * File Name:ValidateToken.java
 * Package Name:com.thinkgem.jeesite.common.utils
 * Date:2017年4月7日下午4:24:06
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Description: <br/>
 * Date: 2017年4月7日 下午4:24:06 <br/>
 * 
 * @author mjj
 * @version
 * @see
 */
public class ValidateToken {
    public static boolean isToken(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String token = "";
        String stoken = "";
        if (session.getAttribute("sessionToken") != null)
            stoken = session.getAttribute("sessionToken").toString();
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            System.out.println("长度为:" + cookie.length);
            for (int i = 0; i < cookie.length; i++) {
                Cookie cook = cookie[i];
                System.out.println(cook.getName() + "-------------------" + cook.getValue().toString());
                if (cook.getName().equalsIgnoreCase("cookieToken")) { // 获取键
                    token = cook.getValue().toString();
                    System.out.println("获取到的token是:" + token);
                }
            }
        }
        System.out.println(stoken + "," + token);
        if (stoken.equals(token) && stoken != "") {
            System.out.println("返回的是true");
            return true;
        }
        System.out.println("返回的是false");
        return false;
    }
}
