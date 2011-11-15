package com.clouway.testing.sms;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface SmsGateway {

    String sendSms(SmsMessage message);
}
