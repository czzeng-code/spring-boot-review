package com.soft1851.springboot.jpa.dto;

import lombok.Data;

/**
 * @author Zeng
 * @ClassName UserDetailParam
 * @Description TOOD
 * @Date 2020/5/13
 * @Version 1.0
 **/
@Data
public class UserDetailParam {
    private Integer minAge;
    private Integer maxAge;
    private String realName;
    private String introduction;
}
