package com.pokecard.dao;

import com.pokecard.daoImplementation.BasketImpl;
import com.pokecard.daoImplementation.CardImpl;
import com.pokecard.daoImplementation.ChatImpl;
import com.pokecard.daoImplementation.MeetingImpl;
import com.pokecard.daoImplementation.UserImpl;

public class DAO {
	private static UserDAO userDAO = null;
	private static CardDAO cardDAO = null;
	private static BasketDAO basketDAO = null;
	private static ChatDAO chatDAO = null;
	private static MeetingDAO meetingDAO = null;
	
	public static UserDAO getUserDAO(){
		if(userDAO == null){
			userDAO = new UserImpl();
		}
		return userDAO;
	}
	
	public static CardDAO getCardDAO(){
		if(cardDAO == null)
			cardDAO = new CardImpl();
		return cardDAO;
	}
	
	public static BasketDAO getBasketDAO(){
		if(basketDAO == null)
			basketDAO = new BasketImpl();
		return basketDAO;
	}
	
	public static ChatDAO getChatDAO(){
		if(chatDAO == null){
			chatDAO = new ChatImpl();
		}
		return chatDAO;
	}
	
	public static MeetingDAO getMeetingDAO(){
		if(meetingDAO == null){
			meetingDAO = new MeetingImpl();
		}
		return meetingDAO;
	}
	
	
}
