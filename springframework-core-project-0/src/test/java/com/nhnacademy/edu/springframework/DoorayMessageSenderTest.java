package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhnacademy.edu.springframework.sender.DoorayHookSender;
import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoorayMessageSenderTest {
    private User user;
    @Mock
    private DoorayHookSender hookSender;
    @InjectMocks
    private DoorayMessageSender messageSender;

    @BeforeEach
    public void setup() {
        user = new User("하준영", "010-2779-4917");
    }

    @Test
    public void testSendmessage() {
        Assertions.assertTrue(messageSender.sendMessage(user, "hello dooray!!"));
        verify(hookSender).send(any(DoorayHook.class));
    }
}
