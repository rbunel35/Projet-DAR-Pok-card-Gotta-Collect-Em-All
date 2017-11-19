package com.pokecard.test;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	  public static Connection getConnection() throws URISyntaxException, SQLException {
	        URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
	        System.out.println("print of dbUrl " +dbUrl);

	        return DriverManager.getConnection(dbUrl, username, password);
	  }
	 
	  
	  
	   
}
