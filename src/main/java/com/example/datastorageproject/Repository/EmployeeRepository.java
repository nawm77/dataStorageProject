package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);

    @Modifying
    @Query("SELECT e.id, e.name, e.lastname, e.email, e.phoneNumber, p.positionName, e.salary, p.id FROM Employee e JOIN Position p on e.position.id = p.id")
    List<Object[]> getEmployeeInfo();

    @Modifying
    @Query("SELECT e.name, e.lastname, e.phoneNumber, i.description FROM Employee e JOIN Invoice i on i.employee.id = e.id")
    List<Object[]> getEmployeeServiceInfo();
}
