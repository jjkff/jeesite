package com.thinkgem.jeesite.sierac.unitTest;


import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;

public class TestLoginThread extends Thread {
	@Autowired
	private SystemService sys;
	private String name;
	private String password;
	public TestLoginThread(String name,String password){
		
		User user=sys.getUserByLoginName(this.name);
		boolean ss = SystemService.validatePassword(this.password,
				user.getPassword());
		if(user!=null&&ss){
			System.out.println(this.name+"登录成功");
		}
		System.out.println(this.name+"不存在或密码错误");
	}
	
	public void run(){
        	 for(int i=0;i<20;i++){
        		 System.out.println(name+"被执行了"+i);
        	 }
         }
	public static void main(String[] args) {
		TestLoginThread test1=new TestLoginThread("thinkgem","admin");
		TestLoginThread test2=new TestLoginThread("sd_jsb","admin");
		test1.run();
		test2.run();
		
	}
}


