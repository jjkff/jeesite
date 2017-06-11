package com.thinkgem.jeesite.sierac.unitTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkgem.jeesite.sierac.entity.CodeData;
import com.thinkgem.jeesite.sierac.service.CodeDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class CodeDateTest {
	@Autowired
	private CodeDataService codeDataService;
	CodeData codeData=new CodeData();
	/**
	 * @author wgc
	 * 生产数据增加
	 */
	@Test
	public void save(){
		codeData.setCode("1234");//测试增加时产品ID不能为空
		codeData.setProductId("666");
		codeDataService.save(codeData);
	
	}
	@Test
	public void findList(){
		List<CodeData> list=codeDataService.findList(codeData);
		System.out.println(list.size());
		
	}
	@Test
	public void delete(){
		List<CodeData> list=codeDataService.findList(codeData);
		System.out.println(list.size());//删除之前输出表中数据条数
		codeData.setId("0252f2960ac44d9e8fddd9278ca2076a");
		codeDataService.delete(codeData);
	    CodeData codeData1=new CodeData();
	    List<CodeData> list1=codeDataService.findList(codeData1);
		System.out.println(list1.size());//删除之后输出表中数据条数
	    
	}

}
