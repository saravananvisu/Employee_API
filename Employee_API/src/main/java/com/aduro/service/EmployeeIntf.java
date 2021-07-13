package com.aduro.service;

import com.aduro.model.Employee;
import com.aduro.model.Employees;

public interface EmployeeIntf {

	void createEmployee(Employee employee);

	Employees getEmployees(Integer id);

	String updateEmployee(Integer id, Employee employee);

	String deleteEmployee(Integer id);

}
