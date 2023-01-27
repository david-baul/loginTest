package com.example.logintest.mapper;

import com.example.logintest.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    Map<String, Object> getId(Map<String, Object> paramMap);

    Map<String, Object> getDupId(Map<String, Object> paramMap);

    Map<String, Object> getLoginTime(String paramMap);
    Map<String, Object> getLoginCnt(String paramMap);

    void insertUser(Map<String, Object> paramMap);

    void insertLoginTime(Map<String, Object> paramMap);
    List<User> getUser(User user);

}
