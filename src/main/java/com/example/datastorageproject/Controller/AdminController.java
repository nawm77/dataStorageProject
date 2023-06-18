package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.Employee;
import com.example.datastorageproject.Model.Position;
import com.example.datastorageproject.Model.Role;
import com.example.datastorageproject.Repository.PositionRepository;
import com.example.datastorageproject.Service.CustomerService;
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
import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('admin:write')")
public class AdminController {
    private final EmployeeService employeeService;
    private final PositionRepository positionRepository;
    private final CustomerService customerService;

    @Autowired
    public AdminController(EmployeeService employeeService, PositionRepository positionRepository, CustomerService customerService) {
        this.employeeService = employeeService;
        this.positionRepository = positionRepository;
        this.customerService = customerService;
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
        List<Enum> roleList = List.of(Role.ADMIN, Role.CUSTOMER, Role.EMPLOYEE);
        List<Position> positionList = positionRepository.findAll();
        System.out.println(positionList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("roleList", roleList);
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "editEmployee";
    }

    @PostMapping("/employee/edit/{id}")
    public String saveEditedEmployee(@Valid Employee employee, @PathVariable("id") Integer id, Errors errors){
        if (errors.hasErrors()){
            return "editEmployee";
        }
        System.out.println(employee.getPosition());
        employeeService.saveEmployee(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/employee/new")
    public String getNewEmplPage(Model model){
        model.addAttribute("employee", new Employee());
        List<Enum> roleList = List.of(Role.ADMIN, Role.CUSTOMER, Role.EMPLOYEE);
        model.addAttribute("roleList", roleList);
        return "newEmplPage";
    }

    @PostMapping("/employee/new")
    public String addEmployee(Employee employee){
        System.out.println(employee.getId());
        employee.setPosition(positionRepository.getById(0));
        employeeService.saveEmployee(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteById(id);
        return "redirect:/admin/employee";
    }

    @GetMapping("/customer")
    public String getCustomerList(Model model){
        model.addAttribute("list", customerService.getCustomerDTO());
        return "customerList";
    }

    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomerById(id);
        return "customerList";
    }
}
