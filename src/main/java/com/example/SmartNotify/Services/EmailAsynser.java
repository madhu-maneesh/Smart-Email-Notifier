package com.example.SmartNotify.Services;

import com.example.SmartNotify.Models.Notificationdata;
import com.example.SmartNotify.Respository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailAsynser {
    @Autowired
    private JavaMailSender jm;

    @Autowired
    private NotificationRepo nr;

    @Async
    public void sendMailAsync(Notificationdata n) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom("your_email@gmail.com");
            mail.setTo(n.getToEmail());
            mail.setSubject(n.getSubject());
            mail.setText(n.getMessage());

            jm.send(mail);

            n.setStatus("SENT");
        } catch (Exception e) {
            n.setStatus("FAILED");
        }

        nr.save(n);
    }

}
