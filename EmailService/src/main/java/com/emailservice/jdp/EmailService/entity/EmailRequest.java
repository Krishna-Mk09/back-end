package com.emailservice.jdp.EmailService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailRequest {
    private String senderEmail;
    private String userName;

}
