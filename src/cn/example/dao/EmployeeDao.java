package cn.example.dao;

import cn.example.entity.Dept;
import cn.example.entity.Employee;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class EmployeeDao {

	// 注入SessionFactory对象
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 查询
	 * @param id
	 */
	public Employee findById(Serializable id) {
		Employee employee = new Employee();
		employee.setEmpName("张三");
		employee.setSalary(209.2);
		Dept dept = new Dept();
		dept.setName("软件开发");
		employee.setDept(dept);
		sessionFactory.getCurrentSession().save(dept);
		sessionFactory.getCurrentSession().save(employee);
		System.out.println(id);
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}
}
