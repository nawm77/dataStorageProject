package com.example.datastorageproject.Service;

import com.example.datastorageproject.Model.TestDrive;
import com.example.datastorageproject.Repository.TestDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDriveService {
    private final TestDriveRepository testDriveRepository;

    @Autowired
    public TestDriveService(TestDriveRepository testDriveRepository) {
        this.testDriveRepository = testDriveRepository;
    }

    public List<TestDrive> getAll(){
        return testDriveRepository.findAll();
    }

    public void save(TestDrive testDrive){
        testDriveRepository.saveAndFlush(testDrive);
    }

    public List<TestDrive> getById(Integer id){
        return testDriveRepository.findByCustomerId(id);
    }

    public void deleteById(Integer id){
        testDriveRepository.deleteById(id);
    }
}
