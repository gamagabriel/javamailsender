package com.gama.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SenderEmail {

    private final JavaMailSender mailSender;

    public void sender(
                        String toEmail,
                        String subject,
                        String object) {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setCc("EMAIL-COPY");
            message.setText(object);
            message.setSubject(subject);

            mailSender.send(message);
            log.info("[SenderService] Mail sended to {}", toEmail);
    }
}
