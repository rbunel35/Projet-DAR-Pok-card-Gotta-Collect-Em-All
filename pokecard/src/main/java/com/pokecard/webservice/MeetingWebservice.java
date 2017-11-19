package com.pokecard.webservice;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pokecard.dao.DAO;
import com.pokecard.database.DatabaseTest;
import com.pokecard.object.Basket;
import com.pokecard.object.Meeting;
import com.pokecard.object.User;


@Path("/meeting")
public class MeetingWebservice {

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{login}")
	public List<Meeting> getMeetingByLogin(@PathParam("login") String login)
	{
		return DAO.getMeetingDAO().getMeetings(login);
	}
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add/{adress}/{login}/{name}/{date}")
	public void insertMeeting(@PathParam("adress") String adress,@PathParam("login") String login,@PathParam("name") String name,@PathParam("date") long date)
	{
		Meeting m = new Meeting(adress, login, name, date);
		DAO.getMeetingDAO().insertMeeting(m);
		System.out.println(m);
		//DAO.getBasketDAO().addCardToBasket(extension, number, userId, cardName, image, price, search);
	}
	
	
	
	
	
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/showusers")
	public List<User> show()
	{
		return DatabaseTest.showUsers();
	}*/
}
