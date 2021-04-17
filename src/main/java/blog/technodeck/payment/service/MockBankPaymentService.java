package blog.technodeck.payment.service;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import blog.technodeck.payment.data.PaymentDetail;
import blog.technodeck.payment.data.TopupInfo;
import blog.technodeck.payment.entity.Wallet;

@ApplicationScoped
public class MockBankPaymentService implements PaymentService {

	@Transactional
	@Override
	public Wallet topupWallet(TopupInfo topupInfo) {
		Wallet wallet = Wallet.findById(topupInfo.walletId);
		wallet.balance += topupInfo.amount;
		wallet.persist();
		return wallet;
	}

	@Transactional
	@Override
	public PaymentDetail sumbitPayment(PaymentDetail paymentDetail) {

		Wallet wallet = Wallet.findById(paymentDetail.walletId);
		wallet.balance -= paymentDetail.amount;
		wallet.persist();
		Float amount = paymentDetail.amount;
		String transactionId = UUID.randomUUID().toString();
		ZonedDateTime createdDate = paymentDetail.createdDate;
		ZonedDateTime updatedDate = ZonedDateTime.now();
		String status = "SUCCESS";
		return new PaymentDetail(wallet.id, amount, transactionId, createdDate, updatedDate, status);

	}

}
