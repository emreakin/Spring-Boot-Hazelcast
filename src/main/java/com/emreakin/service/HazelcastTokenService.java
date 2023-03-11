package com.emreakin.service;

import com.emreakin.configuration.HazelcastMapProperties;
import com.emreakin.model.HazelcastMapModel;
import com.emreakin.model.TokenModel;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HazelcastTokenService implements InitializingBean {

    private final HazelcastMapProperties hazelcastMapProperties;
    private final HazelcastInstance hazelcastInstance;
    private IMap<String, TokenModel> tokenMap;

    private final String TOKEN_KEY = "token";

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HazelcastMapModel> maps = hazelcastMapProperties.getMaps();
        if(maps != null) {
            HazelcastMapModel mapConfig = maps.stream().filter(map -> map.getKey().equals(TOKEN_KEY)).toList().get(0);
            tokenMap = hazelcastInstance.getMap(mapConfig.getName());
            hazelcastInstance.getConfig().addMapConfig(new MapConfig(mapConfig.getName()).setTimeToLiveSeconds(mapConfig.getTtl())); // adding ttl to config from properties as seconds
        }
    }

    public TokenModel getToken(String userName) {
        TokenModel tokenModel = tokenMap.get(userName);
        if(tokenModel != null)
            return tokenModel;

        String generatedToken = UUID.randomUUID().toString();
        tokenModel = TokenModel.builder()
                .token(generatedToken)
                .creationDate(new Date())
                .build();

        tokenMap.set(userName, tokenModel);

        return tokenModel;
    }
}
