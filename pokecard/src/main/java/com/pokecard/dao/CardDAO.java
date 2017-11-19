package com.pokecard.dao;

import java.util.List;

import com.pokecard.object.Card;
import com.pokecard.utils.CardOwner;

public interface CardDAO {
	
	public List<Card> searchCardsByName(String name);
	
	public List<Card> searchCardsByExtensionAndName(String extension, String name);
	
	public Card searchCardsByExtentionAndNumber(String extension, String number);
	
	
}