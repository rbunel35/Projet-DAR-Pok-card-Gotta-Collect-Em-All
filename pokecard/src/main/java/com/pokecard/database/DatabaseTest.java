package com.pokecard.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pokecard.object.Basket;
import com.pokecard.object.Card;
import com.pokecard.object.Chat;
import com.pokecard.object.Meeting;
import com.pokecard.object.Message;
import com.pokecard.object.User;
import com.pokecard.test.Test;
import com.pokecard.utils.CardOwner;

public class DatabaseTest {

	public static void main(String[] args) {
		// System.out.println(DatabaseTest.connection("mohamed", "pass")[0]);

	}
	
	public static List<Meeting> meetings = new ArrayList<Meeting>();
	/*
	private static ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(
			new Card("card@77qzs69zQF2U", "Noir & Blanc", "1665165", "userName", "Pikachu", "assets/img2/Pikachu.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@SzU6lR4Ip7bA", "Noir & Blanc", "1665165", "userName", "Nymphali", "assets/img2/Nymphali.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@9O8Zqy79r7wH", "XY", "1665165", "userName", "Pikachu", "assets/img2/Pikachu.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@7Lz2pNRmjDE4", "XY", "1665165", "userName", "Nymphali", "assets/img2/Nymphali.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@aswo602aj0hD", "Soleil Lune", "1665165", "userName", "Pikachu", "assets/img2/Pikachu.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@MIRYt96MIfRr", "Soleil Lune", "1665165", "userName", "Nymphali", "assets/img2/Nymphali.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@lBGb5eAv7De3", "Promo Wizard", "1665165", "userName", "Pikachu", "assets/img2/Pikachu.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@wuwA701bUp9i", "Promo Wizard", "1665165", "userName", "Nymphali", "assets/img2/Nymphali.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@Qd25dbgik0AN", "Promo Wizard", "1665165", "userName", "Pikachu", "assets/img2/Pikachu.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@9j0hiUmHclHl", "Soleil Lune", "1665165", "userName", "Nymphali", "assets/img2/Nymphali.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@LjNt9A7YqAos", "Promo Wizard", "1665165", "userName", "Pikachu", "assets/img2/Pikachu.png",
					new java.util.Date().getTime(), "comment", 30),
			new Card("card@u7KjJ6n5oEAv", "Promo Wizard", "1665165", "userName", "Nymphali", "assets/img2/Nymphali.png",
					new java.util.Date().getTime(), "comment", 30)

	));
	*/
	public final static User mohamed = new User("mohamed", "pass", "pass", "city", "question", "answer");
	public final static User karim = new User("karim", "pass", "pass", "city", "question", "answer");
	public static List<User> users = new ArrayList<User>(
			Arrays.asList(mohamed, getUser("richard"), karim, getUser("patrick")));
	
	public static List<Chat> chats = new ArrayList<>();
	public static List<Message> messages = new ArrayList<>();
	//public static List<Basket> baskets = fillBasket();
	
	private static User getUser(String s) {
		return new User(s, s + "@pokecard.com", "pass", "paris", "question", "answer");
	}
	/*
	private static List<Basket> fillBasket() {
		List<Basket> l = new ArrayList<>();
		l.addAll(fillBasketAux(users.get(0).getId()));
		l.addAll(fillBasketAux(users.get(1).getId()));
		l.addAll(fillBasketAux(users.get(2).getId()));
		l.addAll(fillBasketAux(users.get(3).getId()));
		return l;
	}
	/*
	private static List<Basket> fillBasketAux(String userId) {
		List<Basket> l = new ArrayList<>();
		ArrayList<Card> cards2 = (ArrayList<Card>) cards.clone();
		int x = 0;
		Card c = null;
		for (int i = 0; i < 12; i++) {
			x = (int) (Math.random() * cards2.size());
			c = cards2.remove(x);
			l.add(new Basket(c.getExtension(), c.getNumber(), userId, true, "comment", c.getImage()));
		}
		return l;
	}
	private static void addToBasket(String userid, String extension, String number){
		Basket b = new Basket(extension, number, userid, true, "", "");
		baskets.add(b);
	}
	
	public static List<Basket> getBasketList(String userId) {
		List<Basket> l = new ArrayList<>();
		for (Basket basket : baskets) {
			if (basket.getUserId().equals(userId))
				l.add(basket);
		}
		return l;
	}

	public static List<User> showUsers() {
		List<User> l = new ArrayList<>();
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, name, mail, pass, city, question, answer;
			// int n = stmt.executeUpdate("select * from card");
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
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	/** CONNECTION **/

	public static String[] connection(String login, String pass) {
		String s = "login";
		String y = "";
		boolean b = false;
		for (User user : users) {
			if (user.getName().equals(login)) {
				b = true;
				if (user.getPass().equals(pass)) {
					s = user.getId();
					y = user.getName();
				} else
					s = "password";
			}
		}
		return new String[] { s, y };
	}

	/** REGISTER **/

	public static String register(User u) {
		String s = "user";
		for (User user : users) {
			if (user.getName().equals(u.getName())) {
				return "login";
			}
			if (user.getMail().equals(u.getMail()))
				return "mail";
		}
		users.add(u);
		return "ok";
	}

	public static void fillCard() {

	}
	/*
	public static List<Card> getLastCard(int number) {
		/*
		 * System.out.println("in database test"); List<Card> l = new ArrayList<Card>();
		 * Card c = null; for (int i = 0; i < number; i++) {
		 * 
		 * l.add(randomCard()); } return l;
		 
		return cards;
	}

	public static Card getCard(String id) {
		for (Card card : cards) {
			if (card.getId().equals(id))
				return card;
		}
		return null;

	}
	*/
	private static String randomUser() {
		double x = Math.random();
		String u;
		if (x < 0.25) {
			u = "richarddddd";
		} else if (x < 0.5) {
			u = "karimmmmm";
		} else if (x < 0.75) {
			u = "patrickkkk";
		} else {
			u = "mohameddddd";
		}
		return u;
	}

}
