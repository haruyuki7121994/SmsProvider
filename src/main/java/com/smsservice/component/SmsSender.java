package com.smsservice.component;

import com.smsservice.model.ProviderEnum;
import org.springframework.stereotype.Component;

@Component
public class SmsSender {
    private SendingMethod method;
    private final String PROVIDER_PACKAGE_NAME = "com.smsservice.component.provider";

    public void setMethod(SendingMethod method) {
        this.method = method;
    }

    public boolean send(String phone, String content) {
        return this.method.send(phone, content);
    }

    public SendingMethod createSendingMethod(String type) {
        try {
            String className = getClassName(type.trim().toUpperCase());
            if (className == null) return null;

            String sendingMethodName = String.format("%s.%sSendingMethod", PROVIDER_PACKAGE_NAME, className);
            Class<?> ref = Class.forName(sendingMethodName);
            return (SendingMethod) ref.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    private String getClassName(String upperStr) {
        for (ProviderEnum provider : ProviderEnum.values()) {
            if (provider.name().equals(upperStr)) return provider.getProviderName();
        }
        return null;
    }
}
