package it.gestione.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.conto.pojo.ContoCorrente;
import it.conto.pojo.Movimenti;

@Path("/gestione")
public class GestioneEWallet {
	
	private static List<ContoCorrente> conti = new ArrayList<ContoCorrente>();
	private static List<Movimenti> movimenti = new ArrayList<Movimenti>();
	

	@GET
	@Path("/vediconti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimenti> retrieveMovimenti() {
		
		return movimenti;
	}
	
	
	@POST
	@Path("/creaconto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserisciConto(ContoCorrente c) {
		conti.add(c);
		return Response.status(200).entity("Inserimento avvenuto con successo").build();
			
		}
	
	@DELETE
	@Path("/eliminaconto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminaContoCorrente(ContoCorrente c) {
		for (ContoCorrente con : conti) {
			if (con.getIban() == c.getIban()) {
				conti.remove(con);
				break;
			}
		}
		
		return Response.status(200).entity("Eliminazione avvenuta con successo").build();
	}
	
	
	@PUT
	@Path("/aggiornaconto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aggiornaConto(ContoCorrente c) {
			for (ContoCorrente con : conti) {
			if (con.getIban() == c.getIban()) {
				int index = conti.lastIndexOf(con);
				conti.set(index, c);
			}
		}
		
		return Response.status(200).entity("Aggiornamento avvenuto con successo").build();		
	}
	
	@GET
	@Path("/iban")
	@Produces(MediaType.APPLICATION_JSON)
	public ContoCorrente retrieveByPk(@PathParam("iban") int iban) {
		ContoCorrente c = null;
		for(ContoCorrente con : conti) {
			if(con.getIban() == iban)
				c= con;
		}
	
	return c;
}
		
	}



