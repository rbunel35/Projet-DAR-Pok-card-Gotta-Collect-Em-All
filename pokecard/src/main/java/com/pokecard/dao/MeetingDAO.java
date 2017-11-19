package com.pokecard.dao;

import java.util.List;
import com.pokecard.object.Meeting;;

public interface MeetingDAO {
	
	public void insertMeeting(Meeting m);
	
	public List<Meeting> getMeetings(String login);
	
	

}
