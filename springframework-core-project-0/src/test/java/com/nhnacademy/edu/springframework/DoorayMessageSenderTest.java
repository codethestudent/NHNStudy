package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhnacademy.edu.springframework.sender.DoorayHookSender;
import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DoorayMessageSenderTest {
    private User user;
    @Mock
    private DoorayHookSender hookSender;
    @InjectMocks
    private DoorayMessageSender messageSender;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        user = new User("하준영", "010-2779-4917");
    }

    @Test
    public void testSendmessage() {
        Assertions.assertTrue(messageSender.sendMessage(user, "hello dooray!!"));
        verify(hookSender).send(any(DoorayHook.class));
    }
}
