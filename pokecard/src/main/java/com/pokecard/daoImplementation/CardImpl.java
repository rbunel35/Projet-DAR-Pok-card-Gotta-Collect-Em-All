package com.pokecard.daoImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import com.pokecard.dao.CardDAO;
import com.pokecard.database.CardDatabase;
import com.pokecard.object.Card;
import com.pokecard.test.Test;
import com.pokecard.utils.CardOwner;

public class CardImpl implements CardDAO {

	@Override
	public List<Card> searchCardsByName(String name) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpHost target = new HttpHost("pokeprices.doeiqts.com", 80, "http");
			HttpGet getRequest = new HttpGet("/api/findcards?cardname=" + name);
			HttpResponse httpResponse = httpclient.execute(target, getRequest);
			HttpEntity entity = httpResponse.getEntity();

			if (entity != null) {
				String s = EntityUtils.toString(entity);
				JSONObject result = new JSONObject(s);
				List<Card> list = new ArrayList<Card>();
				JSONArray array = result.getJSONArray("cards");
				Card c = null;
				String extension, cardName, image, number;
				double price;
				double p;
				for (int i = 0; i < array.length(); i++) {
					extension = array.getJSONObject(i).getString("set");
					cardName = array.getJSONObject(i).getString("name");
					image = array.getJSONObject(i).getString("URL");
					number = array.getJSONObject(i).getString("number");
					price = array.getJSONObject(i).getDouble("price");
					list.add(new Card(extension, number, cardName, image, price));
				}
				return list;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return null;
	}

	@Override
	public List<Card> searchCardsByExtensionAndName(String extension, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card searchCardsByExtentionAndNumber(String extension, String number) {
		// TODO Auto-generated method stub
		return null;
	}

}
