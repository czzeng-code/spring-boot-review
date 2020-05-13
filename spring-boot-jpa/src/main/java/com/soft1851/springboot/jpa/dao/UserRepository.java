package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.cascade.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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

    /**
     * 通过Email模糊查询user
     * @param email
     * @return
     */
    List<User> findByEmailLike(String email);

    /**
     * 通过username查询忽略大小写
     * @param userName
     * @return
     */
    User findByUserNameIgnoreCase(String userName);

    /**
     * 计数
     * @param userName
     * @return
     */
    Long countByUserName(String userName);

    /**
     * 查询
     * @param userName
     * @return
     */
    List<User> findByUserNameOrderByEmailDesc(String userName);



}
