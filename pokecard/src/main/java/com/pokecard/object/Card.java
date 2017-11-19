package com.pokecard.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pokecard.utils.GenerateId;

public class Card {
	
	private String extension;
	private String number;
	private String cardName;
	private String image;
	private double price;
	
	public Card(String extension, String number, String cardName, String image, double price) {
		this.extension = extension;
		this.number = number;
		this.cardName = cardName;
		this.image = image;
		this.price = price;
	}
	public String getExtension() {
		return extension;
	}
	public String getNumber() {
		return number;
	}
	public String getCardName() {
		return cardName;
	}
	public String getImage() {
		return image;
	}
	public double getPrice() {
		return price;
	}
	
	
	
}
