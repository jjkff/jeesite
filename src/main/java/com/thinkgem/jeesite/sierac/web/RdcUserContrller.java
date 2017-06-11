package com.thinkgem.jeesite.sierac.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.rdcUser;
import com.thinkgem.jeesite.sierac.service.RdcUserService;

@Controller
@RequestMapping(value = "${adminPath}/sierac/rdcUser")
public class RdcUserContrller extends BaseController {
	@Autowired
	private RdcUserService rdcUserService;
/**
 * 从仓库界面点击用户维护所跳转的页面
 * @param rdcUser
 * @param request
 * @param response
 * @param model
 * @return
 */
	@RequiresPermissions("sierac:rdcWarehouse:view")
	@RequestMapping(value = "formuser")
	public String formuser(rdcUser rdcUser, HttpServletRequest request,
			HttpServletResponse response, Model model) {// 根据仓库id查询用户信息，返回到关联用户List
		String id = request.getParameter("id");

		model.addAttribute("id", id);
		Page<rdcUser> page = rdcUserService.findPageuser(new Page<rdcUser>(
				request, response), rdcUser);

		model.addAttribute("page", page);
		return "sierac/rdcWarehouseFormuser";
	}
    /**
     * 点击"用户添加"跳转的页面。查询符合要求的可关联用户
     * @param rdcuser
     * @param request
     * @param response
     * @param model
     * @param redirectAttributes
     * @return
     */
	@RequiresPermissions("sierac:rdcWarehouse:view")
	@RequestMapping(value = "addrdcUser")
	public String rdcUser(rdcUser rdcuser, HttpServletRequest request,
			HttpServletResponse response, Model model,
			RedirectAttributes redirectAttributes) {
		String id = request.getParameter("id");
		model.addAttribute("id", id);
		Page<rdcUser> page = rdcUserService.findPageuserType(new Page<rdcUser>(
				request, response), rdcuser);
		System.out.println(page.getList().size());
		if (page.getList().size() == 0) {
			int paList=page.getList().size();
			model.addAttribute("paList",paList);
			
			return "sierac/addrdcUser";
		} else {
			model.addAttribute("page", page);
			return "sierac/addrdcUser";
		}

	}
	
	/**
	 * 删除关联用户
	 * @param rdcUser
	 * @param redirectAttributes
	 * @return
	 */

	@RequiresPermissions("sierac:rdcWarehouse:edit")
	@RequestMapping(value = "delete")
	public String delete(rdcUser rdcUser, RedirectAttributes redirectAttributes) {
		rdcUserService.delete(rdcUser);
		addMessage(redirectAttributes, "删除关联用户信息成功");
		return "redirect:" + Global.getAdminPath()
				+ "/sierac/rdcWarehouse?repage";

	}
/**
 * 批量添加关联用户
 * @param rdcUser
 * @param id,仓库id
 * @param userId,用户id
 * @param redirectAttributes
 * @param request
 * @param response
 * @param model
 * @return
 */
	@RequiresPermissions("sierac:rdcWarehouse:edit")
	@RequestMapping(value = "addAll")
	public String addAll(rdcUser rdcUser, @Param("id") String id,
			@Param("userId") String userId,
			RedirectAttributes redirectAttributes, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		userId = request.getParameter("userIdList");
		id = request.getParameter("id");
		String[] userid = userId.split(",");
		for (int i = 0; i < userid.length; i++) {
			rdcUserService.saveUserRdcwarehouse(id, userid[i]);
		}
		model.addAttribute("id", id);
		Page<rdcUser> page = rdcUserService.findPageuser(new Page<rdcUser>(
				request, response), rdcUser);
		/*if (page.getList().size() == 0) {
			addMessage(redirectAttributes, "已没有符合要求的用户可以关联");
			return "redirect:" + Global.getAdminPath()
					+ "/sierac/rdcWarehouse?repage";
		}*/
		model.addAttribute("page", page);
		return "sierac/rdcWarehouseFormuser";
	}
}
