package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.User;
import com.soft1851.springboot.jpa.repository.test1.UserTest1Repository;
import com.soft1851.springboot.jpa.repository.test2.UserTest2Repository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@SpringBootTest
public class UserRepositoryTests {

    @Resource
    private UserTest1Repository userTest1Repository;
    @Resource
    private UserTest2Repository userTest2Repository;

    @Test
    public void testSave() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userTest1Repository.save(new User("aa","aa@126.com","aa","aa123456",formattedDate));
        userTest1Repository.save(new User("bb","bb@126.com","bb","bb123456",formattedDate));
        userTest2Repository.save(new User("cc","cc@126.com","cc","cc123456",formattedDate));

    }

    @Test
    public void testDelete() throws Exception {
        userTest1Repository.deleteAll();
        userTest2Repository.deleteAll();
    }
}
