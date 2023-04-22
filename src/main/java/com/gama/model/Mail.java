package com.gama.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@Entity
@RequiredArgsConstructor
public class Mail {

//    @Id
//    private Long id;
    private String toEmail;
    private String subject;
    private String object;

}
