package com.soft1851.springboot.schedule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zeng
 * @ClassName InternalApiController
 * @Description 内部接口的 URL 路径以 /internal/ 作为前缀
 * @Date 2020/5/18
 * @Version 1.0
 **/

@Controller
public class InternalApiController {
    @GetMapping("/internal/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello internal");
    }
}