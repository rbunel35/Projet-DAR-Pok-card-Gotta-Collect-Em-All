package com.pokecard.object;

import com.pokecard.utils.GenerateId;

public class Chat {
	
	private String id;
	private String name;
	private String origin;
	private String destination;
	private boolean privy;
	
	
	
	public Chat(String name, String origin, String destination, boolean privy) {
		this.id = GenerateId.getChatId();
		this.name = name;
		this.origin = origin;
		this.destination = destination;
		this.privy = privy;
	}



	public Chat(String chatId, String name, String origin, String destination, boolean privy) {
		this.id = chatId;
		this.name = name;
		this.origin = origin;
		this.destination = destination;
		this.privy = privy;
	}
	
	



	public String getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getOrigin() {
		return origin;
	}



	public String getDestination() {
		return destination;
	}



	public boolean isPrivy() {
		return privy;
	}



	public String toString() {
		return "'"+ id + "','" + name + "','" + origin + "','" + destination +"',"  + privy ;
	}

}
