package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final EmployeeService employeeService;

    @Autowired
    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getAdminPage(){
        return "adminPage";
    }
    @GetMapping("/employee")
    public String getEmployee(Model model){
        model.addAttribute("employees", employeeService.getEmployee());
        System.out.println(employeeService.getEmployee());
        return "employeeListPage";
    }
}
