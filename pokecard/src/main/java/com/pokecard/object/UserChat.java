package com.pokecard.object;

public class UserChat {

	private String login;
	private String chatId;
	
	public String getLogin() {
		return login;
	}
	
	public String getChatId() {
		return chatId;
	}

	public String toString() {
		return "'" + login + "'," + chatId ;
	}
}
