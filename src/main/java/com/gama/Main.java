package com.gama;

import com.gama.service.SenderEmail;
import com.gama.service.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class Main extends StringUtils {

    @Autowired
    private SenderEmail senderEmail;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() {
        senderEmail.sender(TO_EMAIL, SUBJECT, OBJECT);
    }
}