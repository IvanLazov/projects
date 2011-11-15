package com.clouway.testing.sms;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class SmsService {

    private final SmsGateway smsGateway;

    /**
     * Sets the gateway which the SmsService will use to send sms messages
     *
     * @param smsGateway   the gateway which will send sms messages
     */
    public SmsService(SmsGateway smsGateway) {

        this.smsGateway = smsGateway;
    }

    /**
     * Sends sms message if the length of the message is between 1 and 20
     *
     * @param smsMessage   the message to be send
     */
    public void sendSms(SmsMessage smsMessage) {

        checkTextLength(smsMessage.getMessage());

        smsGateway.sendSms(smsMessage);
    }

    /**
     * Checks the length of the sms message
     *
     * @param smsMessage   the message to be checked
     */
    private void checkTextLength(String smsMessage) {

        if (smsMessage.length() < 1) {
            throw new EmptyMessageException();
        } else if (smsMessage.length() > 20) {
            throw new LongMessageException();
        }
    }
}
