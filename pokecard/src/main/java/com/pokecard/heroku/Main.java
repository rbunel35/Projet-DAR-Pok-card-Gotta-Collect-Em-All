package com.pokecard.heroku;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import com.pokecard.dao.DAO;
import com.pokecard.database.CardDatabase;
import com.pokecard.database.DatabaseTest;
import com.pokecard.object.Basket;
import com.pokecard.object.Chat;
import com.pokecard.object.Meeting;
import com.pokecard.object.Message;
import com.pokecard.test.Test;

/**
 * This class launches the web application in an embedded Jetty container. This
 * is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 */
public class Main {

	static void creationTable() throws URISyntaxException, SQLException {
		Connection connection = Test.getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DROP TABLE IF EXISTS memberChat");
		stmt.executeUpdate("DROP TABLE IF EXISTS memberCard");
		stmt.executeUpdate("DROP TABLE IF EXISTS Message");
		stmt.executeUpdate("DROP TABLE IF EXISTS Meeting");
		stmt.executeUpdate("DROP TABLE IF EXISTS Chat");
		stmt.executeUpdate("DROP TABLE IF EXISTS Card");
		stmt.executeUpdate("DROP TABLE IF EXISTS Basket");
		stmt.executeUpdate("DROP TABLE IF EXISTS member");
		stmt.executeUpdate("create table member (id VARCHAR(50) PRIMARY KEY , name VARCHAR(50) UNIQUE,mail VARCHAR(50) UNIQUE, pass VARCHAR(50), city VARCHAR(50) ,question TEXT, answer TEXT)");
		stmt.executeUpdate(
				"CREATE TABLE Basket (id VARCHAR(20) PRIMARY KEY,extension VARCHAR(50),number VARCHAR(50),idmember VARCHAR(50) references  member(id),cardName VARCHAR(50),image TEXT,price FLOAT,search BOOLEAN)");
		/*stmt.executeUpdate(
				" CREATE TABLE Card(id VARCHAR(20) PRIMARY KEY,extension VARCHAR(50),number VARCHAR(50) ,memberName VARCHAR(50)  , image VARCHAR(50) ,addDate bigint,comment VARCHAR(50),exemplary integer,price INTEGER ) ");
		*/
		stmt.executeUpdate("CREATE TABLE Chat(chatId VARCHAR(50) PRIMARY KEY ,  name VARCHAR(50),origin VARCHAR(50) references  member(name),destination VARCHAR(50) references  member(name),privy BOOLEAN)");
		stmt.executeUpdate(
				"create table Meeting (meetingID VARCHAR(50) PRIMARY KEY , adress VARCHAR(50), addDate bigint , login1 VARCHAR(50),login2 VARCHAR(50) )");
		stmt.executeUpdate("create table Message (id VARCHAR(50) PRIMARY KEY,content TEXT, login VARCHAR(50) references  member(name),chatId VARCHAR(50) references  Chat(chatId),position INTEGER)");
		stmt.executeUpdate("create table memberCard (login varchar(50), extension varchar(50) , number INTEGER)");
		stmt.executeUpdate("create table memberChat(chatId INTEGER,login VARCHAR(50))");
		connection.close();
		// ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
	}
	
	

	public static void main(String[] args) throws Exception {
		// The port that we should run on can be set into an environment
		// variable
		// Look for that variable and default to 8080 if it isn't there.
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8082";
		}

		final Server server = new Server(Integer.valueOf(webPort));
		final WebAppContext root = new WebAppContext();

		root.setContextPath("/");
		root.setParentLoaderPriority(true);

		final String webappDirLocation = "src/main/webapp/";
		root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
		root.setResourceBase(webappDirLocation);

		server.setHandler(root);
		
		Date d = new Date(2017, 05, 2);
		
		DatabaseTest.meetings.add(new Meeting("adress", "mohamed", "pikachu", d.getTime()));
		DatabaseTest.meetings.add(new Meeting("adress", "mohamed", "pikachu", d.getTime()));
		DatabaseTest.meetings.add(new Meeting("adress", "mohamed", "pikachu", d.getTime()));
		//creationTable();
		
		//DAO.getUserDAO().register(DatabaseTest.mohamed);
		//DAO.getUserDAO().register(DatabaseTest.karim);
		/*Chat c = new Chat("pikachu", "karim", "mohamed", true);
		DatabaseTest.messages.add(new Message("hello world", "mohamed", c.getId()));
		DatabaseTest.chats.add(c);
		*/
		//DAO.getUserDAO().register(DatabaseTest.karim);
		//Basket b = new Basket("Next Destinies", "54", DatabaseTest.mohamed.getId(), "Mewtwo", "http://lh4.googleusercontent.com/-Tn4Wc-AiV_s/UxPKA7nhctI/AAAAAAAA7mQ/6OVYiaN-5AU/s0/98.png", 20, true);
		//Basket b2 = new Basket("Next Destinies", "54", DatabaseTest.karim.getId(), "Mewtwo", "http://lh4.googleusercontent.com/-Tn4Wc-AiV_s/UxPKA7nhctI/AAAAAAAA7mQ/6OVYiaN-5AU/s0/98.png", 20, true);

		//DAO.getBasketDAO().addCardToBasket(b.getExtension(), b.getNumber(), b.getUserId(), b.getCardName(), b.getImage(), b.getPrice(), b.isSearch());
		//DAO.getBasketDAO().addCardToBasket(b2.getExtension(), b2.getNumber(), b2.getUserId(), b2.getCardName(), b2.getImage(), b2.getPrice(), b2.isSearch());
		
		//DAO.getBasketDAO().addCardToBasket(extension, number, userId, cardName, image, price, search);
		//CardDatabase.test();
		//CardDatabase.getCards();
		server.start();
		server.join();
	}
}
