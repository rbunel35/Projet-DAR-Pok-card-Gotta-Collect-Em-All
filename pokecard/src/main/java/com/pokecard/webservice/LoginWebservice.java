package com.pokecard.webservice;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.pokecard.dao.DAO;
import com.pokecard.object.Basket;
import com.pokecard.object.User;


@Path("/login")
public class LoginWebservice {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{login}/{pass}")
	public String[] postMethod(@PathParam("login") String login, @PathParam("pass") String pass)
	{	
		try {
			pass = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(pass.getBytes(StandardCharsets.UTF_8)));
			return DAO.getUserDAO().connection(login, pass);
		}
		catch(NoSuchAlgorithmException nsae) {
			throw new WebApplicationException(500);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{login}/{email}/{pass}")
	public String[] register(@PathParam("login") String login,@PathParam("email") String email, @PathParam("pass") String pass)
	{
		try {
			pass = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(pass.getBytes(StandardCharsets.UTF_8)));
			User u = new User(login, email, pass, "paris", "","");
			return new String[]{DAO.getUserDAO().register(u)};
		}
		catch(NoSuchAlgorithmException nsae) {
			throw new WebApplicationException(500);
		}
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/showusers")
	public List<User> show()
	{
		return DatabaseTest.showUsers();
	}
	*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/basket/{id}")
	public List<Basket> getBasketByUser(@PathParam("id") String userid)
	{
		
		return null;
	}
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/basket/{userid}/{extension}/{number}")
	public void addToBasketByUser(@PathParam("userid") String userid,@PathParam("extension") String extension,@PathParam("number") String number)
	{
		DAO.getUserDAO().insertCard(userid, extension, number, true);
	}
	*/
	
	
	

}
