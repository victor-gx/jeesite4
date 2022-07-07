package com.jeesite.modules.sys.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sys.entity.Role;
import com.jeesite.modules.sys.dao.RoleDao;

/**
 * 角色表Service
 * @author gx
 * @version 2022-07-06
 */
@Service
@Transactional(readOnly=true)
public class RoleService extends CrudService<RoleDao, Role> {
	
	/**
	 * 获取单条数据
	 * @param role
	 * @return
	 */
	@Override
	public Role get(Role role) {
		return super.get(role);
	}
	
	/**
	 * 查询分页数据
	 * @param role 查询条件
	 * @param role.page 分页对象
	 * @return
	 */
	@Override
	public Page<Role> findPage(Role role) {
		return super.findPage(role);
	}
	
	/**
	 * 查询列表数据
	 * @param role
	 * @return
	 */
	@Override
	public List<Role> findList(Role role) {
		return super.findList(role);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param role
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Role role) {
		super.save(role);
	}
	
	/**
	 * 更新状态
	 * @param role
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Role role) {
		super.updateStatus(role);
	}
	
	/**
	 * 删除数据
	 * @param role
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Role role) {
		super.delete(role);
	}
	
}