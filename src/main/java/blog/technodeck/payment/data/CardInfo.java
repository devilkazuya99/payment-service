package blog.technodeck.payment.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CardInfo {

	@NotBlank
	public String cardNumber;
	@NotBlank
	public String nameOnCard;
	@NotNull
	public Integer expMonth;
	@NotNull
	public Integer expYear;
	@NotNull
	public Integer ccv;
	
}
