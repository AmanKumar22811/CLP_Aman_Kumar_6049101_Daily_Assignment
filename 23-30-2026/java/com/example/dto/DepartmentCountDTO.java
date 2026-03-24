package com.example.dto;

public class DepartmentCountDTO {
    private String deptName;
    private long count;

    public DepartmentCountDTO(String deptName, long count) {
        this.deptName = deptName;
        this.count = count;
    }
}
