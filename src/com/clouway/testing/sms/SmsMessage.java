package com.clouway.testing.sms;

public class SmsMessage {

    private final String phoneNumber;
    private final String message;

    public SmsMessage(String phoneNumber, String message) {

        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
}
