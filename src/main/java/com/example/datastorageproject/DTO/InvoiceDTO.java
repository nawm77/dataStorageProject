package com.example.datastorageproject.DTO;

import com.example.datastorageproject.Mapper.OrderPartMapper;
import com.example.datastorageproject.Model.Car;
import com.example.datastorageproject.Model.Customer;
import com.example.datastorageproject.Model.Employee;
import com.example.datastorageproject.Model.OrderPart;

import java.util.List;
import java.util.stream.Collectors;

public record InvoiceDTO(Integer id, String description, Customer customer, Employee employee, Car car, List<OrderPart> orderPartList) {
    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", customer=" + customer.getName() + " " + customer.getLastname() +
                ", employee=" + employee.getName() + " " + employee.getLastname() +
                ", car=" + car.getMake() + " " + car.getModel() + " " + car.getCarVinNumber() +
                ", orderPartList=" + orderPartList.stream().map(OrderPartMapper.INSTANCE::toDTO).toList() +
                '}';
    }
}
