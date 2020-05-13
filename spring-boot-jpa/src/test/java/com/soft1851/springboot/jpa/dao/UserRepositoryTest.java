package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.cascade.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Test
    void testSave() {
        //批量插入
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            User testUser = User.builder()
                    .userName("user" + i)
                    .email("user" + i + "@qq.com")
                    .passWord("123456")
                    .nickName("nickName" + i)
                    .regTime(LocalDateTime.now()+"").build();
            users.add(testUser);
        }
        userRepository.saveAll(users);
    }

    @Test
    void testBaseQuery() {
        userRepository.findAll().forEach(System.out::println);
        log.info(String.valueOf(userRepository.findById(21L)));
        log.info("" + userRepository.count());
        log.info("" + userRepository.existsById(21L));

        userRepository.findByEmailLike("cc@126.com").forEach(System.out::println);
        System.out.println(userRepository.findByUserNameIgnoreCase("CC"));
        log.info(userRepository.countByUserName("cc")+"");  //1
        userRepository.findByUserNameOrderByEmailDesc("cc").forEach(System.out::println);
    }

    @Test
    void findById() {
        assertNotNull(userRepository.findById(20));
    }

    @Test
    void insertUser() {
        int n = userRepository.insertUser("hello", "hello123", "hello@qq.com");
        assertEquals(1, n);
    }

    @Test
    void modifyById() {
        int n = userRepository.modifyById("bb_alter", 20L);
        assertEquals(1, n);
    }

    @Test
    public void testPageQuery()  {
//        int page=1,size=2;
//        Pageable pageable = PageRequest.of(page, size);
//        userRepository.findALL(pageable).forEach(System.out::println);
//        userRepository.findByNickName("aa", pageable).forEach(System.out::println);

        // 查询所有
        userRepository.findAll().forEach(user -> log.info(user.toString()));
        // 分页查询全部，返回封装了的分页信息， jpa页码从0开始
        Page<User> pageInfo = userRepository.findAll(
                PageRequest.of(1, 3, Sort.Direction.ASC, "id"));
        log.info("总记录数： {}", pageInfo.getTotalElements());
        log.info("当前页记录数： {}", pageInfo.getNumberOfElements());
        log.info("每页记录数： {}", pageInfo.getSize());
        log.info("获取总页数： {}", pageInfo.getTotalPages());
        log.info("查询结果： {}", pageInfo.getContent());
        log.info("当前页（从0开始计）： {}", pageInfo.getNumber());
        log.info("是否为首页： {}", pageInfo.isFirst());
        log.info("是否为尾页： {}", pageInfo.isLast());
        // 条件查询
        User user = User.builder().userName("user").build();
        List<User> users = userRepository.findAll(Example.of(user));
        log.info("满足条件的记录有：");
        users.forEach(user1 -> log.info(user1.toString()));
        // 单个查询
        User user1 = User.builder().id(20L).build();
        Optional<User> optionalUser = userRepository.findOne(Example.of(user1));
        log.info("单个查询结果： {}", optionalUser.orElse(null));
    }
}