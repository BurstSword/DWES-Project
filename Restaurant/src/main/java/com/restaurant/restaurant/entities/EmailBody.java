package com.restaurant.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class to storage the information about the email
 */
@Data
@NoArgsConstructor @AllArgsConstructor
public class EmailBody {
    private String email;
    private String content;
    private String subject;
}
