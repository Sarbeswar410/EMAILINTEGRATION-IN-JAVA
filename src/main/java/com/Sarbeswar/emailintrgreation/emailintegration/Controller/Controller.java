package com.Sarbeswar.emailintrgreation.emailintegration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sarbeswar.emailintrgreation.emailintegration.Service.SendOtpMailService;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private SendOtpMailService sendOtpMailService;

	@GetMapping(value = "/check")
	public String test() {
		return "Test Api Working";

	}
//Url for request this api is localhost://6969/api/sendMail, abd in params. key should be email and value is the sender mail id
	@PostMapping(value = "/sendMail")
	public String sendEmail(@RequestParam("email") String email) {
		sendOtpMailService.sendOpt(email);
		return "Otp sent Successfully";

	}

}
