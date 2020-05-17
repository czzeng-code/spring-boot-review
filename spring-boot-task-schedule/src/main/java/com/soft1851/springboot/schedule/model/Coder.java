package com.soft1851.springboot.schedule.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Zeng
 * @ClassName Coder
 * @Description TOOD
 * @Date 2020/5/17
 * @Version 1.0
 **/
@Entity
@Data
public class Coder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "url")
    private String url;
}
