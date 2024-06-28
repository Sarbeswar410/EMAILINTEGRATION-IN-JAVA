package com.Sarbeswar.emailintrgreation.emailintegration.Service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class SendOtpMailService{
	@Autowired
	JavaMailSender javaMailSender;

	public void sendOpt(String email) {
		String otp=generateOtp();
		try {
			sendOtpToMail(email,otp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	private String generateOtp() {
		SecureRandom random=new SecureRandom();
		int otp=100000+random.nextInt(900000);
		return String.valueOf(otp);
	}
	private void sendOtpToMail(String email,String otp) throws Exception {
		MimeMessage mineMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimemessageHelper = new MimeMessageHelper(mineMessage);
		mimemessageHelper.setTo(email);
		mimemessageHelper.setSubject("OTP");
		mimemessageHelper.setText("Your Otp is:" + otp);
		javaMailSender.send(mineMessage);
		
	}


}
