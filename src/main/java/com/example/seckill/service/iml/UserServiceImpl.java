package com.example.seckill.service.iml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.exception.GlobalException;
import com.example.seckill.mapper.UserMapper;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import com.example.seckill.utils.CookieUtil;
import com.example.seckill.utils.MD5Util;
import com.example.seckill.utils.UUIDUtil;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;
import com.example.seckill.vo.RespBeanEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author chunyan.li
 * @since 2022-04-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String passWord = loginVo.getPassword();
//        //参数校验
//        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(passWord)) {
//            return RespBean.error(RespBeanEnum.LOGIN_EEROR);
//        }
//        if (!ValidateUtil.isMobile(mobile)) {
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }
        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null == user) {
            //return RespBean.error(RespBeanEnum.LOGIN_EEROR);
            throw new GlobalException(RespBeanEnum.LOGIN_EEROR);
        }
        //判断密码是否正确
        if (!MD5Util.fromPassToDBPass(passWord, user.getSalt()).equals(user.getPassword())) {
            //return RespBean.error(RespBeanEnum.LOGIN_EEROR);
            throw new GlobalException(RespBeanEnum.LOGIN_EEROR);
        }
        //生成cookie
        String ticket = UUIDUtil.uuid();
        //将用户信息存入redis中
        redisTemplate.opsForValue().set("user"+ticket, user);
        //request.getSession().setAttribute(ticket,user);//session存用户
        CookieUtil.setCookie(request,response,"userTicket",ticket);//cookie存ticket
        return RespBean.success(ticket);
    }

    /**
     * 根据cookie获取用户
     */
    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)){
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user" + userTicket);
        if (user != null){
            CookieUtil.setCookie(request, response,"userTicket",userTicket);//防止cookie失效
        }
        return user;
    }

    /**
     * 更新密码
     * @param userTicket
     * @param password
     * @param request
     * @param response
     * @return
     */
    @Override
    public RespBean updatePassword(String userTicket,  String password, HttpServletRequest request, HttpServletResponse response) {
        User user = getUserByCookie(userTicket, request, response);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.MOBILE_NOT_EXIST);
        }
        user.setPassword(MD5Util.inputPassToDBPass(password,user.getSalt()));
        int result = userMapper.updateById(user);
        if (1 == result) {
            //删除Redis
            redisTemplate.delete("user:" + userTicket);
            return RespBean.success();
        }
        return RespBean.error(RespBeanEnum.PASSWORD_UPDATE_FAIL);
    }

}
