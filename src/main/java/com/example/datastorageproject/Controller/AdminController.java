package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.Employee;
import com.example.datastorageproject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('admin:write')")
public class AdminController {
    private final EmployeeService employeeService;

    @Autowired
    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getAdminPage() {
        return "adminPage";
    }

    @GetMapping("/employee")
    public String getEmployee(Model model) {
        model.addAttribute("employees", employeeService.getEmployee());
        return "employeeListPage";
    }

    @GetMapping("/employee/edit/{id}")
    public String getEmployeeEditPage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "editEmployee";
    }

    @PostMapping("/employee/edit/{id}")
    public String saveEditedEmployee(@Valid Employee employee, @PathVariable("id") Integer id, Errors errors){
        if (errors.hasErrors()){
            return "editEmployee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/admin/employee";
    }
}
