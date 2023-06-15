package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.Callback;
import com.example.datastorageproject.Service.CallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/callback")
public class CallbackController {
    private final CallbackService callbackService;

    @Autowired
    public CallbackController(CallbackService callbackService) {
        this.callbackService = callbackService;
    }

    @GetMapping("")
    public String getCallbackPage(Model model){
        model.addAttribute("callback", new Callback());
        return "callbackPage";
    }
    @PostMapping("/send")
    public String sendCallback(Callback callback){
        callbackService.saveCallback(callback);
        return "redirect:/";
    }
}
