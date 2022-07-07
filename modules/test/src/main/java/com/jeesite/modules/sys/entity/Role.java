package com.jeesite.modules.sys.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.jeesite.common.entity.BaseEntity;
import com.jeesite.common.entity.Extend;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 角色表Entity
 * @author gx
 * @version 2022-07-06
 */
@Table(name="${_prefix}sys_role", alias="a", label="角色表信息", columns={
		@Column(name="role_code", attrName="roleCode", label="角色编码", isPK=true),
		@Column(name="role_name", attrName="roleName", label="角色名称", queryType=QueryType.LIKE),
		@Column(name="role_type", attrName="roleType", label="角色分类", comment="角色分类（高管、中层、基层、其它）"),
		@Column(name="role_sort", attrName="roleSort", label="角色排序", comment="角色排序（升序）", isUpdateForce=true),
		@Column(name="is_sys", attrName="isSys", label="系统内置", comment="系统内置（1是 0否）"),
		@Column(name="user_type", attrName="userType", label="用户类型", comment="用户类型（employee员工 member会员）"),
		@Column(name="data_scope", attrName="dataScope", label="数据范围设置", comment="数据范围设置（0未设置  1全部数据 2自定义数据）"),
		@Column(name="biz_scope", attrName="bizScope", label="适应业务范围", comment="适应业务范围（不同的功能，不同的数据权限支持）"),
		@Column(includeEntity=DataEntity.class),
		@Column(includeEntity=BaseEntity.class),
		@Column(includeEntity=Extend.class, attrName="extend"),
	}, orderBy="a.update_date DESC"
)
public class Role extends DataEntity<Role> {
	
	private static final long serialVersionUID = 1L;
	private String roleCode;		// 角色编码
	private String roleName;		// 角色名称
	private String roleType;		// 角色分类（高管、中层、基层、其它）
	private Integer roleSort;		// 角色排序（升序）
	private String isSys;		// 系统内置（1是 0否）
	private String userType;		// 用户类型（employee员工 member会员）
	private String dataScope;		// 数据范围设置（0未设置  1全部数据 2自定义数据）
	private String bizScope;		// 适应业务范围（不同的功能，不同的数据权限支持）
	private Extend extend;		// 扩展字段
	
	public Role() {
		this(null);
	}
	
	public Role(String id){
		super(id);
	}
	
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	@NotBlank(message="角色名称不能为空")
	@Size(min=0, max=100, message="角色名称长度不能超过 100 个字符")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Size(min=0, max=100, message="角色分类长度不能超过 100 个字符")
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	public Integer getRoleSort() {
		return roleSort;
	}

	public void setRoleSort(Integer roleSort) {
		this.roleSort = roleSort;
	}
	
	@Size(min=0, max=1, message="系统内置长度不能超过 1 个字符")
	public String getIsSys() {
		return isSys;
	}

	public void setIsSys(String isSys) {
		this.isSys = isSys;
	}
	
	@Size(min=0, max=16, message="用户类型长度不能超过 16 个字符")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Size(min=0, max=1, message="数据范围设置长度不能超过 1 个字符")
	public String getDataScope() {
		return dataScope;
	}

	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}
	
	@Size(min=0, max=255, message="适应业务范围长度不能超过 255 个字符")
	public String getBizScope() {
		return bizScope;
	}

	public void setBizScope(String bizScope) {
		this.bizScope = bizScope;
	}
	
	public Extend getExtend() {
		return extend;
	}

	public void setExtend(Extend extend) {
		this.extend = extend;
	}
	
}