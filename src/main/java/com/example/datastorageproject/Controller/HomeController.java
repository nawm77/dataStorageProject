package com.example.datastorageproject.Controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String greeting(){
        return "homePage";
    }

    @GetMapping("/admin")
//    @PreAuthorize("hasAnyAuthority('admin:read', 'admin:write')")
    public String getAdminPanel(){
        return "adminPage";
    }
}
