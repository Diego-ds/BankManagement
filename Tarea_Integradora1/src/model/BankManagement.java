package model;

import java.util.ArrayList;
import java.util.List;

import collections.Stack;
import exceptions.InsufficientFundsException;
import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import exceptions.UserNotFoundException;


public class BankManagement{
	private Bank bank;
	private Stack<Bank> actions;
	
	public BankManagement() {
		this.bank = new Bank();		
		this.actions = new Stack<Bank>(1);
	}
	
	public boolean addToQueue(String name, String iD) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		return bank.addToQueue(name, iD);
	}
	
	public void addToHash(String name, String iD, int priority) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		bank.addToTable(name, iD, priority);
	}
	
	public void removeFromQueue() throws QueueIsEmptyException {
		bank.removeFromQueue();	
		
	}
	
	public void removeFromPriorityQueue() throws QueueIsEmptyException {
		bank.removeFromPriorityQueue();	

	}	
	
	
	public Client searchClient(String iD) throws QueueIsEmptyException, QueueIsAlreadyFullException {
		return bank.searchClient(iD);
	}
	
	public double modifyBalance(String iD, double value) throws UserNotFoundException, QueueIsAlreadyFullException, QueueIsEmptyException, InsufficientFundsException{
		return bank.modifyBalance(iD, value);
	}
	
	public void modifyAmount(String id,double value) throws UserNotFoundException, InsufficientFundsException {
		bank.modifyAmount(id, value);
	}
	
	@Override
	public Object clone() {
	    try {
	        return (Bank) super.clone();
	    } catch (CloneNotSupportedException e) {
	        return new Bank();
	    }
	}
	
	public boolean deleteClient(String iD, String reason) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		
		Bank asd = (Bank) clone();
		actions.apilar(asd);
		return bank.deleteClient(iD, reason);
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
	
	public int getSizeQueue() {
		return bank.getQueueSize();
	}

	public int getPrioritySize() {
		return bank.getPrioritySize();
	}
	public void sortByName(List<Client> arr,int low,int high){
	        if (low < high) 
	        { 
	            int pi = partition(arr, low, high); 
	            
	            sortByName(arr, low, pi-1); 
	            sortByName(arr, pi+1, high); 
	        }     
	}
	
	private int partition(List<Client> arr, int low, int high) { 
        Client pivot = arr.get(high);  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
             
            if (arr.get(j).getName().compareTo(pivot.getName()) < 0) 
            { 
                i++; 
                Client temp = arr.get(i); 
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            } 
        } 
  
        Client temp = arr.get(i+1); 
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);
  
        return i+1; 
    }
	
	public  void sortById(List<Client> arr, int l, int r) { 
		if (l < r) { 
			int m = (l + r) / 2;
			sortById(arr, l, m); 
			sortById(arr, m + 1, r); 
			merge(arr, l, m, r); 
		} 
	}
	
	private  void merge(List<Client> arr, int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        Client L[] = new Client[n1]; 
        Client R[] = new Client[n2]; 
  
      
        for (int i = 0; i < n1; ++i) {
        	L[i] = arr.get(l + i);  
        }
        	   
        for (int j = 0; j < n2; ++j) {
        	R[j] = arr.get(m + 1 + j);
        } 
        	 
        int i = 0;
        int j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) { 
    
            if (L[i].getID().compareTo(R[j].getID()) <= 0) { 
            	arr.set(k, L[i]);
                i++; 
            } else { 
            	arr.set(k, R[j]);
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) { 
        	arr.set(k, L[i]);
            i++; 
            k++; 
        } 
  
        while (j < n2) { 
        	arr.set(k, R[j]);
            j++; 
            k++; 
        } 
    }
	
	  public void sortByAmount(ArrayList <Client> arr) { 
        int n = arr.size(); 
        
        for (int i = 1; i < n; ++i) { 
        	
            Client key = arr.get(i); 
            int j = i - 1; 
            
        	double tr = Double.parseDouble(key.getAccountBalance());
        	
            while (j >= 0 && Double.parseDouble(arr.get(j).getAccountBalance()) < tr) { 
            	arr.set(j+1, arr.get(j));
                j = j-1; 
            }   
            arr.set(j+1, key);
        } 
    }
	
}
