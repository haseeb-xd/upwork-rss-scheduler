package com.haseeb.upwork_rss_scheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final Logger log = LoggerFactory.getLogger(EmailService.class);


    @Autowired
    private JavaMailSender emailSender;

    @Value("${RECIPIENT_EMAIL}")
    String recipientEmail;
    public void sendEmail(String subject, String body, String link) {
        log.info("Sending email to: {}", recipientEmail);

        log.debug("Subject: {}", subject);
        log.debug("Body: {}", body);
        log.debug("Link: {}", link);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(body + "\n\n" + link);
        emailSender.send(message);
    }
}
