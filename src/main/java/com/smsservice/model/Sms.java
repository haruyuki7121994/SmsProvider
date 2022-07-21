package com.smsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sms {
    @NotBlank
    private String type;
    @NotBlank
    private String phone;
    @NotBlank
    private String content;
}
