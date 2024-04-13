package com.nhnacademy.demouserservice.controller;

import com.nhnacademy.demouserservice.domain.RetrieveUserDetailResponse;
import com.nhnacademy.demouserservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}/detail")
    public ResponseEntity<RetrieveUserDetailResponse> retrieveUserDetail(@PathVariable String userId) {
        log.warn("이거 보세요"+userId);
        RetrieveUserDetailResponse response = userService.retrieveUserDetail(userId);
        return ResponseEntity.ok(response);
    }
}
