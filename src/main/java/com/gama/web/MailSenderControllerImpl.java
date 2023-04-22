package com.gama.web;

import com.gama.exception.InvalidPayloadException;
import com.gama.model.dto.MailPayload;
import com.gama.service.SenderMailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailSenderControllerImpl implements MailSenderController {

    private final SenderMailService senderMailService;

    @Override
    public void sender(MailPayload mailPayload) {
        if (mailPayload.getToEmail() == null) {
            throw new InvalidPayloadException("Payload is null");
        }
        senderMailService.sender(mailPayload);
    }
}
