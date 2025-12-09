package com.setec.controller;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.setec.entities.Booked;
import com.setec.repos.BookRepo;
import com.setec.services.MyTelegramBot;

@Controller
public class MyController {
	//http://localhost:8080/
	@GetMapping({"/","/home"})
	public String home(Model mod) {
		Booked booked = new Booked(
				1, "Oeng Kimcheng",
				"081230012",
				"cheng@gmail.com",
				"11/12/2025",
				"5:17 PM",
				5
				);
				mod.addAttribute("booked", booked);
		return "index";
	}
	@GetMapping({"/about"})
	public String about() {
		return "about";
	}
	@GetMapping({"/service"})
	public String service() {
		return "service";
	}
	@GetMapping({"/menu"})
	public String menu() {
		return "menu";
	}
	@GetMapping({"/reservation"})
	public String reservation(Model mod) {
		Booked booked = new Booked(
		1, "Oeng Kimcheng",
		"081230012",
		"cheng@gmail.com",
		"11/12/2025",
		"5:17 PM",
		5
		);
		mod.addAttribute("booked", booked);
		return "reservation";
	}
	@GetMapping({"/testimonial"})
	public String testimonial() {
		return "testimonial";
	}
	@GetMapping({"/contact"})
	public String contact() {
		return "contact";
	}
	@Autowired
	private BookRepo bookedRepo;
	
	@Autowired
	private MyTelegramBot bot;
	
	@PostMapping({"/success"})
	public String success(@ModelAttribute Booked booked) {
		bookedRepo.save(booked);
//		System.err.println(bot);
//		bot.sendMessage(booked.toString());
		String message = "📅 Booking Confirmed!\n\n" +
                "🆔 ID: " + booked.getId() + "\n" +
                "👤 Name: " + booked.getName() + "\n" +
                "📱 Phone: " + booked.getPhoneNumber() + "\n" +
                "📧 Email: " + booked.getEmail() + "\n" +
                "📆 Date: " + booked.getDate() + "\n" +
                "⏰ Time: " + booked.getTime() + "\n" +
                "👥 People: " + booked.getPerson();
		bot.sendMessage(message);
		
		return "Success";
	}
}
