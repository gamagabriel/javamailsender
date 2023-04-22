package com.gama.web;

import com.gama.model.dto.MailPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/mail")
public interface MailSenderController {

    @ResponseStatus(CREATED)
    @PostMapping("/sender")
    void sender(@RequestBody MailPayload mailPayload);
}
