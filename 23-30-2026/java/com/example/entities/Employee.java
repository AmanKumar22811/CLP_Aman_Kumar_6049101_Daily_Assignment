package com.example.entities;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Employee name is required")
	private String name;

	@Positive(message = "Salary must be positive")
	private double salary;

	@ElementCollection
	@CollectionTable(name = "employee_mobiles", joinColumns = @JoinColumn(name = "emp_id"))
	@Column(name = "mobile")
	private Set<@Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number") String> mobileNumbers;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<String> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

}
