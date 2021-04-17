package blog.technodeck.payment.data;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaymentDetail {

	@NotNull
	public Long walletId;
	@NotNull
	public Float amount;
	public String transactionId;
	public ZonedDateTime createdDate;
	public ZonedDateTime updatedDate;
	public String status;
	
	public PaymentDetail() {}
	
	public PaymentDetail(@NotNull Long walletId, @NotNull Float amount, String transactionId, ZonedDateTime createdDate,
	        ZonedDateTime updatedDate, String status) {
		super();
		this.walletId = walletId;
		this.amount = amount;
		this.transactionId = transactionId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.status = status;
	}
	
}
