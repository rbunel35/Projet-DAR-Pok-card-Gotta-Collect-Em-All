package com.pokecard.object;

import com.pokecard.utils.GenerateId;

public class Message {

	private String id;
	private String content;
	private String login;
	private String chatId;
	private int position;
	private static int add=0;
	

	public Message(String content, String login, String chatId) {
		this.id = GenerateId.getMessageId();
		this.content = content;
		this.login = login;
		this.chatId = chatId;
		this.position = Message.add++;
	}

	public Message(String id, String content, String login, String chatId) {
		this.id = id;
		this.content = content;
		this.login = login;
		this.chatId = chatId;
		
	}

	

	public Message(String id2, String content2, String login2, String chatId2, int position2) {
		this.id = id2;
		this.content = content2;
		this.login = login2;
		this.chatId = chatId2;
		this.position = position2;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getLogin() {
		return login;
	}

	public String getChatId() {
		return chatId;
	}

	public static int getAdd() {
		return add;
	}

	public String toString() {
		return "'" + id + "','" + content + "','" + login + "','" + chatId + "'," + position;
	}
	
	
}
