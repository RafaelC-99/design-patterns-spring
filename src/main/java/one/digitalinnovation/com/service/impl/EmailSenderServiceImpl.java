package one.digitalinnovation.com.service.impl;

import one.digitalinnovation.com.service.EmailSenderService;
import one.digitalinnovation.com.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getToEmail());
        message.setText(email.getMessage());
        message.setSubject(email.getSubject());

        mailSender.send(message);
    }
}
