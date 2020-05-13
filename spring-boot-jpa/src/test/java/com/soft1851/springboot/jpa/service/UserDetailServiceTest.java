package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.dto.UserDetailParam;
import com.soft1851.springboot.jpa.model.cascade.UserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailServiceTest {

    @Resource
    private UserDetailService userDetailService;

    @Test
    public void testFindByCondition()  {
        int page=0,size=10;
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        UserDetailParam param=new UserDetailParam();
        param.setIntroduction("程序员");
        param.setMinAge(10);
        param.setMaxAge(30);
        Page<UserDetail> page1=userDetailService.findByCondition(param,pageable);
        for (UserDetail userDetail:page1){
            System.out.println("userDetail: "+userDetail.toString());
        }
    }
}