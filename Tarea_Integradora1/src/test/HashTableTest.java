package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Element;
import collections.HashTable;
import model.Client;

class HashTableTest {
	
	private HashTable<String, Client> table;
	
	public void setup8() {
		table = new HashTable<String, Client>();
		
		table.addElement("253221", new Client("Carlos Marti", "253221", 0));
		table.addElement("253331", new Client("Manuelo Coco", "253331", 0));
		
	}

	@Test
	void addElementTest() {
		
		setup8();
		table.addElement("123456", new Client("Alberto Caranchoa", "123456", 3));	
		assertTrue(table.get("123456").getName().equals("Alberto Caranchoa"));
		

		
		
	}
	
	@Test 
	void addElementTest2(){
		
		setup8();
		
		table.addElement("325148", new Client("Amigable Albera", "325148", 0));	
		assertTrue(table.get("325148").getName().equals("Amigable Albera"));
		
		table.addElement("123455", new Client("Martino Espinoza", "123455", 2));	
		assertTrue(table.get("123455").getName().equals("Martino Espinoza"));
		
		table.addElement("354128", new Client("Palermo Vidal", "354128", 5));	
		assertTrue(table.get("354128").getName().equals("Palermo Vidal"));
	}
	
	@Test
	void getTest() {
		
		setup8();
		
		assertTrue(table.get("253221").getName().equals("Carlos Marti"));
		assertTrue(table.get("253331").getName().equals("Manuelo Coco"));
		
	}

	
	@Test
	void getTest2() {
		setup8();
		
		table.addElement("123456", new Client("Alberto Caranchoa", "123456", 3));	
		assertTrue(table.get("123456").getName().equals("Alberto Caranchoa"));
		
	}
	
	
	
	@Test
	void removeElementTest() {
		
		setup8();
		Element<String, Client> erased = new Element<String,Client>(HashTable.DELETED, null);
		
		table.removeElement("253221", erased);
		assertTrue(table.get("253221") == null);
		
		table.addElement("253221", new Client("Carlos Marti", "253221", 0));
		
		table.removeElement("253221", erased);
		assertTrue(table.get("253221") == null);
		
		table.addElement("354128", new Client("Palermo Vidal", "354128", 5));	
		table.removeElement("354128", erased);
		assertTrue(table.get("354128") == null);
		
	}
	
	@Test
	void removeElementTest2() {
		
		setup8();
		Element<String, Client> erased = new Element<String,Client>(HashTable.DELETED, null);

		table.removeElement("253221", erased);
		table.addElement("253221", new Client("Carlos Marti", "253221", 0));

		table.removeElement("253221", erased);
		assertTrue(table.get("253221") == null);
		
		table.addElement("354128", new Client("Palermo Vidal", "354128", 3));	
		table.removeElement("354128", erased);
		assertTrue(table.get("354128") == null);
		
	}

	
}
