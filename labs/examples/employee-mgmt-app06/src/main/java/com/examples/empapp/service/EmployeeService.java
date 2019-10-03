package com.examples.empapp.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.examples.empapp.dao.EmployeeDAO;
import com.examples.empapp.exception.ApplicationException;
import com.examples.empapp.exception.DataException;
import com.examples.empapp.model.Employee;

public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDao;

	public EmployeeService() {
//		employeeDao = new EmployeeDAO();
	}

	public boolean create(Employee employee) throws ApplicationException {
		try {
			return employeeDao.create(employee);
		} catch (DataException e) {
			throw new ApplicationException("Server Error. Please try after sometime. Cause: " + e.getMessage(), e); 
		}		
	}

	public Employee get(int id) {
		return employeeDao.get(id);
	}

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public boolean update(Employee employee) {
		return employeeDao.update(employee);
	}

	public boolean delete(int id) {
		return employeeDao.delete(id);
	}

}
