package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.Car;
import com.example.datastorageproject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c.id, c.make, c.model, c.horsePower, c.fuel, c.color, c.carVinNumber, c.price, c.isProduced, c.isAvailable, c.isNew FROM Car c WHERE c.isAvailable=true")
    @Modifying
    List<Object[]> getAvailableCars();
    List<Car> findCarByCustomer(Customer customer);
}
