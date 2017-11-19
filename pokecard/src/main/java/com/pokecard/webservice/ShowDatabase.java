package com.pokecard.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import com.pokecard.database.DatabaseTest;
import com.pokecard.object.Basket;
import com.pokecard.object.Chat;
import com.pokecard.object.User;
import com.pokecard.test.Test;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/show")
public class ShowDatabase {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users")
	public List<User> showUsers()
	{
		List<User> l = new ArrayList<User>();
		int n = -1;
		Connection connection;
		
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id,name,mail,pass,city,question,answer;
			//int n = stmt.executeUpdate("select * from card");
			ResultSet result = stmt.executeQuery("select * from member");
			while (result.next()) {
				name = result.getString(2);
				id = result.getString(1);
				mail = result.getString(3);
				pass = result.getString(4);
				city = result.getString(5);
				question = result.getString(6);
				answer = result.getString(7);
				l.add(new User(id, name, mail, pass, city, question, answer));
			}
		}catch (Exception e2) {
			e2.printStackTrace();
		}	
		return l;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/chats")
	public List<Chat> showChats()
	{
		//return DatabaseTest.chats;
		List<Chat> l = new ArrayList<Chat>();
		int n = -1;
		Connection connection;
		
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id,name,origin,destination;
			boolean privy;
			//int n = stmt.executeUpdate("select * from card");
			ResultSet result = stmt.executeQuery("select * from chat");
			while (result.next()) {
				id = result.getString(1);
				name = result.getString(2);
				origin = result.getString(3);
				destination = result.getString(4);
				privy = result.getBoolean(5);
				l.add(new Chat(id, name, origin, destination, privy));
			}
		}catch (Exception e2) {
			e2.printStackTrace();
		}	
		return l;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/baskets")
	public List<Basket> showbasket()
	{
		List<Basket> l = new ArrayList<Basket>();
		int n = -1;
		Connection connection;
		
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id,extension,number,userId,cardName,image;
			int price;
			boolean search;
			//int n = stmt.executeUpdate("select * from card");
			ResultSet result = stmt.executeQuery("select * from basket");
			while (result.next()) {
				id = result.getString(1);
				extension = result.getString(2);
				number = result.getString(3);
				userId = result.getString(4);
				cardName = result.getString(5);
				image = "";//result.getString(6);
				price = result.getInt(7);
				search= result.getBoolean(8);
				
				l.add(new Basket(id, extension, number, userId, cardName, image, price, search));
			}
		}catch (Exception e2) {
			e2.printStackTrace();
		}	
		return l;
	}
}
