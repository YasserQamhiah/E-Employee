package com.example.EEmployee.appuser.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service

public class EmailService implements EmailSender{

    private final static Logger LOGGER= LoggerFactory.getLogger(EmailSender.class);


    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void sendEmail(String to, String email) {
        try {
            MimeMessage message=mailSender.createMimeMessage();
            MimeMessageHelper helper =new MimeMessageHelper(message,"utf-8");
            helper.setText(email,true);
            helper.setTo(to);
            helper.setSubject("Confirm Your Registration");
            helper.setFrom("admin@EEmloyee.com");
            mailSender.send(message);
        }catch (MessagingException e){
                LOGGER.error("Failed to send email", e);
                throw new IllegalStateException("failed to send email");
        }
    }
}
