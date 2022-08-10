package com.jeesite.common.utils.excel.fieldtype;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.utils.SpringUtils;
import com.jeesite.modules.sys.entity.Employee;
import com.jeesite.modules.sys.service.EmployeeService;

import java.util.List;

/**
  * 字段类型转换
 * @author ThinkGem
 * @version 2020-3-5
 * @example fieldType = EmployeeType.class
 */
public class EmployeeType implements FieldType {

		private List<Employee> list;

		private static EmployeeService employeeService = SpringUtils.getBean(EmployeeService.class);;

		public EmployeeType() {
	        Employee where = new Employee();
	        where.setStatus(Employee.STATUS_NORMAL);
	        list = employeeService.findList(where);
        }

/**
 * 获取对象值（导入）
 */
		public Object getValue(String val) {
            for (Employee e : list){
                if (StringUtils.trimToEmpty(val).equals(e.getEmpName())){
                    return e;
                }
            }
        return null;
    }

    /**
     * 设置对象值（导出）
     */
        public String setValue(Object val) {
            if (val != null && ((Employee)val).getEmpName() != null){
                return ((Employee)val).getEmpName();
            }
        return StringUtils.EMPTY;
    }

}

