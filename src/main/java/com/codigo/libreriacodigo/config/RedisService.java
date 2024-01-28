package com.codigo.libreriacodigo.config;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private final StringRedisTemplate stringRedisTemplate;

    public RedisService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void saveInCache(String key, String value, int exp) {
        stringRedisTemplate.opsForValue().set(key, value);
        stringRedisTemplate.expire(key,exp, TimeUnit.MINUTES);
    }
    public String getValueFromCache(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    public void deleteInCache(String key) {
        stringRedisTemplate.delete(key);
    }
}
