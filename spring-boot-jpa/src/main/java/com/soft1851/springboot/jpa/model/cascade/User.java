package com.soft1851.springboot.jpa.model.cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Zeng
 * @ClassName User
 * @Description TOOD
 * @Date 2020/5/12
 * @Version 1.0
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String email;
    @Column(unique = true)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String nickName;
    @Column(nullable = false)
    private String regTime;

    public User(String userName, String email, String nickName, String passWord, String regTime) {
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.nickName = nickName;
        this.regTime = regTime;
    }
}