package com.nhnacademy.demouserservice.service;

import com.nhnacademy.demouserservice.domain.RetrieveUserDetailResponse;
import com.nhnacademy.demouserservice.domain.User;
import com.nhnacademy.demouserservice.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void BeforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("유저 디테일 조회 서비스 테스트")
    void retrieveUserDetailTest() {
        //given
        //when userService.retrieveUserDetail(userId);
        //then RetrieveUserDetailResponse response

        String userId = "userId";
        String userPw = "userPw";
        String userName = "userName";
        User user = User.createUser(userId, userPw, userName);
        given(userRepository.findById(any())).willReturn(Optional.of(user));

        RetrieveUserDetailResponse response = userService.retrieveUserDetail(userId);

        Assertions.assertThat(response.getId()).isEqualTo(userId);
        Assertions.assertThat(response.getPw()).isEqualTo(userPw);
    }
}
