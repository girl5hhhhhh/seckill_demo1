package com.example.seckill.config;

import com.example.seckill.pojo.User;

/**
 * @description:
 * @author: chunyan.li
 * @time: 2022/9/14 21:56
 */
public class UserContext {
    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }
}
