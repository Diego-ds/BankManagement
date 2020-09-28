package model;

import collections.Stack;
import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import exceptions.UserNotFoundException;

public class BankManagement {
	private Bank bank;
	private Stack<Bank> actions;
	
	public BankManagement() {
		this.bank = new Bank();		
		actions = new Stack<Bank>();
	}
	
	public boolean addClient(String name, String iD, int priority) throws QueueIsAlreadyFullException {
		saveAction(bank);
		return bank.addClient(name, iD, priority);
	}
	
	public void addToHash(String name, String iD, int priority) throws QueueIsAlreadyFullException {
		saveAction(bank);
		bank.addToTable(name, iD, priority);
	}
	
	
	public Client searchClient(String iD) {
		return bank.searchClient(iD);
	}
	
	public double modifyBalance(String iD, double value) throws UserNotFoundException, QueueIsAlreadyFullException{
		actions.apilar(bank);
		return bank.modifyBalance(iD, value);
	}
	
	public boolean deleteClient(String iD, String reason) throws QueueIsAlreadyFullException {
		actions.apilar(bank);
		return bank.deleteClient(iD, reason);
	}
	
	public double pay(String iD, int amount) throws UserNotFoundException, QueueIsAlreadyFullException {
		actions.apilar(bank);
		return bank.pay(iD, amount);
	}
	
	public void saveAction(Bank bank) throws QueueIsAlreadyFullException {
		actions.apilar(bank);
	}
		
	public boolean undo() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		this.bank = actions.desapilar();
		return false;
	}

	
}
