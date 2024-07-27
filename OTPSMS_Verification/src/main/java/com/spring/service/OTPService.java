//package com.spring.service;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.spring.config.OTPConfig;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.rest.api.v2010.account.MessageCreator;
//import com.twilio.type.PhoneNumber;
//
//
//
//@Service
//public class OTPService {
//	
//	@Autowired
//	private OTPConfig otpConfig;
//	
//	Map<String, String> otpMap=new HashMap<>();
//	
//	//genrated otp 
//	public String genratedOTP() {
//		int otp = (int)(Math.random()*1000000);
//		return String.format("%6d",otp );
//		
//	}
//	
//	//send otp
//	public String sendOtpToPhone(String mobileNumber) {
//		String otp = genratedOTP();
//		PhoneNumber reciepientPhonmeNumber = new PhoneNumber(mobileNumber);
//		PhoneNumber senderPhonmeNumber = new PhoneNumber(otpConfig.getPhoneNumber());
//		String msgBody = "your one time password( otp ) is : "+otp;
//		MessageCreator message = Message.creator(reciepientPhonmeNumber, senderPhonmeNumber, msgBody);
//		otpMap.put(msgBody, otp);
//		return "otp send succesfully";
//	}
//	
//	//validated otp
//	public String validatedOTP(String otp) {
//		Set<String> keys= otpMap.keySet();
//		String value = null;
//		for(String key : keys) 
//			value=otpMap.get(key);
//			if(value.equals(otp))
//				return "otp validated succesfully";
//			else
//				return "Invalid otp";
//		
//	}
//}

package com.spring.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.config.OTPConfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class OTPService {
    
    @Autowired
    private OTPConfig otpConfig;
    
    Map<String, String> map = new HashMap<>();
    
    // Generate OTP 
    public String generateOTP() {
        int otp = (int) (Math.random() * 1000000);
        return String.format("%06d", otp);
    }
    
    // Send OTP
    public String sendOtpToPhone(String mobileNumber) {
        String otp = generateOTP();
        PhoneNumber recipientPhoneNumber = new PhoneNumber(mobileNumber);
        PhoneNumber senderPhoneNumber = new PhoneNumber(otpConfig.getPhoneNumber());
        String msgBody = "Your one time password (OTP) is: " + otp;
        MessageCreator message = Message.creator(recipientPhoneNumber, senderPhoneNumber, msgBody);
        message.create();
        map.put(mobileNumber, otp);
        return "OTP sent successfully";
    }
    
    // Validate OTP
    public String validateOTP(String mobileNumber, String otp) {
        if (map.containsKey(mobileNumber)) {
            String storedOtp = map.get(mobileNumber);
            if (storedOtp.equals(otp)) {
                map.remove(mobileNumber); // Optional: remove OTP after successful validation
                return "OTP validated successfully";
            } else {
                return "Invalid OTP";
            }
        } else {
            return "No OTP found for the given mobile number";
        }
    }
}

