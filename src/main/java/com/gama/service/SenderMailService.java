package com.gama.service;

import com.gama.model.dto.MailPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@Service
@RequiredArgsConstructor
public class SenderMailService {

    private final JavaMailSender mailSender;

    public void sender(MailPayload mailPayload) {
        log.info("[sender] Starting process to send mail. {}",
                kv("receiver", mailPayload.getToEmail()));

        SimpleMailMessage message = buildMessage(mailPayload);

        try {
            mailSender.send(message);
        } catch (Exception e) {
            log.error("[sender] error when trying to send email. {}",
                    kv("receiver", mailPayload.getToEmail()));
            throw new RuntimeException(e);
        }
        log.info("[sender] mail sended with successfull");

    }

    private SimpleMailMessage buildMessage(MailPayload mailPayload) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailPayload.getToEmail());
        message.setCc(mailPayload.getCc());
        message.setText(mailPayload.getObject());
        message.setSubject(mailPayload.getSubject());
        return message;
    }

}
