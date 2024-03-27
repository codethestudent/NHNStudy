package com.nhnacademy.demouserservice.controller;

import com.nhnacademy.demouserservice.domain.RetrieveUserDetailResponse;
import com.nhnacademy.demouserservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/{userId}/detail")
    public ResponseEntity<RetrieveUserDetailResponse> retrieveUserDetail(@PathVariable String userId) {
        RetrieveUserDetailResponse response = userService.retrieveUserDetail(userId);
        return ResponseEntity.ok(response);
    }
}
