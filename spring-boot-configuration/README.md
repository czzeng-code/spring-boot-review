# spring-boot-configuration模块
## 1.SpringBoot启动banner配置

 > resources目录下的banner.txt 是自定义的SpringBoot应用启动图标文件

[在线ASCII艺术字生成网站](https://tools.kalvinbg.cn/txt/ascii)
 
## 2.application.properties
> 属性定义时候出现波浪线："Cannot resolve configuration property"
> 可以使用SpringBoot 的 configuration processor 模块来解决问题
```$xslt
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```
然后在配置类上添加 @ConfigurationProperties 注解即可

## 3.Tomcat的相关配置


## 4.HTTPS的配置
[参考这篇](https://www.cnblogs.com/chenpi/p/9696371.html)
- SSL：SSL(Secure Sockets Layer 安全套接层)，用以保障在Internet上数据传输之安全，利用数据加密(Encryption)技术，可确保数据在网络上之传输过程中不会被截取及窃听。

- TLS：安全传输层协议（TLS）用于在两个通信应用程序之间提供保密性和数据完整性。该协议由两层组成： TLS 记录协议（TLS Record）和 TLS 握手协议（TLS Handshake）。

- HTTPS：是以安全为目标的HTTP通道，简单讲是HTTP的安全版。即HTTP下加入SSL层，HTTPS的安全基础是SSL，因此加密的详细内容就需要SSL。
truststore
Truststore and Keystore：主要用于Java中存储证书，它们之间的区别是truststore用于存储public证书，而keystore用于存储private证书

## 5.在配置文件中自定义配置属性
- 定义
- 读取



