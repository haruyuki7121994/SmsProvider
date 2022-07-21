package com.smsservice.model;

public enum ProviderEnum {
    VIETGUYS("Vietguys"),
    VMGS("Vmgs"),
    FPT("Fpt");

    private final String providerName;
    ProviderEnum(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }
}
