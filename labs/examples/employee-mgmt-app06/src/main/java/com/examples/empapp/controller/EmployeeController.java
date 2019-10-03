package com.examples.empapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examples.empapp.exception.ApplicationException;
import com.examples.empapp.model.Employee;
import com.examples.empapp.model.ResponseMessage;
import com.examples.empapp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	//	GET		/employees			=> List All Employees	
	@GetMapping(produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@CrossOrigin("*")
	public List<Employee> getAllEmployees() {
		
		return empService.getAll();
	}
	
	//	GET 	/employees/{id}		=> List employee for given Id
	@GetMapping(value="/{id}", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@CrossOrigin("*")
	public Employee getEmployee(@PathVariable int id) {
		return empService.get(id);
	}
	
	//	POST	/employees			=> Create Employee
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	@CrossOrigin("*")
	public ResponseEntity<ResponseMessage> createEmployee(@RequestBody @Valid Employee employee) throws URISyntaxException, ApplicationException {

		ResponseMessage resMsg;		
		
//		try {
			empService.create(employee);
//		} catch (ApplicationException e) {
//			resMsg = new ResponseMessage("Failure", e.getMessage());
//			return ResponseEntity.badRequest().body(resMsg);
//		}
		
		
//		if(bindingResult.hasErrors()) {
//			resMsg = new ResponseMessage("Failure", "Validation Error");
//			return ResponseEntity.badRequest().body(resMsg);			
//		}
//		else {
		
		resMsg = new ResponseMessage("Success", "Employee created successfully");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
	            "/{id}").buildAndExpand(employee.getEmpId()).toUri();
		
		return ResponseEntity.created(location).body(resMsg);			
//		}
		

//		HttpHeaders headers = new HttpHeaders();
//		headers.add("location", "/employees/100");
		
//		ResponseEntity<ResponseMessage> responseEntity = new ResponseEntity<>(resMsg, headers, HttpStatus.CREATED);
		

		
	}
	
	//	PUT		/employees/{id}		=> Update Employee
	@PutMapping(value = "/{id}")
	@CrossOrigin("*")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmp) {
		updatedEmp.setEmpId(id);
		empService.update(updatedEmp);
		return "Employee updated successfully";
	}
	
	//	DELETE	/employees/{id}		=> Delete Employee
	@DeleteMapping("/{id}")
	@CrossOrigin("*")
	public String deleteEmployee(@PathVariable int id) {
		empService.delete(id);
		return "Employee deleted successfully";
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseMessage> handleValidationExcpetion(MethodArgumentNotValidException e) {
		
		List<ObjectError> errors = e.getBindingResult().getAllErrors();
		ObjectError valError = errors.get(0);
				
		ResponseMessage resMsg = new ResponseMessage("Failure", "Validation Error - " + valError.getDefaultMessage()); 
		return ResponseEntity.badRequest().body(resMsg);		
	}	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handleAppExcpetion(Exception e) {
		ResponseMessage resMsg = new ResponseMessage("Failure", e.getMessage(), e.getCause());
		return ResponseEntity.badRequest().body(resMsg);
	}		
	
}
