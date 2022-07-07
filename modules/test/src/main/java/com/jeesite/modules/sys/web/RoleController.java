package com.jeesite.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sys.entity.Role;
import com.jeesite.modules.sys.service.RoleService;

/**
 * 角色表Controller
 * @author gx
 * @version 2022-07-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/role")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Role get(String roleCode, boolean isNewRecord) {
		return roleService.get(roleCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sys:role:view")
	@RequestMapping(value = {"list", ""})
	public String list(Role role, Model model) {
		model.addAttribute("role", role);
		return "modules/sys/roleList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sys:role:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Role> listData(Role role, HttpServletRequest request, HttpServletResponse response) {
		role.setPage(new Page<>(request, response));
		Page<Role> page = roleService.findPage(role);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sys:role:view")
	@RequestMapping(value = "form")
	public String form(Role role, Model model) {
		model.addAttribute("role", role);
		return "modules/sys/roleForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("sys:role:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Role role) {
		roleService.save(role);
		return renderResult(Global.TRUE, text("保存角色表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("sys:role:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Role role) {
		roleService.delete(role);
		return renderResult(Global.TRUE, text("删除角色表成功！"));
	}
	
}