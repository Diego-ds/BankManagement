package model;

import java.time.LocalDate;

import exceptions.InsufficientFundsException;

public class Client implements Comparable<Client> {
	
	private CreditCard card;
	private String name;
	private String iD;
	private String accountNumber;
	private double accountBalance;
	private LocalDate registerDate;
	private int priority;
	
	
	public Client(String name, String iD, int priority) {
		this.accountBalance=0;
		this.name = name;
		this.iD = iD;
		this.priority = priority;
		accountNumber = "";
		for(int i = 0; i<12; i++) {
			accountNumber += String.valueOf((int)Math.floor(Math.random()*9));
	}
		
		registerDate = LocalDate.now();	
		registerDate = registerDate.minusDays((long)Math.floor(Math.random()*30));
		this.card = new CreditCard();
	}

	public CreditCard getCard() {
		return card;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return iD;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Client o) {
		
		return priority-o.getPriority();
	}
	
	public int compareToAux(Client o) {
		
		return registerDate.compareTo(o.getRegisterDate());
	}

	public String getAccountBalance() {
		return String.valueOf(accountBalance);
	}

	public void setAccountBalance(double payment) throws InsufficientFundsException {
		if(payment<0) {
			if(Math.abs(payment)>this.accountBalance) {
				throw new InsufficientFundsException();
			}else {
				this.accountBalance = accountBalance- Math.abs(payment);
			}
		}else {
			this.accountBalance += payment;
		}		
	}

	public void payCreditCard(double moneyAmount) {
		card.balance(moneyAmount);
	}
	
	
}
