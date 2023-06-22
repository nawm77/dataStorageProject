package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestDriveRepository extends JpaRepository<TestDrive, Integer> {
    @Query("SELECT t FROM TestDrive t WHERE t.customer.id = :customerId")
    List<TestDrive> findByCustomerId(@Param("customerId") Integer customerId);
}
