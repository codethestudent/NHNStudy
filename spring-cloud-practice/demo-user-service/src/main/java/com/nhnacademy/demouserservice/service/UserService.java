package com.nhnacademy.demouserservice.service;

import com.nhnacademy.demouserservice.domain.RetrieveUserDetailResponse;

public interface UserService {

    RetrieveUserDetailResponse retrieveUserDetail(String userId);
}
