package com.example.datastorageproject.Service;

import com.example.datastorageproject.DTO.OrderPartDTO;
import com.example.datastorageproject.DTO.PartDTO;
import com.example.datastorageproject.Mapper.OrderPartMapper;
import com.example.datastorageproject.Mapper.PartMapper;
import com.example.datastorageproject.Model.*;
import com.example.datastorageproject.Repository.InvoiceRepository;
import com.example.datastorageproject.Repository.OrderPartRepository;
import com.example.datastorageproject.Repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceService {
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final OrderService orderService;
    private final CarService carService;
    private final InvoiceRepository invoiceRepository;
    private final OrderPartRepository orderPartRepository;
    private final PartRepository partRepository;
    @Autowired
    public ServiceService(CustomerService customerService, EmployeeService employeeService, OrderService orderService, CarService carService, InvoiceRepository invoiceRepository, OrderPartRepository orderPartRepository, PartRepository partRepository) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.orderService = orderService;
        this.carService = carService;
        this.invoiceRepository = invoiceRepository;
        this.orderPartRepository = orderPartRepository;
        this.partRepository = partRepository;
    }

    public List<Customer> getCustomerList() {
        return customerService.findAll();
    }

    public List<Employee> getEmployeeList() {
        return employeeService.findAll();
    }

    public List<OrderEntity> getOrderList() {
        return orderService.findAll();
    }

    public List<Car> getCarList() {
        return carService.getAllCars();
    }

    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public void deleteById(Integer id) {
        invoiceRepository.deleteById(id);
    }

    public Invoice getById(Integer id){
        return invoiceRepository.getById(id);
    }

    public List<OrderPartDTO> getPartList(Integer id){
        return invoiceRepository
                .getById(id)
                .getOrderPartList()
                .stream()
                .map(OrderPartMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public void deletePart(Integer id, Integer partId){
        orderPartRepository.deleteByInvoiceIdAndPartId(id, partId);
    }

    public List<PartDTO> getPartList(){
        return partRepository
                .findAll()
                .stream()
                .map(PartMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public void saveOrderPart(Integer amount, Integer invoiceId, Integer partId){
        orderPartRepository.saveOrderPart(amount, invoiceId, partId);
    }

    public void saveNewOrderPart(OrderPart orderPart){
        orderPartRepository.save(orderPart);
    }
}
