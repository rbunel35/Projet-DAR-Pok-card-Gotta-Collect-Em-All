package com.pokecard.daoImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pokecard.dao.MeetingDAO;
import com.pokecard.object.Meeting;
import com.pokecard.test.Test;

public class MeetingImpl implements MeetingDAO {

	@Override
	public void insertMeeting(Meeting m) {
		// TODO Auto-generated method stub
		//DatabaseTest.meetings.add(m);
		Connection connection;
		try {
			connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			int n = stmt.executeUpdate("insert into  Meeting (meetingID, adress, login1, login2, addDate)values ("
					+ m.toString() + ")");

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Meeting> getMeetings(String login) {
		// TODO Auto-generated method stub
		//return DatabaseTest.meetings.stream().filter( c -> c.getLogin().equals(login)).collect(Collectors.toList());
		List<Meeting> l = new ArrayList<>();
		try {
			Connection connection = Test.getConnection();
			Statement stmt = connection.createStatement();
			String id,adress, name,name2;
			long date;
			ResultSet result = stmt.executeQuery("select * from Meeting");
			while (result.next()) {
				if (login.equals(result.getString(4)) /* && Integer.parseInt(number)==result.getInt(3) */) {
					id = result.getString(1);
					adress = result.getString(2);
					date=result.getLong(3);
					name = result.getString(4);
					name2 = result.getString(5);
					l.add(new Meeting(id,adress, name, name2,date));
				}
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

}
