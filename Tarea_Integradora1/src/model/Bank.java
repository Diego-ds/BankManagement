package model;
import collections.*;

public class Bank{
	
	private IQueue<Client> colaClientes;
	private IQueue<Client> colaBasica;
	
	public Bank() {
		this.colaBasica= new Queue<Client>();
		this.colaClientes = new Queue<Client>();
	}
	
	//TODO
	public Client searchClient(String code) {
		
		return null;
	}
	
	//TODO
	public void addClient(String name, String iD) {
		
		
	}
	 
	
	//TODO 
	public boolean modifyBalance(String iD) {
		boolean a = false;
		
		return a;
	}
	
	//TODO
	public boolean deleteClient(String iD) {
		boolean a = false;
		
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