package com.aduro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.aduro.model.Employee;
import com.aduro.model.Employees;

@Component
public class EmployeeImpl implements EmployeeIntf {
	
	private final AtomicLong counter = new AtomicLong();
	
	private final HashMap<Integer, Employee> employeesMap = new HashMap<Integer, Employee>();

	@Override
	public void createEmployee(Employee employee) {
		Long id = counter.incrementAndGet();
		employee.setId(id.intValue());
		employeesMap.put(id.intValue(), employee);
	}

	@Override
	public Employees getEmployees(Integer id) {
		Employees employees = new Employees();
		List<Employee> employee = new ArrayList<Employee>();
		if(id != null && employeesMap.get(id) != null) {
			employee.add(employeesMap.get(id));
		} else if (id == null) {
			employee.addAll(employeesMap.values());
		}
		employees.setEmployees(employee);
		return employees;
	}

	@Override
	public String updateEmployee(Integer id, Employee employee) {
		String responseMsg = "Employee with ID#" + id;
		if(employeesMap.get(id) != null) {
			employee.setId(id.intValue());
			employeesMap.put(id.intValue(), employee);
			return responseMsg + " updated Successfully";
		} else {
			return responseMsg + " not found";
		}
	}

	@Override
	public String deleteEmployee(Integer id) {
		String responseMsg = "Employee with ID#" + id;
		if(employeesMap.get(id) != null) {
			employeesMap.remove(id);
			return responseMsg + " deleted Successfully";
		} else {
			return responseMsg + " not found";
		}
	}

}
