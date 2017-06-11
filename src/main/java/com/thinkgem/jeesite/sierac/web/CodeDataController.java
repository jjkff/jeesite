
package com.thinkgem.jeesite.sierac.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.sierac.entity.CodeData;
import com.thinkgem.jeesite.sierac.service.CodeDataService;

/**
 * 生产数据查询Controller
 * @author wgc
 * @version 2017-02-14
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/codeData")
public class CodeDataController extends BaseController {

	@Autowired
	private CodeDataService codeDataService;
	
	@ModelAttribute
	public CodeData get(@RequestParam(required=false) String id) {
		CodeData entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = codeDataService.get(id);
		}
		if (entity == null){
			entity = new CodeData();
		}
		return entity;
	}
	
	@RequiresPermissions("sierac:codeData:view")
	@RequestMapping(value = {"list", ""})
	public String list(CodeData codeData, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CodeData> page = codeDataService.findPage(new Page<CodeData>(request, response), codeData); 
		model.addAttribute("page", page);
		return "sierac/codeDataList";
	}

	@RequiresPermissions("sierac:codeData:view")
	@RequestMapping(value = "form")
	public String form(CodeData codeData, Model model) {
		model.addAttribute("codeData", codeData);
		return "sierac/codeDataForm";
	}

	@RequiresPermissions("sierac:codeData:edit")
	@RequestMapping(value = "save")
	public String save(CodeData codeData, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, codeData)){
			return form(codeData, model);
		}
		codeDataService.save(codeData);
		addMessage(redirectAttributes, "保存生产数据查询成功");
		return "redirect:"+Global.getAdminPath()+"/sierac/codeData/?repage";
	}
	
	@RequiresPermissions("sierac:codeData:edit")
	@RequestMapping(value = "delete")
	public String delete(CodeData codeData, RedirectAttributes redirectAttributes) {
		codeDataService.delete(codeData);
		addMessage(redirectAttributes, "删除生产数据成功");
		return "redirect:"+Global.getAdminPath()+"/sierac/codeData/?repage";
	}

}