package com.emreakin.controller;

import com.emreakin.model.TokenModel;
import com.emreakin.model.UserTokenRequestModel;
import com.emreakin.service.HazelcastTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private final HazelcastTokenService hazelcastTokenService;

    @PostMapping("/getUserToken")
    public TokenModel getTokenByUserName(@RequestBody UserTokenRequestModel userTokenRequest) {
        return hazelcastTokenService.getToken(userTokenRequest.getUserName());
    }
}
