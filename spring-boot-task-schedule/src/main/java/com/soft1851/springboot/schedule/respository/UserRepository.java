package com.soft1851.springboot.schedule.respository;

import com.soft1851.springboot.schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Zeng
 * @ClassName UserRepository
 * @Description TOOD
 * @Date 2020/5/16
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 查找当天过生日的用户
     * @return
     */
    @Query(value = "SELECT * FROM user WHERE MONTH(birthday) = MONTH(NOW()) AND DAY(birthday) = DAY(NOW())",nativeQuery = true)
    List<User> findUsersByBirthday();
}
