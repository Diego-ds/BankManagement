package model;
import collections.*;

public class Bank{
	
	private HashTable<String, Client> clients;
	private IQueue<Client> colaClientes;
	private IQueue<Client> colaBasica;
	
	public Bank() {
		this.colaBasica= new Queue<Client>();
		this.colaClientes = new Queue<Client>();
		clients = new HashTable<String,Client>();
	}
	
	//TODO
	public boolean addClient(String name, String iD) {
		boolean a = false;
		
	
		
		return a;
	}
	
	
	//TODO
	public Client searchClient(String code) {
		
		return null;
	}
 
	
	//TODO 
	public boolean modifyBalance(String iD) {
		boolean a = false;
		
		return a;
	}
	
	//TODO
	public boolean deleteClient(String iD, String reason) {
		boolean a = false;
		
		Element<String, Client> erased = new Element<String,Client>(HashTable.DELETED, null);
		clients.removeElement(iD, erased);
		
		return a;
	}
	
	
	//TODO
	public boolean pay(String iD, int amount) {
		boolean a = false;
		
		return a;
	}
	
	//TODO
	public void saveAction() {
		
	}
	
	//TODO
	public void undo() {
		
	}
}