package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Employee;
import com.cognizant.service.EmployeeService;

@RestController
public class EmployeeController {
@Autowired
private EmployeeService employeeService;

@RequestMapping("/employees")
List<Employee> getAllEmployees(){
	
	return employeeService.getAllEmployees();
	
}


}
