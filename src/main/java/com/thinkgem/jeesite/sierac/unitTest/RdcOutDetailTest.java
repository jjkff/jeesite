package com.thinkgem.jeesite.sierac.unitTest;

import com.thinkgem.jeesite.sierac.dao.RdcOutDetailDao;
import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.entity.RdcOutDetail;
import com.thinkgem.jeesite.sierac.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class RdcOutDetailTest {
	@Autowired
	private RdcOutDetailDao rdcOutDetailDao;

	@Test

	public void findList(){
		RdcOutDetail rdcOutDetail =  new RdcOutDetail();
		rdcOutDetail.setOrderCode("HTRSH");
		rdcOutDetailDao.findList(rdcOutDetail);

	}

}
