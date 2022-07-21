package com.smsservice.component.provider;

import com.smsservice.component.SendingMethod;

public class VmgsSendingMethod implements SendingMethod {
    @Override
    public boolean send(String phone, String content) {
        return true;
    }
}
