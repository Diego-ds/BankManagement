package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Queue;
import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import model.Client;
class QueueTest {
	
	private Queue<Client> queue;
	
	public void setup5() {
		queue = new Queue<Client>(4);
	}
	
	public void setup3() throws QueueIsAlreadyFullException {
		queue = new Queue<Client>(4);
		queue.enqueue(new Client("Alberto","1233450",0));
		queue.enqueue(new Client("Michael","1223344",0));
		queue.enqueue(new Client("Libertario","6543210",0));
		queue.enqueue(new Client("Yotoko","6523410",0));
	}
	
	@Test
	public void enqueueTest() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup5();
		queue.enqueue(new Client("David Montoya","123456789",0));
		assertTrue(queue.top().getName().equals("David Montoya"));
		queue.enqueue(new Client("Diego Garcia","24253323",0));
		queue.dequeue();
		assertTrue(queue.top().getName().equals("Diego Garcia"));	
	}
	
	@Test
	public void enqueueTest2() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup3();
		try {
			queue.enqueue(new Client("Camilo Quiñonez","372904",0));
			fail("The queue is adding costumer even when its full");
		}catch(QueueIsAlreadyFullException e) {
			
		}	
	}
	
	@Test
	public void enqueueTest3() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		
	}
	
	@Test
	public void dequeueTest() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup5();
		try {
			queue.dequeue();
			fail("the queue dequeue costumer even when its empty");
		}catch(QueueIsEmptyException e) {
			
		}		
	}
	
	@Test
	public void dequeueTest2() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup3();
		Client c = queue.dequeue();
		assertTrue(c.getName().equals("Alberto"));	
	}
	
	@Test
	public void dequeueTest3() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup3();
		for(int i =0;i<4;i++) {
			queue.dequeue();
		}
		assertTrue(queue.top()==null);
	}
	
	@Test
	public void QueueEmptyTest() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup3();
		assertTrue(queue.isEmpty()==false);
	}
	
	@Test
	public void QueueEmptyTest2() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup5();
		assertTrue(queue.isEmpty()==true);
	}
	
	@Test
	public void QueueEmptyTest3() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup5();
		assertTrue(queue.isEmpty()==true);
		queue.enqueue(new Client("Wilson Jaramillo","843965",0));
		assertTrue(queue.isEmpty()==false);
		queue.dequeue();
		assertTrue(queue.isEmpty()==true);
	}
	
	@Test
	public void QueuePeekTest() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup5();
		assertTrue(queue.top()==null);
	}
	
	@Test
	public void QueuePeekTest2() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup3();
		assertTrue(queue.top().getName().equals("Alberto"));
	}
	
	@Test
	public void QueuePeekTest3() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup5();
		assertTrue(queue.top()==null);
		queue.enqueue(new Client("Rodrigo Perez","463224",0));
		assertTrue(queue.top().getName().equals("Rodrigo Perez"));
		queue.dequeue();
		assertTrue(queue.top()==null);
		
	}
	
	
}
