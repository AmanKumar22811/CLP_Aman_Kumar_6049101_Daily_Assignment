package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DepartmentCountDTO;
import com.example.dto.EmployeeDepartmentDetailDTO;
import com.example.dto.EmployeeDeptDTO;
import com.example.entities.Department;
import com.example.entities.Employee;
import com.example.exceptions.DepartmentNameNotFoundException;
import com.example.exceptions.MobileNumberDoesNotExistsForEmployeeException;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private DepartmentRepository deptRepo;

	// 1. Insert Employee
	public Employee saveEmployee(Employee emp, String deptName) {
		Department department = deptRepo.findByName(deptName)
				.orElseThrow(() -> new DepartmentNameNotFoundException("Department not found"));

		emp.setDepartment(department);
		return employeeRepo.save(emp);
	}

	// 2. Fetch all employees with department details
	public List<EmployeeDeptDTO> getAllEmployees() {
		return employeeRepo.findAllWithDepartment().stream().map(e -> new EmployeeDeptDTO(e.getName(), e.getSalary(),
				e.getDepartment().getName(), e.getDepartment().getManagerName())).toList();
	}

	// 3. Count employees per department
	public List<DepartmentCountDTO> getEmployeeCount() {
		return employeeRepo.countEmployeesByDepartment();
	}

	// 4. Employees under department
	public List<Employee> getEmployeesByDept(String deptName) {
		List<Employee> list = employeeRepo.findByDepartmentName(deptName);

		if (list.isEmpty()) {
			throw new DepartmentNameNotFoundException("Department not found");
		}
		return list;
	}

	// 5. Get department details using mobile number
	public EmployeeDepartmentDetailDTO getByMobile(String mobile) {
		Employee e = employeeRepo.findByMobile(mobile)
				.orElseThrow(() -> new MobileNumberDoesNotExistsForEmployeeException("Mobile not found"));

		return new EmployeeDepartmentDetailDTO(e.getId(), e.getName(), e.getDepartment().getName(),
				e.getDepartment().getManagerName());
	}
}
