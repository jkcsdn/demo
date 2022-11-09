package cn.wolfcode.demo.service;

import cn.wolfcode.demo.entiy.User;

public interface UserService {
    /**
    *根据用户名和密码登录
    *@param user
    * return
    */
    User login(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int update(User user);
}
