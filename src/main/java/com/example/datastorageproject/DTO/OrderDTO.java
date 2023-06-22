package com.example.datastorageproject.DTO;

import com.example.datastorageproject.Model.Customer;
import com.example.datastorageproject.Model.OrderStatus;

import java.time.LocalDateTime;

public record OrderDTO(Integer id, LocalDateTime deliveryDate, Customer customer, OrderStatus orderStatus) {
    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", deliveryDate=" + deliveryDate +
                ", customerName=" + customer.getName() +
                ", customerPhoneNumber=" + customer.getPhoneNumber() +
                ", customerEmail=" + customer.getEmail() +
                ", orderStatus=" + orderStatus.getDescription() +
                '}';
    }
}
