///**
// * Project Name:JeeSite
// * File Name:CleanToken.java
// * Package Name:com.thinkgem.jeesite.sierac.unitTest
// * Date:2017年4月7日下午4:40:34
// * Copyright (c) 2017, bluemobi All Rights Reserved.
// *
// */
//
//package com.thinkgem.jeesite.sierac.unitTest;
//
//import java.util.Enumeration;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.junit.Test;
//
///**
// * Description: <br/>
// * Date: 2017年4月7日 下午4:40:34 <br/>
// * 
// * @author mjj
// * @version
// * @see
// */
//public class CleanToken {
//
//    @Test
//    public void test(HttpServletResponse response, HttpServletRequest request) {
//        /**
//         * 删除所有cookie
//         */
//
//        Cookie[] cookies = request.getCookies();
//
//        for (Cookie cookie : cookies) {
//
//            cookie.setMaxAge(0);
//
//            cookie.setPath("/");
//
//            response.addCookie(cookie);
//
//        }
//
//        /**
//         * 删除所有session
//         */
//        @SuppressWarnings("rawtypes")
//        Enumeration em = request.getSession().getAttributeNames();
//        while (em.hasMoreElements()) {
//            request.getSession().removeAttribute(em.nextElement().toString());
//        }
//    }
// }
