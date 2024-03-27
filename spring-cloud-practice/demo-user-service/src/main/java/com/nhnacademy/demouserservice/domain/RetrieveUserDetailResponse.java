package com.nhnacademy.demouserservice.domain;

import lombok.Getter;

@Getter
public class RetrieveUserDetailResponse {
    private final String id;
    private final String pw;

    public RetrieveUserDetailResponse(String testId, String testPw) {
        this.id = testId;
        this.pw = testPw;
    }
}
