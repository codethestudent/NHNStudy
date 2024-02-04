package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhnacademy.edu.springframework.sender.impl.DoorayHookSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;

public class DoorayHookSenderTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private DoorayHookSender doorayHookSender;

    private final String testUrl = "http://example.com/hook";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        doorayHookSender = new DoorayHookSender(restTemplate, testUrl);
    }

    @Test
    void sendTest() {
        // 준비
        DoorayHook doorayHook = new DoorayHook(); // 여기서 DoorayHook는 예시입니다. 실제 구현에 맞게 조정해주세요.
        // 실행
        doorayHookSender.send(doorayHook);
        // 검증
        verify(restTemplate).postForObject(testUrl, doorayHook, String.class);
    }
}
