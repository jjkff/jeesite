/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test_audit.web;

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
import com.thinkgem.jeesite.modules.test_audit.entity.Test_audit;
import com.thinkgem.jeesite.modules.test_audit.service.Test_auditService;

/**
 * crudController
 * @author wgc
 * @version 2017-02-11
 */
@Controller
@RequestMapping(value = "${adminPath}/test_audit/test_audit")
public class Test_auditController extends BaseController {

	@Autowired
	private Test_auditService test_auditService;
	
	@ModelAttribute
	public Test_audit get(@RequestParam(required=false) String id) {
		Test_audit entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = test_auditService.get(id);
		}
		if (entity == null){
			entity = new Test_audit();
		}
		return entity;
	}
	
	@RequiresPermissions("test_audit:test_audit:view")
	@RequestMapping(value = {"list", ""})
	public String list(Test_audit test_audit, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Test_audit> page = test_auditService.findPage(new Page<Test_audit>(request, response), test_audit); 
		model.addAttribute("page", page);
		return "modules/test_audit/test_auditList";
	}

	@RequiresPermissions("test_audit:test_audit:view")
	@RequestMapping(value = "form")
	public String form(Test_audit test_audit, Model model) {
		model.addAttribute("test_audit", test_audit);
		return "modules/test_audit/test_auditForm";
	}

	@RequiresPermissions("test_audit:test_audit:edit")
	@RequestMapping(value = "save")
	public String save(Test_audit test_audit, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, test_audit)){
			return form(test_audit, model);
		}
		test_auditService.save(test_audit);
		addMessage(redirectAttributes, "保存crud成功");
		return "redirect:"+Global.getAdminPath()+"/test_audit/test_audit/?repage";
	}
	
	@RequiresPermissions("test_audit:test_audit:edit")
	@RequestMapping(value = "delete")
	public String delete(Test_audit test_audit, RedirectAttributes redirectAttributes) {
		test_auditService.delete(test_audit);
		addMessage(redirectAttributes, "删除crud成功");
		return "redirect:"+Global.getAdminPath()+"/test_audit/test_audit/?repage";
	}

}