package com.pokecard.daoImplementation;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pokecard.dao.UserDAO;
import com.pokecard.database.DatabaseTest;
import com.pokecard.object.Basket;
import com.pokecard.object.Card;
import com.pokecard.object.Meeting;
import com.pokecard.object.User;
import com.pokecard.test.Test;

public class UserImpl implements UserDAO {

	@Override
	public User getUser(String login) {
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, name, mail, pass, city, question, answer;
			// int n = stmt.executeUpdate("select * from card");
			ResultSet result = stmt.executeQuery("select * from member");
			while (result.next()) {
				if (login.equals(result.getString(2))) {
					id = result.getString(1);
					mail = result.getString(3);
					pass = result.getString(4);
					city = result.getString(5);
					question = result.getString(6);
					answer = result.getString(7);
					connection.close();
					return new User(id, login, mail, pass, city, question, answer);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String[] connection(String login, String pass) {
		//return DatabaseTest.connection(login, pass);
		Connection connection;

		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("select * from member");
			while (result.next()) {
				if (result.getString(2).equals(login)) {
					if(result.getString(4).equals(pass)){
						return new String[]{result.getString(1),result.getString(2)};
					}
					return new String[]{"password",""};
					
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return new String[]{"login",""};
		
		
	}

	@Override
	public String getSecretQuestion(String mail) {
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, name, pass, city, question, answer;
			// int n = stmt.executeUpdate("select * from card");
			ResultSet result = stmt.executeQuery("select * from member");
			while (result.next()) {
				if (mail.equals(result.getString(3))) {
					question = result.getString(6);
					connection.close();
					return question;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String testAnswer(String mail, String answer) {
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, name, pass, city, question;
			// int n = stmt.executeUpdate("select * from card");
			ResultSet result = stmt.executeQuery("select * from member");
			while (result.next()) {
				if (mail.equals(result.getString(3)) && answer.equals(result.getString(7))) {
					connection.close();
					return "je sais pas ce que tu veux retourner Momo";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * @Override public List<Basket> getBasket(String login) { List<Basket> l =
	 * new ArrayList<>(); try {
	 * 
	 * 
	 * Connection connection = Test.getConnection(); Statement stmt =
	 * connection.createStatement(); String
	 * id,extension,userid,image,comment,number; boolean search; long addDate;
	 * ResultSet result = stmt.executeQuery("select * from Basket"); while
	 * (result.next()) { id = result.getString(1); extension =
	 * result.getString(2); number = result.getString(3); userid =
	 * result.getString(4); search = result.getBoolean(5); comment =
	 * result.getString(6); image = result.getString(7);
	 * if(login.equals(userid)) { l.add(new Basket(id, extension, number,
	 * userid, search,comment,image)); } }
	 * 
	 * 
	 * connection.close(); }catch (Exception e) { e.printStackTrace(); } return
	 * l; }
	 * 
	 * @Override public int insertCard(String login, String extention, String
	 * number, boolean b) { // TODO Auto-generated method stub int n = -1; Card
	 * c =(new CardImpl()).getCard(extention, number); Connection connection;
	 * 
	 * Basket bask = new
	 * Basket(extention,c.getNumber(),login,b,c.getComment(),c.getImage()); try
	 * { connection = Test.getConnection(); Statement stmt =
	 * connection.createStatement(); n = stmt.
	 * executeUpdate("insert into Basket(id,extension,number,idmember,search,comment,image)values ("
	 * + bask.toString() + ")");
	 * 
	 * connection.close(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * return n; }
	 */
	@Override
	public String register(User u) {
		int n = -1;
		Connection connection;
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			n = stmt.executeUpdate(
					"insert into member(id , name,mail, pass, city ,question, answer)values (" + u.toString() + ")");

			connection.close();
			return "ok";
		} catch (Exception e) {

			try {
				connection = Test.getConnection();
				Statement stmt = connection.createStatement();
				String id, name, pass, city, question, answer;
				// int n = stmt.executeUpdate("select * from card");
				ResultSet result = stmt.executeQuery("select * from member");
				while (result.next()) {
					if (u.getMail().equals(result.getString(3))) {
						connection.close();
						return "mail";
					}
					if (u.getName().equals(result.getString(2))) {
						connection.close();
						return "login";
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String getUserLoginById(String id) {
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			
			// int n = stmt.executeUpdate("select * from card");
			ResultSet result = stmt.executeQuery("select * from member");
			while (result.next()) {
				if (id.equals(result.getString(1))) {
					return result.getString(2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
