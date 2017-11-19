package com.pokecard.object;

import com.pokecard.utils.GenerateId;

public class Basket {

	private String id;
	private String extension;
	private String number;
	private String userId;
	private String cardName;
	private String image;
	private double price;
	private boolean search;
	
	
	public Basket(String extension, String number, String userId, String cardName, String image, double price, boolean search) {
		this.id = GenerateId.basketId();
		this.extension = extension;
		this.number = number;
		this.userId = userId;
		this.cardName = cardName;
		this.image = image;
		this.price = price;
		this.search = search;
	}


	public Basket(String id, String extension, String number, String userId, String cardName, String image,double price,
			boolean search) {
		this.id = id;
		this.extension = extension;
		this.number = number;
		this.userId = userId;
		this.cardName = cardName;
		this.image = image;
		this.price = price;
		this.search = search;
	}
	

	public String getId() {
		return id;
	}


	public String getExtension() {
		return extension;
	}


	public String getNumber() {
		return number;
	}


	public String getUserId() {
		return userId;
	}


	public String getCardName() {
		return cardName;
	}


	public String getImage() {
		return image;
	}
	
	public double getPrice(){
		return price;
	}


	public boolean isSearch() {
		return search;
	}


	public String toString(){
		return "'" + id + "','" + extension + "'," + number + ",'" + userId + "','" + cardName+"','" + image +"'," + price + "," + search;
	}

}
