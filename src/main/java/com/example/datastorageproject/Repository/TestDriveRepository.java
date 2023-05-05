package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDriveRepository extends JpaRepository<TestDrive, Integer> {
}
