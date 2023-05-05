package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.OrderPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPartRepository extends JpaRepository<OrderPart, Integer> {
}
