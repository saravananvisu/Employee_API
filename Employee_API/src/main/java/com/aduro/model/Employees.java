package com.aduro.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Employees implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8739929252039885591L;
	
	private List<Employee> employees;

}
