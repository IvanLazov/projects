package com.clouway.testing.sms;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class SmsServiceTest {

    Mockery context = new JUnit4Mockery();

    @Test
    public void happyPath() {

        final SmsGateway smsGateway = context.mock(SmsGateway.class);
        final SmsMessage smsMessage = new SmsMessage("0884669080", "Hello");

        context.checking(new Expectations() {{
            oneOf(smsGateway).sendSms(smsMessage);
            will(returnValue("Message sent"));
        }});

        SmsService smsService = new SmsService(smsGateway);
        smsService.sendSms(smsMessage);
    }

    @Test(expected = EmptyMessageException.class)
    public void cannotSendEmptyMessage() {
        sendSms(new SmsMessage("0884669080", ""));
    }

    @Test(expected = LongMessageException.class)
    public void cannotSendLongMessage() {
        sendSms(new SmsMessage("0884669080", "hellohellohellohellohellohello"));
    }

    private void sendSms(SmsMessage smsMessage) {
        new SmsService(null).sendSms(smsMessage);
    }
}
