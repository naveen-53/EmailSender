package com.example.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.email.repo.EmailRepo;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private EmailRepo emailRepo;
	
	public void sendMail(String body, String subject) {
	}
	
	public void sendMail(String recipent, String body, String subject) {
		
		SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
		simpleMailMessage.setTo(recipent);
		simpleMailMessage.setText(body);
		simpleMailMessage.setSubject(subject);
		
		javaMailSender.send(simpleMailMessage);
	}
	
	public List<String> sendMailToEveryone() {
		return emailRepo.findAllEmail();
		
	}
	public  void sendMail(List<String> recipent, String body, String subject) {
		SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
		simpleMailMessage.setText(body);
		simpleMailMessage.setSubject(subject);
		for(String recipents : recipent) {
			simpleMailMessage.setTo(recipents);
			javaMailSender.send(simpleMailMessage);
		}
		
		
	}

}
