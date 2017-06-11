package com.thinkgem.jeesite.sierac.web;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.ValidateToken;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.service.ProductService;
/**
 * 产品管理ApiController
 * 
 * @author wgc
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiProductController extends BaseController {
	@Autowired
	private ProductService productService;
	@RequestMapping(value = "/pack/product/list", method = RequestMethod.GET, headers = { "Accept=application/json" })
	@ResponseBody
	public String list(Product product, HttpServletRequest request,
			HttpServletResponse response) {
		if (ValidateToken.isToken(request, response)) {
			List<Product> products = productService.findAll(product);
			String json = JsonMapper.getInstance().toJson(products);
			return json;
		}
		response.setStatus(403);
		return "403";
	}

}
