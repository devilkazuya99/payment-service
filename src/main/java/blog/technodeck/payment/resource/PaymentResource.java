package blog.technodeck.payment.resource;

import java.time.ZonedDateTime;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import blog.technodeck.payment.data.PaymentDetail;
import blog.technodeck.payment.data.TopupInfo;
import blog.technodeck.payment.entity.Wallet;
import blog.technodeck.payment.service.PaymentService;

@Path("/payment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentResource {
    
	@Inject
	PaymentService paymentService;
	
	@POST
	@Path("/topup")
	public Wallet topupWallet(@Valid TopupInfo topupInfo) {
		return paymentService.topupWallet(topupInfo);
	}
	
	@POST
	@Path("/submit")
	public PaymentDetail submitPayment(@Valid PaymentDetail paymentDetail) {
		paymentDetail.createdDate = ZonedDateTime.now();
		return paymentService.sumbitPayment(paymentDetail);
	}
	
	
}
