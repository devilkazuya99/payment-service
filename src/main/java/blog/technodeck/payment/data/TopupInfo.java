package blog.technodeck.payment.data;

import javax.validation.constraints.NotNull;

public class TopupInfo {

	@NotNull
	public Long walletId;
	@NotNull
	public Float amount;
	@NotNull
	public CardInfo card;
	
}
