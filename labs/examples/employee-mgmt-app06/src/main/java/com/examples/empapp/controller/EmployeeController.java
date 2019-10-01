package com.examples.empapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	//	GET		/employees			=> List All Employees	
	@GetMapping
	public List<Employee> getAllEmployees() {
		
		return empService.getAll();
	}
	
//	GET 	/employees/{id}		=> List employee for given Id
//	POST	/employees			=> Create Employee
//	PUT		/employees/{id}		=> Update Employee
//	DELETE	/employees/{id}		=> Delete Employee
	
}
