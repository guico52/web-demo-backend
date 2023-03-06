package com.guico.webdemo.redis;

import com.guico.webdemo.entry.User;
import jakarta.annotation.Resource;
import org.json.JSONObject;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.swing.*;
import static com.guico.webdemo.redis.RedisConstants.*;

@Component
public class SetUser {

    @Resource
    private StringRedisTemplate template;

    public void setTemplate(StringRedisTemplate template) {
        this.template = template;
    }

    public void setUser(User user){
        String json = JSONObject.valueToString(user);
        template.opsForValue().set(USER+user.getId(),json);
    }

}
