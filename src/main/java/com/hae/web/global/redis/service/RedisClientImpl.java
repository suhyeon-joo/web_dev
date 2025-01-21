package com.hae.web.global.redis.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hae.web.global.redis.config.RedisConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@ConditionalOnBean({RedisConfig.class})
@RequiredArgsConstructor
@Slf4j
public class RedisClientImpl implements RedisClient{
    private final ObjectMapper objectMapper;
    private final RedisTemplate<String, String> redisTemplate;

    public void put(String key, String data, long expiration){
        try{
            ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
            valueOps.set(key, data, expiration, TimeUnit.SECONDS);
        }
        catch (Exception var4){
            log.error("[Redis] put error key [{}] , data [{}]", key, data);
        }
    }

    public String get(String key){
        try{
            ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
            log.info("[Redis Request]\n get KEY [{}]", key);
            log.info(valueOps.get(key));
            return valueOps.get(key);
        }catch (Exception var3){
            log.error("[Redis] Error with get Key [{}]",key);
            return var3.getMessage();
        }
    }

    public void delete(String key){
        try{
            log.info("[Redis Request]\n delete KEY [{}]", key);
            log.info(get(key));
            if(get(key) != null){
                log.info("delete KEY [{}]", key);
                redisTemplate.delete(key);
            }

        }
        catch (Exception var3){
            log.error("[Redis] Error with delete Key [{}]",key);
            log.error(var3.getMessage());
        }
    }
}
