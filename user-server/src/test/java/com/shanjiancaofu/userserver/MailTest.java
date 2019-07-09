package com.shanjiancaofu.userserver;

import com.shanjiancaofu.userserver.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MailTest {
    @Autowired
    MailService mailService;


    @Test
    public void sendMailTest() {
        mailService.sendMail("hello world", "s32967326@163.com");
    }
}
