package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.Invoice;
import com.example.datastorageproject.Model.OrderPart;
import com.example.datastorageproject.Repository.InvoiceRepository;
import com.example.datastorageproject.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public ServiceController(ServiceService serviceService, InvoiceRepository invoiceRepository) {
        this.serviceService = serviceService;
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("")
    public String getServiceOrder(Model model){
        model.addAttribute("order", new Invoice());
        model.addAttribute("customerList", serviceService.getCustomerList());
        model.addAttribute("employeeList", serviceService.getEmployeeList());
        model.addAttribute("orderList", serviceService.getOrderList());
        model.addAttribute("carList", serviceService.getCarList());
        return "serviceOrder";
    }
    @PostMapping("/")
    public String saveOrder(Invoice invoice){
        serviceService.saveInvoice(invoice);
        return "redirect:/";
    }
    @PreAuthorize("hasAnyAuthority('admin:write', 'employee_write')")
    @GetMapping("/list")
    public String getAllOrders(Model model){
        model.addAttribute("invoiceList", serviceService.findAll());
        return "invoiceList";
    }
    @PreAuthorize("hasAnyAuthority('admin:write', 'employee_write')")
    @GetMapping("/delete/{id}")
    public String deleteInvoiceById(@PathVariable("id") Integer id){
        serviceService.deleteById(id);
        return "redirect:/service/list";
    }

    @GetMapping("/details/{id}")
    public String getInvoiceDetails(@PathVariable("id") Integer id, Model model){
        model.addAttribute("invoiceParts", serviceService.getPartList(id));
        model.addAttribute("invoiceId", id);
        return "invoiceDetails";
    }

    @GetMapping("/details/{id}/delete/{partId}")
    public String deletePart(@PathVariable("id") Integer id, @PathVariable("partId") Integer partId){
        System.out.println(id);
        System.out.println(partId);
        serviceService.deletePart(id, partId);
        return "redirect:/service/details/{id}";
    }

    @GetMapping("/details/{id}/new")
    public String addNewPartPage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("orderPart", new OrderPart());
        model.addAttribute("partList", serviceService.getPartList());
        model.addAttribute("invoiceId", id);
        return "newPartForOrderPage";
    }

    @PostMapping("/details/{id}/new")
    public String addNewPart(@PathVariable("id") Integer id, OrderPart orderPart){
        orderPart.setInvoice(invoiceRepository.getById(id));
        System.out.println(id);
        System.out.println(orderPart.getPart().getId());
        System.out.println(orderPart.getAmount());
        serviceService.saveOrderPart(orderPart.getAmount(), id, orderPart.getPart().getId());
        serviceService.saveNewOrderPart(orderPart);
//        TODO сделать сервис для редактирования списка запчастей
        return "redirect:/service/details/{id}";
    }
}
