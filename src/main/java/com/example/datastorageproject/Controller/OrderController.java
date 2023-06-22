package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.OrderEntity;
import com.example.datastorageproject.Repository.OrderStatusRepository;
import com.example.datastorageproject.Service.CarService;
import com.example.datastorageproject.Service.CustomerService;
import com.example.datastorageproject.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final CarService carService;
    private final CustomerService customerService;
    private final OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderController(OrderService orderService, CarService carService, CustomerService customerService, OrderStatusRepository orderStatusRepository) {
        this.orderService = orderService;
        this.carService = carService;
        this.customerService = customerService;
        this.orderStatusRepository = orderStatusRepository;
    }
    @GetMapping("/list")
    public String getInfo(Model model){
        model.addAttribute("list", orderService.getInfo());
        return "orderInfoPage";
    }
    @PostMapping("/new")
    public String addNewOrder(OrderEntity order){
        orderService.saveOrder(order);
        return "redirect:/orders/list";
    }

    @GetMapping("/new")
    public String getNewOrderPage(Model model){
        model.addAttribute("order", new OrderEntity());
        model.addAttribute("orderStatus", orderStatusRepository.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("carList", carService.getAvailableCars());
        return "newOrderPage";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer id){
        orderService.deleteById(id);
        return "redirect:/orders/list";
    }
}
