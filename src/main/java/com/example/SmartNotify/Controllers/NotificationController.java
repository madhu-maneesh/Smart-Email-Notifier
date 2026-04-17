package com.example.SmartNotify.Controllers;

import com.example.SmartNotify.Models.Notificationdata;
import com.example.SmartNotify.Services.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class NotificationController {
    @Autowired
    NotificationService s;

    @GetMapping("/")
    public String greet(){
        return "Hello!";
    }



    @PostMapping("/send")
    public String send(@Valid @RequestBody List<Notificationdata> n){
        return  s.send(n);
    }

    @GetMapping("/notifications")
    public List<Notificationdata> getAll() {
        return s.getAll();
    }

}
