package com.example.SmartNotify.Services;

import com.example.SmartNotify.Models.Notificationdata;
import com.example.SmartNotify.Respository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationService {
    @Autowired
    private NotificationRepo nr;

    @Autowired
    private EmailAsynser em;




    public String send(List<Notificationdata> data) {
        for(Notificationdata n:data) {
            nr.save(n); //prepersit set the status to pending
           em.sendMailAsync(n);

        }
        return "processed all notifications";
    }

    public List<Notificationdata> getAll() {
        return nr.findAll();
    }

}
