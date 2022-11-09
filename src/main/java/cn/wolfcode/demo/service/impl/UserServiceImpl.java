package cn.wolfcode.demo.service.impl;

import cn.wolfcode.demo.entiy.User;
import cn.wolfcode.demo.mapper.UserMapper;
import cn.wolfcode.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper; //注入UserMapper

    @Override
    public User login(User user){
        return userMapper.login(user); //调用mapper层代码
    }

    @Override
    public int update(User user) {
        //调用mapper层代码
        return userMapper.update(user);
    }
}
