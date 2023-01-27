package com.example.logintest.service;

import com.example.logintest.domain.User;
import com.example.logintest.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public Map<String, Object> getId(Map<String, Object> paramMap) {
        return userMapper.getId(paramMap);
    }

    public Map<String, Object> getDupId(Map<String, Object> paramMap) {
        return userMapper.getDupId(paramMap);
    }

    public Map<String, Object> getLoginTime(String paramMap) {
        return userMapper.getLoginTime(paramMap);
    }

    public Map<String, Object> getLoginCnt(String paramMap) {
        return userMapper.getLoginCnt(paramMap);
    }

    public void insertLoginTime(Map<String, Object> paramMap) {
        userMapper.insertLoginTime(paramMap);
    }

    public void insertUser(Map<String, Object> paramMap){
        userMapper.insertUser(paramMap);
    }

    public List<User> getUser(User user) {
        return userMapper.getUser(user);
    }

}
