package com.example.SmartNotify.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Notificationdata {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is required")
    private String toEmail;

    @NotBlank(message = "Subject is required")
    @Size(max = 100, message = "Subject too long")
    private String subject;

    @NotBlank(message = "Message is required")
    @Size(max = 500, message = "Message too long")
    private String message;

    private String status;
    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        status = "PENDING";
    }



}
