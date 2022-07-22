package com.smsservice.component.provider;

import com.smsservice.component.SendingMethod;
import com.smsservice.component.SmsServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FptSendingMethod implements SendingMethod {
    public FptSendingMethod(@Autowired SmsServiceHandler smsServiceHandler) {
        smsServiceHandler.register("FPT", this);
    }

    @Override
    public boolean send(String phone, String content) {
        return true;
    }
}
