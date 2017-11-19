package com.pokecard.daoImplementation;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pokecard.dao.ChatDAO;
import com.pokecard.dao.DAO;
import com.pokecard.database.DatabaseTest;
import com.pokecard.object.Chat;
import com.pokecard.object.Message;
import com.pokecard.test.Test;

public class ChatImpl implements ChatDAO {

	@Override
	public List<Chat> getChatByUserLogin(String login) {
		List<Chat> l = new ArrayList<>();/* DatabaseTest.chats.stream().filter( c -> c.getOrigin().equals(login)).collect(Collectors.toList());
		l.addAll(DatabaseTest.chats.stream().filter( c -> c.getDestination().equals(login)).collect(Collectors.toList()));*/
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, name, origin, destination;
			boolean privy;
			ResultSet result = stmt.executeQuery("select * from Chat");
			while (result.next()) {
				if (login.equals(result.getString(3)) || login.equals(result.getString(4)) /* && Integer.parseInt(number)==result.getInt(3) */) {
					id = result.getString(1);
					name = result.getString(2);
					login = result.getString(3);
					destination = result.getString(4);
					// userid = result.getString(4);
					privy = result.getBoolean(5);
					l.add(new Chat(id, name, login, destination,privy));
				}
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Message> getMessagesByChatId(String chatId) {
		//return DatabaseTest.messages.stream().filter(m -> m.getChatId().equals(chatId)).collect(Collectors.toList());
		List<Message> l = new ArrayList<>();/* DatabaseTest.chats.stream().filter( c -> c.getOrigin().equals(login)).collect(Collectors.toList());
		l.addAll(DatabaseTest.chats.stream().filter( c -> c.getDestination().equals(login)).collect(Collectors.toList()));*/
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id, content, login, destination;
			int position;
			ResultSet result = stmt.executeQuery("SELECT * FROM Message ORDER BY position ASC");
			while (result.next()) {
				if (chatId.equals(result.getString(4)) /* && Integer.parseInt(number)==result.getInt(3) */) {
					id = result.getString(1);
					content = result.getString(2);
					login = result.getString(3);
					// userid = result.getString(4);
					position = result.getInt(5);
					l.add(new Message(id, content, login, chatId,position));
				}
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void insertMessage(Message m) {
		//DatabaseTest.messages.add(m);
		Connection connection;
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			int n = stmt.executeUpdate("insert into Message (id,content, login,chatId,position) values ("
					+ m.toString() + ")");

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createChat(String name, String origin, String destinationId) {
		String login = DAO.getUserDAO().getUserLoginById(destinationId);
		Chat c = new Chat(name, origin, login, true);
		/*DatabaseTest.chats.add(c);*/
		Connection connection;
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			int n = stmt.executeUpdate("insert into Chat(chatId ,name,origin,destination, privy) values ("
					+ c.toString() + ")");

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		DatabaseTest.messages.add(new Message("cont", "log", "id"));
		DatabaseTest.messages.add(new Message("cont2", "log2", "id"));
		DatabaseTest.messages.add(new Message("cont3", "lx", "icdcd"));
		
		System.out.println(new ChatImpl().getMessagesByChatId("id"));
	}*/
	
	

}
