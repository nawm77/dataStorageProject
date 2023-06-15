package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.Invoice;
import com.example.datastorageproject.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("")
    public String getServiceOrder(Model model){
        model.addAttribute("order", new Invoice());
        model.addAttribute("customerList", serviceService.getCustomerList());
        model.addAttribute("employeeList", serviceService.getEmployeeList());
        model.addAttribute("orderList", serviceService.getOrderList());
        model.addAttribute("carList", serviceService.getCarList());
        System.out.println(serviceService.getCarList());
        return "serviceOrder";
    }
    @PostMapping("/")
    public String saveOrder(Invoice invoice){
        serviceService.saveInvoice(invoice);
        System.out.println(invoice.getCar().getCarVinNumber());
        return "redirect:/";
    }

    @GetMapping("/list")
    public String getAllOrders(Model model){
        model.addAttribute("invoiceList", serviceService.findAll());
        return "invoiceList";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoiceById(@PathVariable("id") Integer id){
        serviceService.deleteById(id);
        return "redirect:/service/list";
    }
}
