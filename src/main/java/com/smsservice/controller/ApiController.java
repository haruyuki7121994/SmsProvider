package com.smsservice.controller;

import com.smsservice.model.MessageResponse;
import com.smsservice.model.Sms;
import com.smsservice.service.SmsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {
    private final SmsService smsService;

    @PostMapping("/send")
    public ResponseEntity<MessageResponse> sendSms(@RequestBody @Valid Sms sms) {
        return ResponseEntity.ok().body(smsService.sendSmsProvider(sms));
    }
}
