package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.cascade.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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


    /**
     * 自定义JPQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
     *
     * @param id
     * @return
     */
    @Query("select u from User u where u.id = ?1")
    User findById(long id);

    /**
     * 原生SQL
     * 插入
     *
     * @param userName
     * @param password
     * @param email
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into user(user_name, pass_word,email) values (:userName, :password,:email)", nativeQuery = true)
    int insertUser(@Param("userName") String userName, @Param("password") String password, @Param("email") String email);

    /**
     * 修改userName
     * @param userName
     * @param id
     * @return
     */
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Modifying
    @Query("update User set user_name = ?1 where id = ?2")
    int modifyById(String  userName, Long id);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    Page<User> findByNickName(String nickName, Pageable pageable);
}
