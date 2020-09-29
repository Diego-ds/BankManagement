package model;
import collections.*;
import exceptions.QueueIsAlreadyFullException;
import exceptions.UserNotFoundException;

public class Bank{
	
	private HashTable<String, Client> clients;
	private HashTable<String, DeletedClient> deletedClients;
	private PriorityQueue<Client> colaClientes;
	private Queue<Client> colaBasica;
	
	
	public Bank() {
		this.colaBasica= new Queue<Client>(20);
		this.colaClientes = new PriorityQueue<Client>();
		clients = new HashTable<String,Client>();
	}
	
	public boolean addToQueue(String name, String iD, int priority) throws QueueIsAlreadyFullException {
		boolean a = true;
		
		Client toAdd = searchClient(iD);
		
		if(toAdd != null) {
		
			if(priority != 0) {
				Instance<Client> alpha = new Instance<Client>(toAdd);
				colaClientes.insertValue(alpha);
				
			}else {
				colaBasica.enqueue(toAdd);
			}
		}else {
			colaBasica.enqueue(new Client(name, iD, priority));
		}	
		
		return a;
	}
	
	public void addToTable(String name, String iD, int priority) {
		Client toHashTable = new Client(name, iD, priority);
		clients.addElement(iD, toHashTable);
	}
	
	public Client searchClient(String iD) {
		return clients.get(iD);
	}
 
	public double modifyBalance(String iD, double value) throws UserNotFoundException{
		double result;
		
		if(searchClient(iD) != null) {
			result = searchClient(iD).getCard().balance(value);	
		}else {
			throw new UserNotFoundException();
		}
		return result;
	}
	
	public boolean deleteClient(String iD, String reason) {
		boolean a = false;
		Element<String, Client> erased = new Element<String,Client>(HashTable.DELETED, null);
		Client sd = clients.removeElement(iD, erased);
	
		if(sd != null) {
		DeletedClient b = new DeletedClient(sd.getName(), sd.getID(), sd.getPriority(), reason);
		deletedClients.addElement(b.getID(), b);
		a = true;
		}
		
		return a;
	}
	

	public double pay(String iD, int amount) throws UserNotFoundException {
		
		double a;
		if(clients.get(iD) != null) {
		clients.get(iD).setAccountBalance(amount);
		a = clients.get(iD).getAccountBalance();
		}else throw new UserNotFoundException();
		
		return a;
	}
}