package com.example.seckill.vo;

import com.example.seckill.utils.ValidateUtil;
import com.example.seckill.validator.IsMobile;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.util.annotation.ConstraintAnnotationDescriptor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 手机号码校验规则
 * @author: chunyan.li
 * @time: 2022/5/6 17:37
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidateUtil.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidateUtil.isMobile(value);
            }
        }
    }
}
