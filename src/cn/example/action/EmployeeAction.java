package cn.example.action;

import cn.example.entity.Employee;
import cn.example.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;


public class EmployeeAction extends ActionSupport{

	// IOC容器注入
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Override
	public String execute(){
		int empid = 2;
		// 调用Service
		Employee emp = employeeService.findById(empid);
		System.out.println(emp);
		// 保存到request
		Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("emp", emp);
		
		return SUCCESS;
	}
}