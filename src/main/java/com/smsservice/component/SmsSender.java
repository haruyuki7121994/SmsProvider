package com.smsservice.component;

import com.smsservice.model.ProviderEnum;
import org.springframework.stereotype.Component;

@Component
public class SmsSender {
    private SendingMethod method;

    public void setMethod(SendingMethod method) {
        this.method = method;
    }

    public boolean send(String phone, String content) {
        return this.method.send(phone, content);
    }
}
