package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.cascade.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZENG
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过username查
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 通过Email、username查
     * @param username
     * @param email
     * @return
     */
    User findByUserNameOrEmail(String username,String email);

}
