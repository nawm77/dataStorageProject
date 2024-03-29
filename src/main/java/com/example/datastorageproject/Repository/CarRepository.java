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
    List<Car> findCarByIsAvailable(Boolean isAvailable);

    @Query(value = "SELECT c.id, c.make, c.model, c.horse_power, c.fuel, c.color, c.price, c.car_vin_number, c.is_produced, c.is_available, c.is_new, CASE WHEN i.id IS NOT NULL THEN 'Yes' ELSE 'No' END AS isInService FROM Car c LEFT JOIN invoice i on i.car_id = c.id WHERE c.is_available=true", nativeQuery = true)
    @Modifying
    List<Object[]> getCarsWithServiceStatus();
}
