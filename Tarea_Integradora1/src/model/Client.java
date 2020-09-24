package model;

import java.time.LocalDate;

public class Client {
	
	private DebitCard card;
	private String name;
	private String iD;
	private String accountNumber;
	private LocalDate registerDate;
	
	
	public Client(String name, String iD) {
		this.name = name;
		this.iD = iD;
		
		for(int i = 0; i<12; i++) {
			accountNumber += String.valueOf((int)Math.floor(Math.random()*9));
	}
		
		registerDate = LocalDate.now();	
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
	
	
	
}
