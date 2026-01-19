package com.emailservice.jdp.EmailService.service;

import com.emailservice.jdp.EmailService.entity.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Async
    public String sendEmail(EmailRequest request) {

        try {
            Context context = new Context();
            context.setVariable("name", request.getUserName());
            String htmlContent = templateEngine.process("Feedback", context);
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(request.getSenderEmail());
            helper.setSubject("Feedback from Krishna");
            helper.setText(htmlContent, true);
            helper.setFrom("krishna.mugala9@gmail.com", " MK-Portfolio");
            helper.setReplyTo("krishna.mugala9@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Email sending failed", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        }
        return "Email Sent Successfully";
    }
}
