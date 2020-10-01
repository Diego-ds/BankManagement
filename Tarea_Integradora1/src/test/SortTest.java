package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import exceptions.InsufficientFundsException;
import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import model.BankManagement;
import model.Client;

class SortTest {

	private BankManagement bank;

	public void setup11() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		bank = new BankManagement();
		bank.addToHash("Diego", "131242", 8);
		bank.addToHash("David", "352353", 3);
		bank.addToHash("Pepe", "737332", 5);
		bank.addToHash("Camila", "245132", 2);
		bank.addToHash("Pedro", "743223", 0);
		bank.addToHash("Rodrigo", "813223", 5);
		bank.addToHash("Paula", "535463", 3);
		bank.addToHash("Willy", "456232", 7);
	}

	@Test
	public void testSorts() throws QueueIsAlreadyFullException, QueueIsEmptyException, InsufficientFundsException {
		setup11();
		ArrayList<Client> clients = bank.hashToArray();
		bank.sortByName(clients, 0, clients.size()-1);
		assertTrue(clients.get(0).getName().equals("Camila"));	
		
		bank.sortById(clients, 0, clients.size()-1);
		assertTrue(clients.get(0).getID().equals("131242"));
	
		
		bank.searchClient("131242").setAccountBalance(5000);
		bank.searchClient("737332").setAccountBalance(150000);
		bank.searchClient("352353").setAccountBalance(32000);
		bank.searchClient("245132").setAccountBalance(546946);
		bank.searchClient("743223").setAccountBalance(231);
		bank.searchClient("813223").setAccountBalance(123);
		bank.searchClient("535463").setAccountBalance(457);
		bank.searchClient("456232").setAccountBalance(5253);
		
		bank.sortByAmount(clients);
		assertTrue(clients.get(0).getAccountBalance().equals("546946.0"));
		
		
	}

}
