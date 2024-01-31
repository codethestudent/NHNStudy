package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DoorayMessageSenderTest {

    @Test
    public void testSendmessage() {
        MessageSender mockMessageSender = mock(DoorayMessageSender.class);
        User user = new User("하준영", "01027794111");
        when(mockMessageSender.sendMessage(user, "hello dooray!~")).thenReturn(true);
        assertTrue(mockMessageSender.sendMessage(user, "hello dooray!~"));
        verify(mockMessageSender, times(1)).sendMessage(user, "hello dooray!~");
    }
}
