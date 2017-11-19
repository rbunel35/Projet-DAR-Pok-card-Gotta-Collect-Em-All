package com.pokecard.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class Page {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public FileInputStream getTest() throws FileNotFoundException {
		return file("index.html");
		// return file("index.jsp");
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/home")
	public FileInputStream getIndex() throws FileNotFoundException {
		// return file("test.html");
		return file("home.html");
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/cardpage")
	public FileInputStream getCardPage() throws FileNotFoundException {
		// return file("test.html");
		return file("404.html");
	}

	// ---- SEARCH PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/search")
	public FileInputStream getSearch() throws FileNotFoundException {
		return file("404.html");
	}

	// ---- HELLO USER PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/hellouser")
	public FileInputStream getHelloUser() throws FileNotFoundException {
		return file("idem/helloUser.html");
	}

	// ---- BASKET PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/BASKET")
	public FileInputStream getBasket() throws FileNotFoundException {
		return file("basket.html");
	}

	// ---- MESSAGES PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/messages")
	public FileInputStream getMessages() throws FileNotFoundException {
		return file("chat.html");
	}

	// ---- MEET PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/meet")
	public FileInputStream getMeet() throws FileNotFoundException {
		return file("meeting.html");
	}

	// ---- FORUM PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/forum")
	public FileInputStream getForum() throws FileNotFoundException {
		return file("404.html");
	}

	// ---- CONTACT PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/contact")
	public FileInputStream getContact() throws FileNotFoundException {
		return file("404.html");
	}

	// ---- PROFIL PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/profil")
	public FileInputStream getProfil() throws FileNotFoundException {
		return file("404.html");
	}

	// ---- LOG&REGISTER PAGE --------
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/log")
	public FileInputStream getLogRegister() throws FileNotFoundException {
		// return file("404.html");
		return file("loginRegister.html");
	}



	/* END OF PAGES */

	// Get menu
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/menu")
	public FileInputStream getMenu() throws FileNotFoundException {
		return file("idem/menu.html");
	}

	// Get header
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/header")
	public FileInputStream getHeader() throws FileNotFoundException {
		return file("idem/header.html");
	}

	// Get footer
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/footer")
	public FileInputStream getFooter() throws FileNotFoundException {
		return file("idem/footer.html");
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(String req) {
		System.out.println(req);
		return Response.status(200).entity(req).build();
	}

	public FileInputStream file(String s) throws FileNotFoundException {
		File f = new File("src/main/webapp/" + s);
		return new FileInputStream(f);
	}

}
