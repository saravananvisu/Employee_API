package com.aduro.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aduro.model.Employee;
import com.aduro.model.Employees;
import com.aduro.service.EmployeeIntf;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeIntf employeeIntf;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		employeeIntf.createEmployee(employee);
		return new ResponseEntity<Employee>(employee, null, HttpStatus.OK);
	}

	@GetMapping("/employees")
	public Employees getEmployees(@QueryParam(value = "id") Integer id) {
		return employeeIntf.getEmployees(id);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable(value = "id") Integer id, @RequestBody Employee employee) {
		return new ResponseEntity<String>(employeeIntf.updateEmployee(id, employee), null, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Integer id) {
		return new ResponseEntity<String>(employeeIntf.deleteEmployee(id), null, HttpStatus.OK);
	}

	
}
