package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.Employee;
import com.cognizant.service.exception.EmployeeNotFoundException;

@Component
public class EmployeeDao {
	
	static ArrayList<Employee> EMPLOYEE_LIST;
	Logger LOGGER=org.slf4j.LoggerFactory.getLogger("EmployeeDao.class");

	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
	}
	public List<Employee> getAllEmployee(){
		return EMPLOYEE_LIST;
	}
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Inside updateEmployee() method");
		for(Employee emp:EMPLOYEE_LIST)
		{
			if(emp.getId()==employee.getId())
			{
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setPermanent(employee.getPermanent());
				emp.setDepartment(employee.getDepartment());
				emp.setSkill(employee.getSkill());
				
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException
	{
		Employee emp=null;
		for(Employee e:EMPLOYEE_LIST)
		{
			if(e.getId()==id)
			{
				emp=e;
				EMPLOYEE_LIST.remove(emp);
				break;
			}
		}
		if(emp==null)
		{
			throw new EmployeeNotFoundException();
		}
	}
	

}
