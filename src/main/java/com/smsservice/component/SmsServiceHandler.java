package com.smsservice.component;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SmsServiceHandler {
    Map<String, SendingMethod> handler = new HashMap<>();

    public void register(String type, SendingMethod sendingMethod) {
        handler.put(type, sendingMethod);
    }

    public SendingMethod getService(String type) {
        return handler.get(type);
    }
}
