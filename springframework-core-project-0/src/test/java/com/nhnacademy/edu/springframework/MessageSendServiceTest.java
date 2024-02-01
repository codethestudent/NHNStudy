package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class MessageSendServiceTest {
    private User user;
    @InjectMocks
    private MessageSendService mockMessageSendService;
    @Mock
    private DoorayMessageSender mockDoorayMessageSender;

    @BeforeEach
    void setup() {
        user = new User("jun", "01029297979");
    }

    @Test
    void sendServiceTest() {
        when(mockDoorayMessageSender.sendMessage(user, "hello dooray!")).thenReturn(true);
        Assertions.assertTrue(mockMessageSendService.doSendMessage(user, "hello dooray!"));
        verify(mockDoorayMessageSender).sendMessage(user, "hello dooray!");
    }
}
