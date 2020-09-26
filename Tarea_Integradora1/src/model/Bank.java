package model;
import collections.*;

public class Bank{
	
	private HashTable<String, Client> clients;
	private PriorityQueue<Client> colaClientes;
	private Queue<Client> colaBasica;
	private Stack<Client> actions;
	
	public Bank() {
		this.colaBasica= new Queue<Client>();
		this.colaClientes = new PriorityQueue<Client>();
		clients = new HashTable<String,Client>();
		actions = new Stack<Client>();
	}
	
	//TODO Check method
	public boolean addClient(String name, String iD, int priority) {
		boolean a = false;
		if(priority != 0) {
			Instance<Client> alpha = new Instance<Client>(new Client(name, iD, priority));
			colaClientes.insert(alpha);
			a = true;
		}else {
			colaBasica.enqueue(new Client(name, iD, priority));
			a = true;
		}
	
		return a;
	}
	
	
	//TODO Check method
	public Client searchClient(String iD) {
		return clients.get(iD);
	}
 
	
	//TODO Check method
	public double modifyBalance(String iD, double value) {
		double result = searchClient(iD).getCard().balance(value);	
		return result;
	}
	
	//TODO
	public boolean deleteClient(String iD, String reason) {
		boolean a = false;
		
		Element<String, Client> erased = new Element<String,Client>(HashTable.DELETED, null);
		clients.removeElement(iD, erased);
		
		return a;
	}
	
	
	//TODO
	public double pay(String iD, int amount) {
		boolean a = false;
		saveAction(clients.get(iD));
		
		clients.get(iD).setAccountBalance(amount);
		return clients.get(iD).getAccountBalance();
	}
	
	//TODO
	public void saveAction(Client action) {
	}
	
	//TODO
	public void undo() {
	}
}