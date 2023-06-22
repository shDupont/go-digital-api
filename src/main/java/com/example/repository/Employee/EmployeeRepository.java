package com.example.repository.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}