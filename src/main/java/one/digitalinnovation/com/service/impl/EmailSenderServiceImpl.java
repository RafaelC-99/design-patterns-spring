package one.digitalinnovation.com.service.impl;

import one.digitalinnovation.com.service.ClienteService;
import one.digitalinnovation.com.service.EmailSenderService;
import one.digitalinnovation.com.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Implementação do <b>Builder</b> {@link JavaMailSender}, a qual
 * pode ser injetada pelo Spring (via {@link  Autowired}). Com isso,
 * é possível construir inumeras mensagens diferentes.
 *
 * @author Rafael Alves Cardoso
 */

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    //Singleton: Injeta os componentes do spring com @Autowired.
    @Autowired
    private JavaMailSender mailSender;

    //Strategy: Implementa os métdos defindos na interface.

    //Builder: Cria uma instancia de objeto construtor
    // e assim com parametros informados pelo cliente,
    // monta-se um novo email
    @Override
    public void sendEmail(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getToEmail());
        message.setText(email.getMessage());
        message.setSubject(email.getSubject());

        mailSender.send(message);
    }
}
