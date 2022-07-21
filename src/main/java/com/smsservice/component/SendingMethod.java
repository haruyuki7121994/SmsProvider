package com.smsservice.component;


public interface SendingMethod {
    boolean send(String phone, String content);
}
