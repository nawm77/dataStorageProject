package com.example.datastorageproject.Service;

import com.example.datastorageproject.Model.*;
import com.example.datastorageproject.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ServiceService {
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final OrderService orderService;
    private final CarService carService;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public ServiceService(CustomerService customerService, EmployeeService employeeService, OrderService orderService, CarService carService, InvoiceRepository invoiceRepository) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.orderService = orderService;
        this.carService = carService;
        this.invoiceRepository = invoiceRepository;
    }

    public List<Customer> getCustomerList() {
        return customerService.findAll();
    }

    public List<Employee> getEmployeeList() {
        return employeeService.findAll();
    }

    public List<OrderEntity> getOrderList(){
        return orderService.findAll();
    }

    public List<Car> getCarList(){
        return carService.getAllCars();
    }

    public void saveInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public List<Invoice> findAll(){
        return invoiceRepository.findAll();
    }

    public void deleteById(Integer id){
        invoiceRepository.deleteById(id);
    }
}
