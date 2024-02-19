package com.nhnacademy.edu.springboot.studentmanagement.service;

import com.nhnacademy.edu.springboot.studentmanagement.domain.LoginRequest;
import com.nhnacademy.edu.springboot.studentmanagement.entity.User;
import com.nhnacademy.edu.springboot.studentmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public User match(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findById(loginRequest.getUserId());
        if (user.isPresent() &&
                user.get().getUserId().equals(loginRequest.getUserId()) &&
                user.get().getUserPassword().equals(loginRequest.getUserPassword())) {
            return user.get();
        }
        return null;
    }

}
