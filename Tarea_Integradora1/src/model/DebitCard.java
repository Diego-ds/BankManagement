package model;

import java.time.LocalDate;

public class DebitCard {
	private String cardNumber;
	private LocalDate paymentDue;
	private double moneyAmount;
	
	public DebitCard(){
	
		for(int i = 0; i<10; i++) {
			cardNumber += String.valueOf((int)Math.floor(Math.random()*9));
		}
		
		paymentDue = LocalDate.now();
		paymentDue = paymentDue.plusMonths(1);	
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getPaymentDueString() {
		String a = String.valueOf(paymentDue.getYear()) + String.valueOf(paymentDue.getMonthValue());
		
		return a;
	}
	
	public LocalDate getPaymentDue() {
		return paymentDue;
	}

	public double getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	
}