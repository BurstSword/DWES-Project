package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.EmailBody;

/**
 * Service interface for sending confirmation email
 */
public interface EmailPort {
    public boolean sendEmail(EmailBody emailBody);
}