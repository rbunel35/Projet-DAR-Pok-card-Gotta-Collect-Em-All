
/*package com.pokecard.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pokecard.dao.DAO;
import com.pokecard.object.Card;
import com.pokecard.utils.CardOwner;


@Path("/card")
public class CardWebservice {
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{name}")
	public List<Card> searchCardsByName(@PathParam("name") String name)
	{
		//return  DAO.getCardDAO().getLastCards();
		return DAO.getCardDAO().searchCardsByName(name);
		
		
	}

}*/
