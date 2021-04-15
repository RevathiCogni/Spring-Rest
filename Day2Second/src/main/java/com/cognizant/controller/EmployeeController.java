package com.cognizant.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Employee;
import com.cognizant.service.EmployeeService;
import com.cognizant.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();

	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {

		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(id);
	}

}
