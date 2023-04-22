package com.gama.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailPayload {

    private String toEmail;
    private String subject;
    private String object;
    private String cc;

}
