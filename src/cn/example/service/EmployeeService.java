package cn.example.service;

import cn.example.dao.EmployeeDao;
import cn.example.entity.Employee;

import java.io.Serializable;

public class EmployeeService {

	// IOC注入
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * 查询
	 * @param id
	 *
	 */
	public Employee findById(Serializable id) {
		Employee emp = employeeDao.findById(id);
		return emp;
	}
}
