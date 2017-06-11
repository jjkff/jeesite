/**
 * Project Name:JeeSite
 * File Name:ThreadTest.java
 * Package Name:com.thinkgem.jeesite.sierac.unitTest
 * Date:2017年3月31日上午9:01:13
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.sierac.unitTest;

import java.io.IOException;

import com.thinkgem.jeesite.common.utils.HttpByMjj;

/**
 * Description: <br/>
 * Date: 2017年3月31日 上午9:01:13 <br/>
 * 
 * @author mjj
 * @version
 * @see
 */

class RunnableDemo implements Runnable {
    private Thread t;

    private String threadName;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @SuppressWarnings("static-access")
    public void run() {
        System.out.println("Running " + threadName);
        // try {
        // for (int i = 4; i > 0; i--) {
        // System.out.println("Thread: " + threadName + ", " + i);
        // // 让线程睡眠一会
        // Thread.sleep(50);
        // }
        // } catch (InterruptedException e) {
        // System.out.println("Thread " + threadName + " interrupted.");
        // }
        // System.out.println("Thread " + threadName + " exiting.");
        HttpByMjj httpByMjj = new HttpByMjj();
        try {
            httpByMjj.uploadFile("http://192.168.1.163:8080/jeesite/a/api/v1/files/upload",
                    "C:\\Users\\mjj\\Desktop\\T05001708220170228004170228200054.zip");
        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
