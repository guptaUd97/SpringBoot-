//package com.spring.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.spring.service.OTPService;
//
//@RestController
//public class SMSController {
//	
//	@Autowired
//	private OTPService otpService;
//	
//	//send otp
//	@PostMapping("/sendOtp")
//	public String sendOtp(@RequestParam String mobileNumber) {
//		return otpService.sendOtpToPhone(mobileNumber);
//	}
//	
//	//validate otp
//	@PostMapping("/varifyOtp")
//	public String verifyOtp(@RequestParam String otp) {
//		return otpService.validatedOTP(otp);
//	}
//
//}

package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.OTPService;

@RestController
public class SMSController {
    
    @Autowired
    private OTPService otpService;
    
    // Send OTP
    @PostMapping("/sendOtp")
    public String sendOtp(@RequestParam String mobileNumber) {
        return otpService.sendOtpToPhone(mobileNumber);
    }
    
    // Validate OTP
    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam String mobileNumber, @RequestParam String otp) {
        return otpService.validateOTP(mobileNumber,otp);
    }
    
}
