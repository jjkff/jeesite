/**
 * Project Name:JeeSite
 * File Name:HttpTest.java
 * Package Name:com.thinkgem.jeesite.sierac.unitTest
 * Date:2017年3月31日下午3:00:00
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.sierac.unitTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.thinkgem.jeesite.common.utils.HttpByMjj;

//
//

/**
 * Description: <br/>
 * Date: 2017年3月31日 下午3:00:00 <br/>
 *
 * @author mjj
 * @version
 * @see
 */
public class HttpTest {
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws ClientProtocolException, IOException {
        HttpByMjj httpByMjj = new HttpByMjj();
        for (int i = 0; i < 1; i++) {
                httpByMjj.uploadFile("http://localhost:9756/a/api/v1/files/upload", //在ideal上测试可以使用这个url
                    "D:\\T05001708220170228004170228200054.zip");
//            httpByMjj.uploadFile("http://localhost:9756/a/api/v1/files/upload", // 在myeclipse上测试可以使用这个url
//                    "D:\\T05001708220170228004170228200054.zip");
//            System.out.println("mjj:" + i);
        }
    }
}
