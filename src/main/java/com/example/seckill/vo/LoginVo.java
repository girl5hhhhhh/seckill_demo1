package com.example.seckill.vo;

import com.example.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @description: 登录参数
 * @author: chunyan.li
 * @time: 2022/4/28 14:55
 */
@Data
public class LoginVo {

    @NotNull
    @IsMobile
    private String mobile;

    @Length(min = 32)
    private String password;
}
