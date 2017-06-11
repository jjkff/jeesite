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
import com.thinkgem.jeesite.sierac.entity.ProductionTask;
import com.thinkgem.jeesite.sierac.service.ProductionTaskService;

@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiProductionTaskController extends BaseController {
	@Autowired
	private ProductionTaskService productionTaskService;
	@RequestMapping(value = "/pack/productiontask/list", method = RequestMethod.POST, headers = { "Accept=application/json" })
    @ResponseBody
	public String list(ProductionTask productionTask, HttpServletRequest request, HttpServletResponse response) {
		if(ValidateToken.isToken(request,response)){
		List<ProductionTask> list=productionTaskService.findList(productionTask);
            String json = JsonMapper.getInstance().toJson(list);
            return json;
		}
		response.setStatus(403);
		return "403";
	}
}
