package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.config.OTPConfig;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class OtpsmsVerificationApplication {
    
    @Autowired
    private OTPConfig otpConfig;
    
    @PostConstruct
    public void setup() {
        Twilio.init(otpConfig.getAccountSid(), otpConfig.getAuthToken());
    }

    public static void main(String[] args) {
        SpringApplication.run(OtpsmsVerificationApplication.class, args);
    }
}

