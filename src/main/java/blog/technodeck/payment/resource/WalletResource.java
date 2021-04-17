package blog.technodeck.payment.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import blog.technodeck.payment.entity.Wallet;
import io.quarkus.panache.common.Sort;

@Path("/wallet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WalletResource {

	@GET
	public List<Wallet> getAllWallet(){
		return Wallet.findAll(Sort.by("id").ascending()).list();
	}
	
    @GET
    @Path("/{id}")
    public Wallet getWallet(@PathParam("id") Long id) {
        return Wallet.findById(id);
    }
    
    @Transactional
    @POST
    public Wallet createWallet(@Valid Wallet wallet) {
    	wallet.persist();
    	return wallet;
    }
    
    @Transactional
    @PUT
    @Path("/{id}")
    public Wallet updateWallet(@PathParam("id") Long id, Wallet w) {
    	Wallet wallet = Wallet.findById(id);
    	wallet.balance = w.balance;
    	wallet.description = w.description;
    	return wallet;
    }
    
    @Transactional
    @DELETE
    @Path("/{id}")
    public boolean deleteWallet(@PathParam("id") Long id) {
    	return Wallet.deleteById(id);
    }
}
