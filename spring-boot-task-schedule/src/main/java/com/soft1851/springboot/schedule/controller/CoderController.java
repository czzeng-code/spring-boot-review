package com.soft1851.springboot.schedule.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import com.soft1851.springboot.schedule.model.Coder;
import com.soft1851.springboot.schedule.respository.CoderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ScheduledFuture;

/**
 * @author Zeng
 * @ClassName CoderController
 * @Description TOOD
 * @Date 2020/5/17
 * @Version 1.0
 **/
@RestController
public class CoderController {
    @Resource
    private CoderRepository coderRepository;

   
    @GetMapping("/code")
    public void getCode() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletResponse response = sra.getResponse();
        Coder coder = coderRepository.findById(RandomUtil.randomInt(1, 4)).get();
        String template = "F:/code/{}.jpg";
        String path = StrUtil.format(template, IdUtil.randomUUID());
        HttpUtil.downloadFile(coder.getAvatar(), FileUtil.file(path));
        BufferedImage image = QrCodeUtil.generate(coder.getUrl(), QrConfig.create().setImg(path).setBackColor(new Color(255, 255, 255)));
        assert response != null;
        response.setContentType("image/jpeg");
        response.setDateHeader("Expires", 0);
        try {
            //通过ImageIO将二维码图片通过response的字节输出流传回客户端
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
