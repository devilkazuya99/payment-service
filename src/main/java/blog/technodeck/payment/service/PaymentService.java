package blog.technodeck.payment.service;

import blog.technodeck.payment.data.PaymentDetail;
import blog.technodeck.payment.data.TopupInfo;
import blog.technodeck.payment.entity.Wallet;

public interface PaymentService {

	Wallet topupWallet(TopupInfo topupInfo);
	PaymentDetail sumbitPayment(PaymentDetail paymentDetail);

}
