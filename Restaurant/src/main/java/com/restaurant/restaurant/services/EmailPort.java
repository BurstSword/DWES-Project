package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.EmailBody;

public interface EmailPort {
    public boolean sendEmail(EmailBody emailBody);
}