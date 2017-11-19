package com.pokecard.object;

import java.sql.Date;

import com.pokecard.utils.GenerateId;

public class Meeting {

	private String id;
	private String adress;
	private String login;
	private String name;
	private long date;
	
	
	
	
	public Meeting(String adress, String login, String name, long date) {
		this.id = GenerateId.getMeetingId();
		this.adress = adress;
		this.login = login;
		this.name = name;
		this.date = date;
	}


	public Meeting(String id, String adress, String login, String name, long date) {
		this.id = id;
		this.adress = adress;
		this.login = login;
		this.name = name;
		this.date = date;
	}



	public String getId() {
		return id;
	}



	public String getAdress() {
		return adress;
	}



	public String getLogin() {
		return login;
	}



	public String getName() {
		return name;
	}



	public long getDate() {
		return date;
	}


	public String toString() {
		return "'" + id + "','" + adress + "','"  + login + "','" + name + "'," + date;

	}

}
