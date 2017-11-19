package com.pokecard.dao;

import java.util.List;

import com.pokecard.object.Basket;
import com.pokecard.object.User;

public interface UserDAO {
	
	public User getUser(String login);
	
	public String[] connection (String login,String pass);
	
	public String register(User u); 
	
	public String getSecretQuestion(String mail);
	
	public String testAnswer(String mail,String answer);
	
	public String getUserLoginById(String id);
	//public List<Basket> getBasket(String login);
	
	//public int insertCard(String login,String extention,String number, boolean b);
	
	
	
}
