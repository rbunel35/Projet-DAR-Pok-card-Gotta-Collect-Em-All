package com.pokecard.webservice;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pokecard.dao.DAO;
import com.pokecard.database.DatabaseTest;
import com.pokecard.object.Basket;
import com.pokecard.object.Chat;
import com.pokecard.object.Message;
import com.pokecard.object.User;


@Path("/chat")
public class ChatWebservice {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/chatList/{userlogin}")
	public List<Chat> chatByLogin(@PathParam("userlogin") String userId)
	{
		return DAO.getChatDAO().getChatByUserLogin(userId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/{name}/{origin}/{userid}")
	public void createChat(@PathParam("name") String name,@PathParam("origin") String origin, @PathParam("userid") String userid)
	{
		//new Chat(name, origin, destination, privy)
		DAO.getChatDAO().createChat(name, origin, userid);
		//return new Chat(name, origin, userid, true);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/messages/{chatid}")
	public List<Message> getMessagesByChatId(@PathParam("chatid") String chatId)
	{
		System.out.println(DAO.getChatDAO().getMessagesByChatId(chatId));
		return DAO.getChatDAO().getMessagesByChatId(chatId);
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertMessage/{content}/{login}/{chatid}")
	public void insertMessage(@PathParam("content") String content,@PathParam("login") String login,@PathParam("chatid") String chatId){
		
		DAO.getChatDAO().insertMessage(new Message(content, login, chatId));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/newMessage/{login}")
	public boolean[] newMessage(@PathParam("login") String login){
		DatabaseTest.chats.add(new Chat("name", "origin", "destination", true));
		return new boolean[]{true};
	}
	
}
