package com.example.datastorageproject.Controller;

import com.example.datastorageproject.DTO.OrderDTO;
import com.example.datastorageproject.Model.OrderEntity;
import com.example.datastorageproject.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/p")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/")
    public List<OrderDTO> get(){
        return orderService.getOrders();
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestParam("id") Integer id, String s){
        OrderEntity order = new OrderEntity();
        /*TODO спроектировать формат запроса на сохранение заказа для */
//        order.setOrderStatus(id);
        orderService.saveOrder(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
