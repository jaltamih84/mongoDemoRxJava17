package com.webapp.banca.demo.business.impl;


import com.webapp.banca.demo.model.entity.ParameterEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisTemplate<String, ParameterEntity> redisTemplate;

    public void put(String key, ParameterEntity value) {
        redisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);
    }

    public ParameterEntity get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Set<String> getAllParametros() {
        String pattern = "map-parametros:*";
        return redisTemplate.keys(pattern);
    }
}