package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.Customer;
import com.example.datastorageproject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);
}
