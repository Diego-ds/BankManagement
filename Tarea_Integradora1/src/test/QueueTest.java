package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Queue;
import exceptions.QueueIsAlreadyFullException;
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
	public void test() {
		fail("Not yet implemented");
	}

}
