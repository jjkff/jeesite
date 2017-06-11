/**
 * Project Name:JeeSite
 * File Name:ReadFiles.java
 * Package Name:com.thinkgem.jeesite.sierac.unitTest
 * Date:2017年3月31日上午9:53:20
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.sierac.unitTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

/**
 * Description: <br/>
 * Date: 2017年3月31日 上午9:53:20 <br/>
 * 
 * @author mjj
 * @version
 * @see
 */
public class ReadFiles {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        File f = null;
        f = new File("D:\\fileUpload01");
        File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。
        List<File> list = new ArrayList<File>();
        for (File file : files) {
            list.add(file);
        }
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
            // HttpByMjj httpByMjj = new HttpByMjj();
            // httpByMjj.sendPost("http://localhost:8080/jeesite/a/api/v1/files/upload",
            // "");
            break;
        }
    }
}
