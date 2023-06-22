package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Modifying
    @Query("SELECT oe.car.make, oe.car.model, oe.car.carVinNumber, os.description, oe.id FROM OrderEntity oe JOIN OrderStatus os on os.id = oe.orderStatus.id")
    List<Object[]> getOrderCarInfo();
}
