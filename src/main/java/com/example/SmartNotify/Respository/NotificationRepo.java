package com.example.SmartNotify.Respository;

import com.example.SmartNotify.Models.Notificationdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationRepo extends JpaRepository<Notificationdata,Long> {
    

}
