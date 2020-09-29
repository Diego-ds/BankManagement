package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import collections.Instance;
import collections.PriorityQueue;
import exceptions.QueueIsEmptyException;
import model.Client;

public class PriorityQueueTest {

	private PriorityQueue<Client> queue;
	
	public void setup9() {
		queue = new PriorityQueue<Client>();
		
		queue.insertValue(new Instance<Client>(new Client("Cumbia Marina", "123456", 5)));
		queue.insertValue(new Instance<Client>(new Client("Manuelo Coco", "253331", 1)));
		queue.insertValue(new Instance<Client>(new Client("Carlos Marti", "253221", 20)));
	}
	
	public void setup10() {
		queue = new PriorityQueue<Client>();
	}
	
	@Test
		public void insertValueTest() throws QueueIsEmptyException {
		setup10();
		queue.insertValue(new Instance<Client>(new Client("Padrino", "353622", 20)));
		assertTrue(queue.maximun().getName().equals("Padrino"));
	
	} 
	
	@Test
	public void insertValueTest2() throws QueueIsEmptyException {
		setup9();
		queue.insertValue(new Instance<Client>(new Client("Marino", "353622", 50)));
		assertTrue(queue.maximun().getName().equals("Marino"));
	
	}
	
	@Test
	public void maximumTest() throws QueueIsEmptyException {
		setup9();
		assertTrue(queue.maximun().getName().equals("Carlos Marti"));
	
	}
	
	@Test
	public void maximumTest2() throws QueueIsEmptyException {
		setup10();
		queue.insertValue(new Instance<Client>(new Client("Marino", "253221", 50)));
		assertTrue(queue.maximun().getName().equals("Marino"));
		
	
	}
	
	@Test
	public void extractMax() throws QueueIsEmptyException {
		setup10();
		queue.insertValue(new Instance<Client>(new Client("Marino", "253221", 50)));
		assertTrue(queue.maximun().getName().equals("Marino"));
		assertTrue(queue.extract_max().getName().equals("Marino"));
		try {
			queue.extract_max();
			fail();
		}catch(QueueIsEmptyException e) {}
	
	}
	
	@Test
	public void extractMax2() throws QueueIsEmptyException {
		setup9();
		assertTrue(queue.extract_max().getName().equals("Carlos Marti"));
	}
	
	@Test
	public void extractMax3() throws QueueIsEmptyException {
		setup10();
		queue.insertValue(new Instance<Client>(new Client("Marino", "253221", 50)));
		assertTrue(queue.extract_max().getID().equals("253221"));
	}
	
}
