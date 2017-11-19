package com.pokecard.utils;



import java.util.Date;

import com.pokecard.object.Card;
import com.pokecard.object.User;

public class CardOwner {
	
	private String userName;
	private String cardName;
	private String image;
	private Date addDate;
	private String comment;
	private int price;
	
	public CardOwner(String userName, String cardName, String image, Date addDate, String comment, int price) {
		super();
		this.userName = userName;
		this.cardName = cardName;
		this.image = image;
		this.addDate = addDate;
		this.comment = comment;
		this.price = price;
	}

	public String getUserName() {
		return userName;
	}

	public String getCardName() {
		return cardName;
	}

	public String getImage() {
		return image;
	}

	public Date getAddDate() {
		return addDate;
	}

	public String getComment() {
		return comment;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return userName+","+cardName+","+image+","+addDate+","+comment+","+price;
	}
	
	
	
	
	
	

}
