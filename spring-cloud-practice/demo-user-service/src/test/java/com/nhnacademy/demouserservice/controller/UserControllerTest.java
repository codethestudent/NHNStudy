package com.nhnacademy.demouserservice.controller;


import com.nhnacademy.demouserservice.domain.RetrieveUserDetailResponse;
import com.nhnacademy.demouserservice.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;

    @Test
    @DisplayName("유저 디테일 요청 테스트")
    void retrieveUserDetailTest() throws Exception {
        String testId = "testId";
        String testPw = "testPw";

        RetrieveUserDetailResponse response = new RetrieveUserDetailResponse(testId, testPw);
        given(userService.retrieveUserDetail(any())).willReturn(response);

        mockMvc.perform(get("/users/{userId}/detail", testId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(testId))
                .andExpect(jsonPath("$.pw").value(testPw));
    }
}
