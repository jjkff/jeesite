package com.thinkgem.jeesite.sierac.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.SysMenu;
import com.thinkgem.jeesite.sierac.service.SysMenuService;

/**
 * 模块管理Controller
 * 
 * @author wgc
 * @version 2017-02-15
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/sysMenu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    @ModelAttribute
    public SysMenu get(@RequestParam(required = false) String id) {
        SysMenu entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sysMenuService.get(id);
        }
        if (entity == null) {
            entity = new SysMenu();
        }
        return entity;
    }

    @RequiresPermissions("sierac:sysMenu:view")
    @RequestMapping(value = { "list", "" })
    public String list(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SysMenu> page = sysMenuService.findPage(new Page<SysMenu>(request, response), sysMenu);
        model.addAttribute("page", page);
        return "sierac/sysMenuList";
    }

    @RequiresPermissions("sierac:sysMenu:view")
    @RequestMapping(value = "form")
    public String form(SysMenu sysMenu, Model model) {
        model.addAttribute("sysMenu", sysMenu);
        return "sierac/sysMenuForm";
    }

    @RequiresPermissions("sierac:sysMenu:edit")
    @RequestMapping(value = "save")
    public String save(SysMenu sysMenu, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sysMenu)) {
            return form(sysMenu, model);
        }
        sysMenuService.save(sysMenu);
        addMessage(redirectAttributes, "保存模块菜单成功");
        return "redirect:" + Global.getAdminPath() + "/sierac/sysMenu/?repage";
    }

    @RequiresPermissions("sierac:sysMenu:edit")
    @RequestMapping(value = "delete")
    public String delete(SysMenu sysMenu, RedirectAttributes redirectAttributes) {
        sysMenuService.delete(sysMenu);
        addMessage(redirectAttributes, "删除模块菜单成功");
        return "redirect:" + Global.getAdminPath() + "/sierac/sysMenu/?repage";
    }

    /**
     * isShowHide是否显示隐藏菜单
     * 
     * @param extId
     * @param isShowHidden
     * @param response
     * @return
     */
    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required = false) String extId,
            @RequestParam(required = false) String isShowHide, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<SysMenu> list = sysMenuService.findAllMenu();
        for (int i = 0; i < list.size(); i++) {
            SysMenu e = list.get(i);
            if (StringUtils.isBlank(extId)
                    || (extId != null && !extId.equals(e.getId()) && e.getParentIds().indexOf("," + extId + ",") == -1)) {
                if (isShowHide != null && isShowHide.equals("0") && e.getIsShow().equals("0")) {
                    continue;
                }
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", e.getId());
                map.put("pId", e.getParentId());
                map.put("name", e.getName());
                mapList.add(map);
            }
        }
        return mapList;
    }

}