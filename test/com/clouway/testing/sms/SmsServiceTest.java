package com.clouway.testing.sms;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

//@RunWith(JMock.class)
public class SmsServiceTest {

//    private Mockery context = new JUnit4Mockery();
//    private final SmsGateway smsGateway = context.mock(SmsGateway.class);
    private final MockSmsGateway smsGateway = new MockSmsGateway();
    private SmsService smsService = new SmsService(smsGateway);

    @Test
    public void happyPath() {


        final SmsMessage smsMessage = new SmsMessage("0884669080", "Hello");
//
//        context.checking(new Expectations() {{
//            oneOf(smsGateway).sendSms(smsMessage);
//            will(returnValue("Message sent"));
//        }});

        smsService.sendSms(smsMessage);
        assertEquals(smsMessage,smsGateway.message);
    }

    @Test(expected = EmptyMessageException.class)
    public void cannotSendEmptyMessage() {
        smsService.sendSms(new SmsMessage("0884669080", ""));
    }

    @Test(expected = LongMessageException.class)
    public void cannotSendLongMessage() {
        smsService.sendSms(new SmsMessage("0884669080", "hellohellohellohellohellohello"));
    }


    private class MockSmsGateway implements SmsGateway {
        private SmsMessage message;

        public String sendSms(SmsMessage message) {
            this.message = message;
            return null;
        }
    }
}
