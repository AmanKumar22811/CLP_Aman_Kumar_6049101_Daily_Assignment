package com.example.entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity

public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Department name is required")
	private String name;

	@NotBlank(message = "Manager name is required")
	private String managerName;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
