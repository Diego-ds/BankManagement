package model;
import java.util.ArrayList;

import collections.*;
import exceptions.InsufficientFundsException;
import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
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
		deletedClients= new HashTable<String,DeletedClient>();
		
	}
	
	public boolean addToQueue(String name, String iD) throws QueueIsAlreadyFullException {
		boolean a = true;
		
		Client toAdd = searchClient(iD);
		
		if(toAdd != null) {
		
			if(toAdd.getPriority() != 0) {
				Instance<Client> alpha = new Instance<Client>(toAdd);
				colaClientes.insertValue(alpha);
				
			}else {
				colaBasica.enqueue(toAdd);
			}
		}else {
			colaBasica.enqueue(new Client(name, iD, 0));
		}	
		
		return a;
	}
	
	public void removeFromQueue() throws QueueIsEmptyException {
		colaBasica.dequeue();		
	}
	
	public void removeFromPriorityQueue() throws QueueIsEmptyException{
		colaClientes.extract_max();		
	}
	
	public void addToTable(String name, String iD, int priority) {
		Client toHashTable = new Client(name, iD, priority);
		clients.addElement(iD, toHashTable);
	}
	
	public Client searchClient(String iD) {
		return clients.get(iD);
	}
 
	public double modifyBalance(String iD, double value) throws UserNotFoundException, InsufficientFundsException{
		double result;
		
		if(searchClient(iD) != null) {
			result = searchClient(iD).getCard().balance(value);	
		}else {
			throw new UserNotFoundException();
		}
		return result;
	}
	
	public void modifyAmount(String iD, double value) throws UserNotFoundException, InsufficientFundsException{
	
		if(searchClient(iD) != null) {
				searchClient(iD).setAccountBalance(value);;	
		}else {
			throw new UserNotFoundException();
		}
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
	
	
	public ArrayList<Client> hashToArray(){
		ArrayList<Client> a = (ArrayList<Client>) clients.convertList();
		return a;		
	}
	
	//MergeSort nlog(n)
	public void MergeSort(int arr[], int l, int r) { 
	    if (l < r) { 
	        int m = (l + r) / 2;
	        MergeSort(arr, l, m); 
	        MergeSort(arr, m + 1, r); 
	        merge(arr, l, m, r); 
	    } 
	}

	//Merge nlog(n)
	private void merge(int arr[], int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
      
        for (int i = 0; i < n1; ++i) {
        	L[i] = arr[l + i]; 
        }
            
        for (int j = 0; j < n2; ++j) {
        	 R[j] = arr[m + 1 + j]; 
        }

        int i = 0;
        int j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }
	
	public void QuickSort(int arr[], int low, int high) 
	{ 
	    if (low < high) 
	    { 
	        int pi = partition(arr, low, high); 
	        
	        QuickSort(arr, low, pi-1); 
	        QuickSort(arr, pi+1, high); 
	    } 
	}

	//QuickSort nlog(n)
	private int partition(int arr[], int low, int high) { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
             
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        return i+1; 
    }
	
	public int getQueueSize() {
		return colaBasica.getSize();
	}
    
	public int getPrioritySize() {
		return colaClientes.getSize();
	}
}