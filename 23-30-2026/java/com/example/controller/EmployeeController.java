package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.DepartmentCountDTO;
import com.example.dto.EmployeeDepartmentDetailDTO;
import com.example.dto.EmployeeDeptDTO;
import com.example.entities.Employee;
import com.example.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// 1. Insert
	@PostMapping("/{deptName}")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp, @PathVariable String deptName) {
		return new ResponseEntity<>(service.saveEmployee(emp, deptName), HttpStatus.CREATED);
	}

	// 2. Fetch all
	@GetMapping
	public List<EmployeeDeptDTO> getAll() {
		return service.getAllEmployees();
	}

	// 3. Count
	@GetMapping("/count")
	public List<DepartmentCountDTO> count() {
		return service.getEmployeeCount();
	}

	// 4. Employees by department
	@GetMapping("/department/{name}")
	public List<Employee> getByDept(@PathVariable String name) {
		return service.getEmployeesByDept(name);
	}

	// 5. Fetch using mobile
	@GetMapping("/bymobile/{mobile}")
	public EmployeeDepartmentDetailDTO getByMobile(@PathVariable String mobile) {
		return service.getByMobile(mobile);
	}
}