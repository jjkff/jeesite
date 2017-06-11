/**
 * Project Name:JeeSite
 * File Name:TestFileUpload.java
 * Package Name:com.thinkgem.jeesite.sierac.web
 * Date:2017年3月2日下午1:35:50
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.sierac.unitTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Description: <br/>
 * Date: 2017年3月2日 下午1:35:50 <br/>
 * 
 * @author mjj
 * @version
 * @see
 */
public class TestFileUpload {

    @SuppressWarnings("static-access")
    @Test
    public void test01() {
        String zipFileName = "C:\\Users\\mjj\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\jeesite\\uploadFiles\\20170303160852.zip";
        String descFileName = "C:\\Users\\mjj\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\jeesite\\uploadFiles\\20170303160852";
        String test = "C:\\Users\\mjj\\Desktop\\code.txt";
        // String zipFileName =
        // "C:\\Users\\mjj\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\jeesite\\test\\20170302155250.zip";
        // String descFileName =
        // "C:\\Users\\mjj\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\jeesite\\test\\20170302155250";
        // FileUtils fileutil = new FileUtils();
        // fileutil.createDirectory(descFileName);
        // fileutil.unZipFiles(zipFileName, descFileName);
        readTxtFileIntoStringArrList(test);
    }

    /**
     * 写文件方法
     */
    public static List<String> readTxtFileIntoStringArrList(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                    System.out.println("每行的内容是这样的:" + lineTxt);
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        System.out.println("大小为" + list.size());
        return list;
    }
}
