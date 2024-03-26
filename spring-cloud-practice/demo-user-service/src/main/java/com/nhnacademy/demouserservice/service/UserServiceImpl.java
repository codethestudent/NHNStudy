package com.nhnacademy.demouserservice.service;

import com.nhnacademy.demouserservice.domain.RetrieveUserDetailResponse;
import com.nhnacademy.demouserservice.domain.User;
import com.nhnacademy.demouserservice.exception.UserNotFoundException;
import com.nhnacademy.demouserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public RetrieveUserDetailResponse retrieveUserDetail(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        String id = user.getId();
        String pw = user.getPw();
        return new RetrieveUserDetailResponse(id, pw);
    }
}
