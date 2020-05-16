package com.soft1851.springboot.schedule.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Zeng
 * @ClassName Cron
 * @Description Cron表达式实体类
 * @Date 2020/5/16
 * @Version 1.0
 **/
@Data
@Entity
public class Cron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cronId;

    @Column(name = "cron_name", nullable = false, length = 30)
    private String cronName;

    @Column(name = "cron", nullable = false, length = 50)
    private String cron;
}