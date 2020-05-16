package com.soft1851.springboot.schedule.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleTextMail() {
        String to = "18851697603@139.com";
        String subject = "Springboot 发送简单文本邮件";
        String content = "<h3>第一封 Spring boot 简单文本邮件</h3>";
        mailService.sendSimpleTextMail(to,subject, content);
    }

    @Test
    void sendHtmlMail() throws MessagingException {
        String to = "18851697603@139.com";
        String subject = "Springboot 发送简单文本邮件";
        String content = "<h3>第一封 Spring boot 简单文本邮件</h3>";
        mailService.sendHtmlMail(to,subject, content);
    }

    @Test
    void sendAttMail() throws MessagingException {
        String to = "18851697603@139.com";
        String subject = "Springboot 发送附件邮件";
        String content = "<h3>第一封 Spring boot 附件邮件</h3>";
        String filePath = "pom.xml";
        mailService.sendAttachmentMail(to,subject, content,filePath, filePath);
    }

    @Test
    void sendImgMail() throws Exception {
        String to = "18851697603@139.com";
        String subject = "Springboot 发送img邮件";
        String content = "<h3>第一封 Spring boot 图片邮件</h3><br/>" +
                "<img src=\"cid:img01\" />";
        String imgPath = "1.jpg";
        Map<String, String> imgMap = new HashMap<>();
        imgMap.put("img01", imgPath);
        mailService.sendImgMail(to,subject, content, imgMap);


    }
}