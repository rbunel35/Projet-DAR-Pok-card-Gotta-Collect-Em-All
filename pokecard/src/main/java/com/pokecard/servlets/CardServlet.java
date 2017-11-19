package com.pokecard.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import com.pokecard.dao.DAO;
import com.pokecard.object.Card;


public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json");
		String[] req = request.getRequestURI().split("/");
		List<Card> l =DAO.getCardDAO().searchCardsByName(req[3]);
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    try {
		    for(Card c : l) {
		    	JSONObject formDetailsJson = new JSONObject();
		        formDetailsJson.put("extension", c.getExtension());
		        formDetailsJson.put("number", c.getNumber());
		        formDetailsJson.put("cardName", c.getCardName());
		        formDetailsJson.put("image", c.getImage());
		        formDetailsJson.put("price", c.getPrice());
		        jsonArray.put(formDetailsJson);
		    }
	    }catch(Exception e2) {
	    	e2.printStackTrace();
	    }
		try {
			response.getWriter().print(jsonArray);
			response.getWriter().close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
}
