package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Boolean existsByEmail(String email);
    Optional<Customer> findByEmail(String email);
    @Query(value = "SELECT c.id, c.name, c.lastname, c.phone_number, c.email, car.make, car.model, car.car_vin_number FROM Customer c JOIN car on car.customer_id = c.id ORDER BY c.phone_number", nativeQuery = true)
    @Modifying
    List<Object[]> getCustomerCarInfo();

//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM order_entity WHERE customer_id = :customerId; " +
//            "DELETE FROM customer WHERE id = :customerId", nativeQuery = true)
//    void deleteCustomerById(@Param("customerId") Integer customerId);
    void deleteById(Integer id);
    Customer findCustomerByEmail(String email);
}
