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
import com.pokecard.object.User;


@Path("/basket")
public class BasketWebservice {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lastAddedCards")
	public List<Basket> lastAddedCards()
	{
		return DAO.getBasketDAO().getLastAddedCard();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{userId}")
	public List<Basket> getBasketByUserId(@PathParam("userId") String userId)
	{
		return DAO.getBasketDAO().getBasketByUserId(userId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Basket getBasketById(@PathParam("id") String id)
	{
		//return DAO.getBasketDAO().getBasketByUserId(userId);
		return  DAO.getBasketDAO().getBasketById(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add/{extension}/{number}/{userId}/{cardName}/{image}/{price}/{search}")
	public void addCardToBasket(@PathParam("extension") String extension,@PathParam("number") String number,@PathParam("userId") String userId,
			@PathParam("cardName") String cardName,@PathParam("image") String image,@PathParam("price") double price, @PathParam("search") boolean search)
	{
		System.out.println("add basket to card ok");
		DAO.getBasketDAO().addCardToBasket(extension, number, userId, cardName, image, price, search);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add2/{extension}")
	public void addCardToBasket(@PathParam("extension") String extension)
	{
		System.out.println("add basket to card ok");
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
