package com.examples.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empService.get(id);
	}
	
	//	POST	/employees			=> Create Employee
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String createEmployee(@RequestBody Employee employee) {
		empService.create(employee);
		return "Employee created successfully";
	}
	
	//	PUT		/employees/{id}		=> Update Employee
	@PutMapping(value = "/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmp) {
		updatedEmp.setEmpId(id);
		empService.update(updatedEmp);
		return "Employee updated successfully";
	}
	
	//	DELETE	/employees/{id}		=> Delete Employee
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		empService.delete(id);
		return "Employee deleted successfully";
	}	
}
