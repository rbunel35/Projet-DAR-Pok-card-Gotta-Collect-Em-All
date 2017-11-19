package com.pokecard.dao;

import java.util.List;

import com.pokecard.object.Basket;
import com.pokecard.object.Card;
import com.pokecard.utils.CardOwner;

public interface BasketDAO {
	
	public List<Basket> getBasketByUserId(String userid);
	
	public List<Basket> getBasketByCardName(String cardName);
	
	public void addCardToBasket(String extension, String number, String userId, String cardName, String image, double price, boolean search);
	
	public void deleteCardFromBasketById(String basketid);
	
	public List<Basket> getLastAddedCard();
	
	public Basket getBasketById(String id);
	
	
	
}