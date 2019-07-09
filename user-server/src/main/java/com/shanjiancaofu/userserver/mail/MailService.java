package com.shanjiancaofu.userserver.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Slf4j
public class MailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public boolean sendMail(String conteng, String Recipient) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("开会");
            simpleMailMessage.setText(conteng);
            simpleMailMessage.setTo(Recipient);
            javaMailSender.send(simpleMailMessage);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // 发送复杂邮件
    public void sendComplexMail(String conteng, String recipient) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setSubject("开会");
        mimeMessageHelper.setText("<b style='color:red;'> 别忘了要开会哟 </b>");
        mimeMessageHelper.setTo(recipient);
        mimeMessageHelper.addAttachment("附件1", new File("/home/jeesk/123.txt"));
        javaMailSender.send(mimeMessage);
    }
}
