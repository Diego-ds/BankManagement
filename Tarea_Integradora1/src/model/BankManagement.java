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
		actions = new Stack<Bank>(1);
	}
	
	public boolean addToQueue(String name, String iD, int priority) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		if(actions.isEmpty() == false) {
			actions.desapilar();
		}
		
		saveAction(bank);
		return bank.addToQueue(name, iD, priority);
	}
	
	public void addToHash(String name, String iD, int priority) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		if(actions.isEmpty() == false) {
			actions.desapilar();
		}
		
		saveAction(bank);
		bank.addToTable(name, iD, priority);
	}
	
	
	public Client searchClient(String iD) {
		return bank.searchClient(iD);
	}
	
	public double modifyBalance(String iD, double value) throws UserNotFoundException, QueueIsAlreadyFullException, QueueIsEmptyException{
		if(actions.isEmpty() == false) {
			actions.desapilar();
		}
		
		actions.apilar(bank);
		return bank.modifyBalance(iD, value);
	}
	
	public boolean deleteClient(String iD, String reason) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		if(actions.isEmpty() == false) {
			actions.desapilar();
		}
		
		actions.apilar(bank);
		return bank.deleteClient(iD, reason);
	}
	
	public double pay(String iD, int amount) throws UserNotFoundException, QueueIsAlreadyFullException, QueueIsEmptyException {
		if(actions.isEmpty() == false) {
			actions.desapilar();
		}
		
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
