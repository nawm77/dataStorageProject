package com.example.datastorageproject.Service;

import com.example.datastorageproject.DTO.EmployeeDTO;
import com.example.datastorageproject.DTO.OrderDTO;
import com.example.datastorageproject.DTO.OrderInfoDTO;
import com.example.datastorageproject.Mapper.OrderMapper;
import com.example.datastorageproject.Model.OrderEntity;
import com.example.datastorageproject.Repository.CustomerRepository;
import com.example.datastorageproject.Repository.OrderRepository;
import com.example.datastorageproject.Repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderStatusRepository statusRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderStatusRepository statusRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
        this.customerRepository = customerRepository;
    }
    public List<OrderDTO> getOrders(){
        List<OrderDTO> list = orderRepository
                .findAll()
                .stream()
                .map(OrderMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return list;
    }
    public void saveOrder(OrderEntity order){
        order.setDeliveryDate(LocalDateTime.now());
        orderRepository.saveAndFlush(order);
    }

    public List<OrderEntity> findAll(){
        return orderRepository.findAll();
    }

    public List<OrderInfoDTO> getInfo(){
        List<OrderInfoDTO> list = new ArrayList<>();
        for (Object[] result : orderRepository.getOrderCarInfo()) {
            String make = (String) result[0];
            String model = (String) result[1];
            String carVinNumber = (String) result[2];
            String description = (String) result[3];
            list.add(new OrderInfoDTO(make, model, carVinNumber, description));
        }
        return list;
    }
}
