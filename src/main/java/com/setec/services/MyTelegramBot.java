package com.setec.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.response.SendResponse;
import com.pengrad.telegrambot.request.SendMessage;

import lombok.Data;

@Service
@Data
public class MyTelegramBot {
	@Value("${token}")  // Changed from ${token}
	private String token;
	
	@Value("${chat-id}")  // Changed from ${chat_id}
	private long chat_id;

	private TelegramBot bot;

	public SendResponse sendMessage(String text){
		if(bot == null){
			bot = new TelegramBot(token);
		}
		SendResponse message = bot.execute(new SendMessage(chat_id, text));
		return message;
	}
}