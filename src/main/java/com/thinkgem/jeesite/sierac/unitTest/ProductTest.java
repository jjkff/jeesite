package com.thinkgem.jeesite.sierac.unitTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class ProductTest {
	@Autowired
	private ProductService productService;
	Product product=new Product();
	@Test
	/**
	 * @author wgc
	 * 产品展示
	 */
	public void findList(){
		
		List<Product> list=productService.findList(product);
		for (Product product2 : list) {
			System.out.println(product2.getCode());
			
		}
	}
	/**
	 * @author wgc
	 * @return
	 * 产品增加
	 */
	@Test
	public void save(){
	  product.setCode("1234");
	  product.setName("蒙牛算算乳");
	  product.setRemarks("保质期三年，酸酸甜甜好味道");
	  productService.save(product);
		
	}
	/**
	 * @author wgc
	 * 删除产品,并非真正删除，只是将其del_fag从0修改成1
	 * 使其不再查询中显示
	 */
	@Test
    public void delete(){
		List<Product> list=productService.findList(product);
		System.out.println(list.size());//执行删除之前输出数据库中所拥有的信息条数
		
    	product.setId("742ad545f3a2499e8f1cc1f6f846422d");
    	productService.delete(product);
    	Product product1=new Product();
    	List<Product> list1=productService.findList(product1);
		System.out.println(list1.size());//执行删除之后输出数据库中所拥有的信息条数
		//查看两个输出结果就知道有没有删除成功
		
    }
}
