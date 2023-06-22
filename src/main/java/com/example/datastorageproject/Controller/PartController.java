package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/part")
public class PartController {
    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/")
    public String getAllParts(Model model){
        model.addAttribute("parts", partService.getAllPartsDTO());
        return "partList";
    }
}
