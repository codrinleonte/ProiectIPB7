package com.fiiLicence.fiiLicence.models.requests;

public class ConfirmRegistrationRequest {
    private String confirmToken;

    public String getConfirmToken() {
        return confirmToken;
    }

    public void setConfirmToken(String confirmToken) {
        this.confirmToken = confirmToken;
    }
}
