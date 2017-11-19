package com.pokecard.dao;

import java.util.List;

import com.pokecard.object.Chat;
import com.pokecard.object.Message;

public interface ChatDAO {
	
	public List<Chat> getChatByUserLogin(String login);
	
	public List<Message> getMessagesByChatId(String chatId);
	
	public void insertMessage(Message m);
	
	public void createChat(String name, String origin, String destinationId);

}
