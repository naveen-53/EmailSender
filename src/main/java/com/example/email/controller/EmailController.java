package com.example.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.email.service.EmailService;

@Controller
public class EmailController {

	@Autowired
	public EmailService emailService;
	
	@GetMapping("/sendMail")
	public ResponseEntity<String> sendMail() {
		emailService.sendMail("naveendx532@gmail.com","Welcome Naveen","subject");
		return ResponseEntity.ok("Mail Send Successfully");
	}
	
	@GetMapping("/sendMailEveryone")
	public ResponseEntity<String> sendMailEveryone() {
		List<String> list = emailService.sendMailToEveryone();
		/*
		 * for(String l : list) { System.out.println(l); }
		 */
		emailService.sendMail(list,"Welcome to Bluescope Guys","Greetings");
		return ResponseEntity.ok("Mail Send Successfully");
	}
}
