package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dto.DepartmentCountDTO;
import com.example.entities.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Fetch all employees with department using JOIN FETCH
	@Query("SELECT e FROM Employee e JOIN FETCH e.department")
	List<Employee> findAllWithDepartment();

	// Employees under given department
	@Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.name = :deptName")
	List<Employee> findByDepartmentName(@Param("deptName") String deptName);

	// Find employee by mobile number
	@Query("SELECT e FROM Employee e JOIN FETCH e.department d JOIN e.mobileNumbers m WHERE m = :mobile")
	Optional<Employee> findByMobile(@Param("mobile") String mobile);

	// Count employees per department
	@Query("SELECT new com.example.dto.DepartmentCountDTO(d.name, COUNT(e)) "
			+ "FROM Employee e JOIN e.department d GROUP BY d.name")
	List<DepartmentCountDTO> countEmployeesByDepartment();
}
