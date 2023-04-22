package com.gama.service;

import com.gama.model.dto.MailPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SenderMailService {

    private final JavaMailSender mailSender;

    public void sender(MailPayload mailPayload) {
        log.info("[SenderMailService] Starting process to send mail to {}", mailPayload.getToEmail());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailPayload.getToEmail());
        message.setCc(mailPayload.getCc());
        message.setText(mailPayload.getObject());
        message.setSubject(mailPayload.getSubject());

        mailSender.send(message);
        log.info("[sender] mail sended with successfull");
    }
}
