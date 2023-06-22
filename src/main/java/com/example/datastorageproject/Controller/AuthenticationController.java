package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.Role;
import com.example.datastorageproject.Model.Status;
import com.example.datastorageproject.Model.User;
import com.example.datastorageproject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    private final CustomerService customerService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(CustomerService customerService, AuthenticationManager authenticationManager) {
        this.customerService = customerService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
        return "redirect:/home";
    }

    @GetMapping("/reg")
    public String getRegPage(Model model) {
        model.addAttribute(new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String registerUser(@ModelAttribute("user") User user) {
        user.setRole(Role.CUSTOMER);
        user.setStatus(Status.ACTIVE);
        customerService.addUser(user);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/";
    }
}