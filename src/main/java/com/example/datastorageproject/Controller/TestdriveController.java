package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Component.StringToLocalDateTimeConverter;
import com.example.datastorageproject.Model.TestDrive;
import com.example.datastorageproject.Service.CarService;
import com.example.datastorageproject.Service.CustomerService;
import com.example.datastorageproject.Service.EmployeeService;
import com.example.datastorageproject.Service.TestDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/testdrive")
public class TestdriveController {
    private final CarService carService;
    private final TestDriveService testDriveService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final StringToLocalDateTimeConverter stringToLocalDateTimeConverter;

    @Autowired
    public TestdriveController(CarService carService, TestDriveService testDriveService, CustomerService customerService, EmployeeService employeeService, StringToLocalDateTimeConverter stringToLocalDateTimeConverter) {
        this.carService = carService;
        this.testDriveService = testDriveService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.stringToLocalDateTimeConverter = stringToLocalDateTimeConverter;
    }

    @GetMapping("")
    public String getTestDrivePage(Model model) {
        model.addAttribute("carList", carService.findAvailableCar());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("testdrive", new TestDrive());
        return "testDrivePage";
    }
    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("list", testDriveService.getAll());
        return "testDriveList";
    }

    @PostMapping("/")
    public String saveTestDriveOrder(@RequestParam("dateTime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dateTime, @ModelAttribute("testdrive") TestDrive testDrive, Principal principal, Model model){
        if (principal.getName() != null) {
            testDrive.setDateTime(stringToLocalDateTimeConverter.convert(String.valueOf(dateTime)));
            testDrive.setCustomer(customerService.findCustomerByEmail(principal.getName()));
            testDriveService.save(testDrive);
            return "redirect:/";
        } else{
            model.addAttribute("testdrive", new TestDrive());
            return "testDrivePage";
        }
    }

    @GetMapping("/{id}")
    public String getTestDriveForCustomer(@PathVariable("id") Integer id, Model model, Authentication authentication){
        if(customerService.findCustomerByEmail(authentication.getName()).getId().equals(id)){
            model.addAttribute("list", testDriveService.getById(id));
            return "testDriveById";
        } else{
            return "redirect:/testdrive";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTestDrive(@PathVariable("id") Integer id, Authentication authentication){
        Integer customerId = customerService.findCustomerByEmail(authentication.getName()).getId();
        testDriveService.deleteById(id);
        return "redirect:/testdrive/" + customerId;
    }
    //TODO сделать страницу, где будет выводиться информация о тест драйве для конкретного пользователя

}
