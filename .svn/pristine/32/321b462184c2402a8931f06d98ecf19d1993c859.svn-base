/**
 * Project Name:JeeSite
 * File Name:HttpByMjj.java
 * Package Name:com.thinkgem.jeesite.common.utils
 * Date:2017年4月1日上午8:30:30
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.common.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.avalon.framework.parameters.ParameterException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Description: <br/>
 * Date: 2017年4月1日 上午8:30:30 <br/>
 *
 * @author mjj
 * @version
 * @see
 */
public class HttpByMjj {
    /**
     * get请求 Demo: String s =
     * sendGet("http://localhost:8080/jeesite/a/api/v1/files/upload",
     * "key=123&v=456"); System.out.println("*****************" + s);
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * post请求 Demo: String
     * sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString"
     * ,"key=123&v=456"); System.out.println(sr);
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * http inputstream上传
     *
     * @throws IOException
     */

    public static void uploadFile(String urlName, String fileName) throws IOException {
        File fi = new File(fileName);
        InputStream instream = new FileInputStream(fi);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(urlName);
        InputStreamEntity inputEntry = new InputStreamEntity(instream);
        httpPost.setEntity(inputEntry);
         CloseableHttpResponse response2 = httpclient.execute(httpPost);
        response2.close();
        httpclient.close();
    }

    public static List<String>  readTxtFile(String filePath) throws FileNotFoundException {
        List<String> arrayLists = new ArrayList<String>();
        try{
            String encoing = "GBK";

            File file = new File(filePath);
            if(file.isFile() && file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoing);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                String arrayStr[] = new String[20];
                while ((lineTxt = bufferedReader.readLine())!=null){
                     arrayStr = lineTxt.split(",");
                }
                arrayLists = new ArrayList<String>();
                for(int i = 0 ;i<arrayStr.length; i++){
                       arrayLists.add(arrayStr[i]);
                }
                read.close();
                System.out.print(lineTxt);
            }
            else{
                System.out.println("找不到指定的文件");
            }

        }catch (Exception e){
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return arrayLists;

    }



    //解压缩
    /**
     * 解压缩zip包
     * @param zipFilePath zip文件的全路径
     * @param unzipFilePath 解压后的文件保存的路径
     * @param includeZipFileName 解压后的文件保存的路径是否包含压缩文件的文件名。true-包含；false-不包含
     * Date: 2017年4月24日 上午15:42:30 <br/>
     * @author jkf
     */

    @SuppressWarnings("unchecked")
    public static void unzip(String zipFilePath, String unzipFilePath, boolean includeZipFileName) throws Exception
    {
//        if (StringUtils.isEmpty(zipFilePath) || StringUtils.isEmpty(unzipFilePath))
//        {
//            throw new ParameterException(ICommonRe.PARAMETER_IS_NULL);
//        }
        File zipFile = new File(zipFilePath);
        //如果解压后的文件保存路径包含压缩文件的文件名，则追加该文件名到解压路径
        if (includeZipFileName)
        {
            String fileName = zipFile.getName();
            if (StringUtils.isNotEmpty(fileName))
            {
                fileName = fileName.substring(0, fileName.lastIndexOf("."));
            }
            unzipFilePath = unzipFilePath + File.separator + fileName;
        }
        //创建解压缩文件保存的路径
        File unzipFileDir = new File(unzipFilePath);
        if (!unzipFileDir.exists() || !unzipFileDir.isDirectory())
        {
            unzipFileDir.mkdirs();
        }

        //开始解压
        ZipEntry entry = null;
        String entryFilePath = null, entryDirPath = null;
        File entryFile = null, entryDir = null;
        int index = 0, count = 0, bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        ZipFile zip = new ZipFile(zipFile);
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries();
        //循环对压缩包里的每一个文件进行解压
        while(entries.hasMoreElements())
        {
            entry = entries.nextElement();
            //构建压缩包中一个文件解压后保存的文件全路径
            entryFilePath = unzipFilePath + File.separator + entry.getName();
            //构建解压后保存的文件夹路径
            index = entryFilePath.lastIndexOf(File.separator);
            if (index != -1)
            {
                entryDirPath = entryFilePath.substring(0, index);
            }
            else
            {
                entryDirPath = "";
            }
            entryDir = new File(entryDirPath);
            //如果文件夹路径不存在，则创建文件夹
            if (!entryDir.exists() || !entryDir.isDirectory())
            {
                entryDir.mkdirs();
            }

            //创建解压文件
            entryFile = new File(entryFilePath);
            if (entryFile.exists())
            {
                //检测文件是否允许删除，如果不允许删除，将会抛出SecurityException
                SecurityManager securityManager = new SecurityManager();
                securityManager.checkDelete(entryFilePath);
                //删除已存在的目标文件
                entryFile.delete();
            }

            //写入文件
            bos = new BufferedOutputStream(new FileOutputStream(entryFile));
            bis = new BufferedInputStream(zip.getInputStream(entry));
            while ((count = bis.read(buffer, 0, bufferSize)) != -1)
            {
                bos.write(buffer, 0, count);
            }
            bos.flush();
            bos.close();
        }
    }

    public static void main(String args[]) throws Exception {
        unzip("D:\\T05001708220170228001170228 222200.zip","D:\\zip",true); //解压
        String filePath = "D:\\zip\\T05001708220170228001170228222200\\T05001708220170228001170228222200.txt";
        List<String> lists = readTxtFile(filePath); //读取txt
    }


}
