package model;

import java.time.LocalDate;

public class Client implements Comparable<Client> {
	
	private DebitCard card;
	private String name;
	private String iD;
	private String accountNumber;
	private double accountBalance;
	private LocalDate registerDate;
	private int priority;
	
	
	public Client(String name, String iD, int priority) {
		this.name = name;
		this.iD = iD;
		this.priority = priority;
		for(int i = 0; i<12; i++) {
			accountNumber += String.valueOf((int)Math.floor(Math.random()*9));
	}
		
		registerDate = LocalDate.now();	
		
		this.card = new DebitCard();
	}

	public DebitCard getCard() {
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

	public String getAccountBalance() {
		return String.valueOf(accountBalance);
	}

	public void setAccountBalance(double payment) {
		this.accountBalance += payment;
	}

	
	
	
}
