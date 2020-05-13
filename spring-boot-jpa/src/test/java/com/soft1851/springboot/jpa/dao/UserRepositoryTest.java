package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.cascade.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void test()  {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userRepository.save(new User("aa","aa@126.com","aa","aa123456",formattedDate));
        userRepository.save(new User("bb","bb@126.com","bb","bb123456",formattedDate));
        userRepository.save(new User("cc","cc@126.com","cc","cc123456",formattedDate));

        log.info(String.valueOf(userRepository.findAll().size()));
        assertEquals("bb",userRepository.findByUserNameOrEmail("bb","bb@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa"));
    }

}