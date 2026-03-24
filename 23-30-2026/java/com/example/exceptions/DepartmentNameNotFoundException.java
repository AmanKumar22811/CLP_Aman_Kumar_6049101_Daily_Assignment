package com.example.exceptions;

public class DepartmentNameNotFoundException extends RuntimeException {
    public DepartmentNameNotFoundException(String msg) {
        super(msg);
    }
}