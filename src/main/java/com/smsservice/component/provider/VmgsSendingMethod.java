package com.smsservice.component.provider;

import com.smsservice.component.SendingMethod;
import com.smsservice.component.SmsServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VmgsSendingMethod implements SendingMethod {
    public VmgsSendingMethod(@Autowired SmsServiceHandler smsServiceHandler) {
        smsServiceHandler.register("VMGS", this);
    }
    @Override
    public boolean send(String phone, String content) {
        return true;
    }
}
