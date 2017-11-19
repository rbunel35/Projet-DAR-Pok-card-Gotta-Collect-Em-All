package com.pokecard.daoImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pokecard.dao.BasketDAO;
import com.pokecard.dao.DAO;
import com.pokecard.object.Basket;
import com.pokecard.object.Card;
import com.pokecard.test.Test;

public class BasketImpl implements BasketDAO {

	@Override
	public List<Basket> getBasketByUserId(String userId) {
		List<Basket> l = new ArrayList<Basket>();
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, extension, number, cardName, image;
			int price;
			boolean search;
			ResultSet result = stmt.executeQuery("select * from basket");
			while (result.next()) {
				if (userId.equals(result.getString(
						4)) /* && Integer.parseInt(number)==result.getInt(3) */) {
					id = result.getString(1);
					extension = result.getString(2);
					number = result.getString(3);
					// userid = result.getString(4);
					cardName = result.getString(5);
					image = result.getString(6);
					price = result.getInt(7);
					search = result.getBoolean(8);
					l.add(new Basket(id, extension, number, userId, cardName, image, price, search));
				}
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void addCardToBasket(String extension, String number, String userId, String cardName, String image,
			double price, boolean search) {
		Connection connection;
		Basket basket = new Basket(extension, number, userId, cardName, image, price, search);
		System.out.println("ADD CARD TO BASKET"+basket.toString());
		// Basket bask = new Basket(extention, c.getNumber(), login, b,
		// c.getComment(), c.getImage());
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			int n = stmt.executeUpdate("insert into Basket(id,extension,number,idmember,cardName,image,price,search)values ("
					+ basket.toString() + ")");

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCardFromBasketById(String basketid) {
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement( 
		            ResultSet.TYPE_SCROLL_SENSITIVE, 
		            ResultSet.CONCUR_UPDATABLE);
			ResultSet result = stmt.executeQuery("select * from basket");
			while (result.next()) {
				if (basketid.equals(result.getString(1)) /* && Integer.parseInt(number)==result.getInt(3) */) {
					result.deleteRow();
				}
			}
			result.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Basket> getLastAddedCard() {
		List<Basket> l = new ArrayList<Basket>();
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, extension, number,userId, cardName, image;
			double price;
			boolean search;
			ResultSet result = stmt.executeQuery("select * from basket");
			while (result.next()) {

				id = result.getString(1);
				extension = result.getString(2);
				number = result.getString(3);
				userId = result.getString(4);
				cardName = result.getString(5);
				image = result.getString(6);
				price = result.getDouble(7);
				search = result.getBoolean(8);
				l.add(new Basket(id, extension, number, userId, cardName, image, price, search));

			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Basket getBasketById(String id) {
		Basket b = null;
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String  extension, number,userid, cardName, image;
			double price;
			boolean search;
			ResultSet result = stmt.executeQuery("select * from basket");
			while (result.next()) {
				if (id.equals(result.getString(
						1)) /* && Integer.parseInt(number)==result.getInt(3) */) {
					id = result.getString(1);
					extension = result.getString(2);
					number = result.getString(3);
					userid = result.getString(4);
					cardName = result.getString(5);
					image = result.getString(6);
					price = result.getDouble(7);
					search = result.getBoolean(8);
					b = new Basket(id, extension, number, userid, cardName, image, price, search);
					//l.add(new Basket(id, extension, number, userId, cardName, image, price, search));
				}
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public List<Basket> getBasketByCardName(String cardName){
		List<Basket> l = new ArrayList<Basket>();
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, extension, number, userId,image;
			int price;
			boolean search;
			ResultSet result = stmt.executeQuery("select * from basket");
			while (result.next()) {
				if (cardName.equals(result.getString(5))) {
					id = result.getString(1);
					extension = result.getString(2);
					number = result.getString(3);
					userId = result.getString(4);
					image = result.getString(6);
					price = result.getInt(7);
					search = result.getBoolean(8);
					l.add(new Basket(id, extension, number, userId, cardName, image, price, search));
				}
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}
