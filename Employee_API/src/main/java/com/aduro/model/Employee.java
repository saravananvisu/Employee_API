package com.aduro.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7750663492795658268L;
	
	private int id;
	
	@NotNull
	@Size(max=100)
	private String name;
	
	@NotNull
	@Size(max=4)
	private String office;
	
	@NotNull
	@Size(max=150)
	private String email;
	
	@NotNull
	@Size(max=12)
	private String phone;

	@NotNull
	@Size(max=150)
	private String role;
}
