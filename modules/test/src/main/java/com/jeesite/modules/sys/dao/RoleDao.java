package com.jeesite.modules.sys.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sys.entity.Role;

/**
 * 角色表DAO接口
 * @author gx
 * @version 2022-07-06
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role> {
	
}