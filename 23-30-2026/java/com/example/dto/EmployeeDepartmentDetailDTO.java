package com.example.dto;

public class EmployeeDepartmentDetailDTO {
	private int empId;
	private String empName;
	private String deptName;
	private String managerName;

	public EmployeeDepartmentDetailDTO(int empId, String empName, String deptName, String managerName) {
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.managerName = managerName;
	}
}
