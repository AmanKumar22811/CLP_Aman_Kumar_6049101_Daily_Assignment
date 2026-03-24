package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByName(String name);
}
