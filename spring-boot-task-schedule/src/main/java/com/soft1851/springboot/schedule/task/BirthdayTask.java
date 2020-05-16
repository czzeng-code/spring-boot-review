package com.soft1851.springboot.schedule.task;

import com.soft1851.springboot.schedule.model.User;
import com.soft1851.springboot.schedule.respository.UserRepository;
import com.soft1851.springboot.schedule.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zeng
 * @ClassName BirthdayTask
 * @Description TOOD
 * @Date 2020/5/15
 * @Version 1.0
 **/
@Component
@Slf4j
public class BirthdayTask {
    @Resource
    private UserRepository userRepository;

    @Resource
    private TemplateEngine templateEngine;
    @Resource
    private MailService mailService;

    @Scheduled(cron = "0 0 8 * * ?")
    private void sendBlessing() throws Exception {


        List<User> userList = userRepository.findUsersByBirthday();

        for(User user : userList){
            String to = user.getEmail();
            String subject = "生日祝福";
            //生日模板
            Context context = new Context();
            context.setVariable("userName", user.getUsername());
            String content = templateEngine.process("Birthday", context);
            String imgPath ="F:\\Development\\spring-boot-review\\spring-boot-task-schedule\\2.jpg";
            Map<String,String> birthday = new HashMap<>();
            birthday.put("img01", imgPath);
            mailService.sendImgMail(to, subject, content, birthday);
            log.info("生日邮件发送成功!");
        }
    }
}
