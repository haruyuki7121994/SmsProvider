package com.smsservice.service;

import com.smsservice.component.SendingMethod;
import com.smsservice.component.SmsSender;
import com.smsservice.model.MessageResponse;
import com.smsservice.model.Sms;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class SmsService {
    private final SmsSender smsSender;
    public MessageResponse sendSmsProvider(Sms sms) {
        SendingMethod sendingMethod = smsSender.createSendingMethod(sms.getType());
        if (sendingMethod == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        smsSender.setMethod(sendingMethod);
        boolean result = smsSender.send(sms.getPhone(), sms.getContent());
        String message = result ? "Send SMS successful!" : "Message sending failed!";

        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage(message);
        return messageResponse;
    }
}
