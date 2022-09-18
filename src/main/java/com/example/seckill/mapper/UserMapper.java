package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.User;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author chunyan.li
 * @since 2022-04-06
 */
public interface UserMapper extends BaseMapper<User> {

    public User selectById() ;
}
