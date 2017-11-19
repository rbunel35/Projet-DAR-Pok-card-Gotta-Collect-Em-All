package com.pokecard.object;

import com.pokecard.utils.GenerateId;

public class User {

	public String toString() {
		return "'" + id + "','" + name + "','" + mail + "','" + pass + "','" + city + "','" + question + "','" + answer
				+ "'";
	}

	public User(String id, String name, String mail, String pass, String city, String question, String answer) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.pass = pass;
		this.city = city;
		this.question = question;
		this.answer = answer;
	}

	private String id;
	private String name;
	private String mail;
	private String pass;
	private String city;

	private String question;
	private String answer;

	public User(String name, String mail, String pass, String city, String question, String answer) {
		super();
		this.id = GenerateId.userId();
		this.name = name;
		this.mail = mail;
		this.pass = pass;
		this.city = city;
		this.question = question;
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
