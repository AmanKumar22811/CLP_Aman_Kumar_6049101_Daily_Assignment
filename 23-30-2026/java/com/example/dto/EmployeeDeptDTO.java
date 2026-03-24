package com.example.dto;

public class EmployeeDeptDTO {
    private String empName;
    private double salary;
    private String deptName;
    private String managerName;

    public EmployeeDeptDTO(String empName, double salary, String deptName, String managerName) {
        this.empName = empName;
        this.salary = salary;
        this.deptName = deptName;
        this.managerName = managerName;
    }
}