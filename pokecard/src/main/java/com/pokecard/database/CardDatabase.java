package com.pokecard.database;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pokecard.object.Card;
import com.pokecard.object.User;
import com.pokecard.test.Test;
import com.pokecard.utils.CardOwner;

public class CardDatabase {

	/*public static void main(String[] args) {
		Card c = new Card("extention", "2", "userName", "cardName", "image", 564466, "comment", 10);
		System.out.println(c.toString());

	}
	final static User u = new User("name", "mail", "pass", "city", "question", "answer");
	public static int insert(Card card)  {
		// new Card(extension, number, userName, cardName, image, addDate,
		// comment, price)
		int n = -1;
		Connection connection;
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			n = stmt.executeUpdate("insert into card(id,extension,number,memberName,cardname,image,addDate,comment,exemplary,price)values (" + card.toString() + ")");
			
			connection.close();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return n;

		/*
		 * INSERT INTO client (prenom, nom, ville, age) VALUES ('Rébecca',
		 * 'Armand', 'Saint-Didier-des-Bois', 24),
		 
	}
	
	public static void test(){
		User u = new User("name", "mail", "pass", "city", "question", "answer");
		Card c;
		List<Card> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			c = new Card("extention", "2", "userName", "cardName", "image", 564466, "comment", 10);
			insert(c);
			//insert(new Card("extention", 2, "userName", "cardName", "image", 564466, "comment", 10));
		}
		/*
		 * create table member (id VARCHAR(50) PRIMARY KEY , name VARCHAR(50),mail VARCHAR(50), pass VARCHAR(50), city VARCHAR(50) ,question TEXT, answer TEXT);
CREATE TABLE Card(id VARCHAR(20) PRIMARY KEY,extension VARCHAR(50),number INTEGER ,memberName VARCHAR(50) references member(id) ,cardname VARCHAR(50) , image VARCHAR(50) ,addDate bigint,com VARCHAR(50),exemplary integer,price INTEGER );
insert into member(id,name,mail,pass,city,question,answer) values ('test','dick','dickpass','dick@pokecard.com','dickcity','whoisdick','its me'); 
insert into card(id,extension,number,memberName,cardname,image,addDate,com,exemplary,price)values ('crddPdOi2E7EutY4xya','extention',2,'test','cardName','image',564466,'comment',3,1);
		 
	}
	
	public static Card getCard(String id) {
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String extension,userid,cardName,image,comment,number;
			int price;
			long addDate;
			//int n = stmt.executeUpdate("select * from card");
			ResultSet result = stmt.executeQuery("select * from card");
			while (result.next()) {
				if(id.equals(result.getString(1))) {
					extension = result.getString(2);
					number = result.getString(3);
					userid = result.getString(4);
					cardName = result.getString(5);
					image = result.getString(6);
					addDate = result.getLong(7);
					comment = result.getString(8);
					price = result.getInt(9);
					connection.close();
					return new Card(id, extension, number, userid, cardName, image, addDate, comment, price);
				}	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
		
	}
	
	static boolean b = true;
	// new Card(extension, number, userName, cardName, image, addDate, comment, price
	public static List<Card> getCards() { 
		
		List<Card> l = new ArrayList<>();
		try {
			
		
		Connection connection = Test.getConnection();
		Statement stmt = connection.createStatement();
		String id,extension,userid,cardName,image,comment,number;
		int price;
		long addDate;
		//int n = stmt.executeUpdate("select * from card");
		ResultSet result = stmt.executeQuery("select * from card");
		while (result.next()) {
			id = result.getString(1);
			extension = result.getString(2);
			number = result.getString(3);
			userid = result.getString(4);
			cardName = result.getString(5);
			image = result.getString(6);
			addDate = result.getLong(7);
			comment = result.getString(8);
			price = result.getInt(9);
			l.add(new Card(id, extension, number, userid, cardName, image, addDate, comment, price));
		}
		

		connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public static List<CardOwner> getCardsByExtentionNameCity(String extention, String name, String city) {
		List<CardOwner> l = new ArrayList<>();
		try {
			
		
		Connection connection = Test.getConnection();
		Statement stmt = connection.createStatement();
		String userName,cardName,image,comment;
		int number,price;
		long addDate;
		//int n = stmt.executeUpdate("select * from card");
		ResultSet result = stmt.executeQuery("select * from card");
		while (result.next()) {
			number = result.getInt(3);
			cardName = result.getString(5);
			image = result.getString(6);
			addDate = result.getLong(7);
			comment = result.getString(8);
			price = result.getInt(9);
			//l.add(new CardOwner(userName, cardName, image, addDate, comment, price));
		}
		

		connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return l;
		
	}
	*/
}
