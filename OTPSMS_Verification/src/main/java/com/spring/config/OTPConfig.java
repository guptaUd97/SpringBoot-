package com.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "twilio")
public class OTPConfig {
    
    private String accountSid;
    private String authToken;
    private String phoneNumber;
}
