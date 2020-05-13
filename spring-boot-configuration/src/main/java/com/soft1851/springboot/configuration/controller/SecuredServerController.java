package com.soft1851.springboot.configuration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author: zeng
 * @date: 2020/5/12
 * @description:HTTPS测试
 */
@RestController
@Slf4j
class SecuredServerController {

    @RequestMapping("/secured")
    public String secured() {
        log.info("Inside secured()");
        return "Hello user !!! : " + LocalDateTime.now();
    }
}