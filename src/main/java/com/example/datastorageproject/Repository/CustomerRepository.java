package com.example.datastorageproject.Repository;

import com.example.datastorageproject.DTO.CustomerCarInfoDTO;
import com.example.datastorageproject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Boolean existsByEmail(String email);
    Optional<Customer> findByEmail(String email);
    @Query("SELECT c.name, c.lastname, c.phoneNumber, c.email, car.make, car.model, car.carVinNumber FROM Customer c JOIN c.orderList o JOIN o.car car")
    List<Object[]> getCustomerCarInfo();
}
