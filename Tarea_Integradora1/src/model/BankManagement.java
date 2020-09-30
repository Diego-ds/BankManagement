package model;

import java.util.ArrayList;

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
		return bank.addToQueue(name, iD, priority);
	}
	
	public void addToHash(String name, String iD, int priority) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		bank.addToTable(name, iD, priority);
	}
	
	
	public Client searchClient(String iD) {
		return bank.searchClient(iD);
	}
	
	public double modifyBalance(String iD, double value) throws UserNotFoundException, QueueIsAlreadyFullException, QueueIsEmptyException{

		return bank.modifyBalance(iD, value);
	}
	
	public double pay(String iD, int amount) throws UserNotFoundException, QueueIsAlreadyFullException, QueueIsEmptyException {

		return bank.pay(iD, amount);
	}
	
	public boolean deleteClient(String iD, String reason) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		if(actions.isEmpty() == false) {
			actions.desapilar();
		}
		
		saveAction(bank);
		return bank.deleteClient(iD, reason);
	}

	public void saveAction(Bank bank) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		actions.apilar(bank);	
	}
		
	public Bank undo() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		
		return actions.desapilar();
	}
	
	
	public ArrayList<Client> hashToArray(){
		return bank.hashToArray();
	}

	public void setBank(Bank bank) {
		this.bank=bank;
	}
}
