package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.EmailBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Service in charge of handling the email data and sending it
 */
@Service
public class EmailService implements EmailPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender sender;

    /**
     * Method in charge of sending the message
     * @param emailBody
     * @return
     */
    @Override
    public boolean sendEmail(EmailBody emailBody)  {
        LOGGER.info("EmailBody: {}", emailBody.toString());
        return sendEmailTool(emailBody.getContent(),emailBody.getEmail(), emailBody.getSubject());
    }


    private boolean sendEmailTool(String textMessage, String email,String subject) {
        boolean send = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setText(textMessage, true);
            helper.setSubject(subject);
            sender.send(message);
            send = true;
            LOGGER.info("Mail enviado!");
        } catch (MessagingException e) {
            LOGGER.error("Hubo un error al enviar el mail", e);
        }
        return send;
    }
}
