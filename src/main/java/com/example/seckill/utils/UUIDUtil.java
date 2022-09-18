package com.example.seckill.utils;

import java.util.UUID;

/**
 * @description: UUIDUtil工具类
 * @author: chunyan.li
 * @time: 2022/5/7 16:51
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
