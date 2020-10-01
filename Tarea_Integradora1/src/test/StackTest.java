package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Stack;
import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import model.Client;

class StackTest {
	
	private Stack<Client> stack;
	
	public void setup7() {
		stack = new Stack<Client>(2);
	}
	public void setup6() throws QueueIsAlreadyFullException {
		stack = new Stack<Client>(4);
		stack.apilar(new Client("Carlos Marti","253221",0));
		stack.apilar(new Client("Manuelo Coco","253331",0));
		stack.apilar(new Client("Pepe Willys","830173",0));
		stack.apilar(new Client("Alison Robert","984573",0));
	}
	
	@Test
	public void pushStackTest() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup7();
		stack.apilar(new Client("Carlos Mora","346328",0));
		assertTrue(stack.top().getName().equals("Carlos Mora"));
	}
	
	@Test
	public void pushStackTest2() throws QueueIsAlreadyFullException {
		setup6();
		try {
			stack.apilar(new Client("das","325",0));
			fail("The stack is adding costumers even when its full");
		}catch(QueueIsAlreadyFullException e) {
			
		}
		
	}
	
	@Test
	public void pushStackTest3() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup7();
		stack.apilar(new Client("Carlos Mora","346328",0));
		assertTrue(stack.top().getName().equals("Carlos Mora"));
		stack.desapilar();
		stack.apilar(new Client("Eduardo","131242",0));
		assertTrue(stack.top().getName().equals("Eduardo"));	
	}
	
	@Test
	public void popStackTest() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup6();
		try {
			for(int i=0;i<4;i++) {
				stack.desapilar();
			}
			assertTrue(stack.top()==null);
		}catch(QueueIsEmptyException e) {
			fail();
		}
	}
	
	@Test
	public void popStackTest2() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup7();
		try {
			stack.desapilar();
			fail();
		}catch(QueueIsEmptyException e) {
			
		}
	}
	
	@Test
	public void popStackTest3() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup7();
		try {
			stack.desapilar();
			fail();
		}catch(QueueIsEmptyException e) {
			
		}
		stack.apilar(new Client("Rodrigo Ramos","131244",0));
		try {
			stack.desapilar();
		}catch(QueueIsEmptyException e) {
			fail();
		}
		try {
			stack.desapilar();
			fail();
		}catch(QueueIsEmptyException e) {
			
		}
			
	}
	
	@Test
	public void stackPeekTest() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup7();
		assertTrue(stack.top()==null);
		
	}
	
	@Test
	public void stackPeekTest2() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup6();
		assertTrue(stack.top().getName().equals("Alison Robert"));
		assertTrue(stack.top().getName().equals("Alison Robert"));
	}
	
	@Test
	public void stackPeekTest3() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup7();
		assertTrue(stack.top()==null);
		stack.apilar(new Client("Zion Lopez","323214",0));
		assertTrue(stack.top().getName().equals("Zion Lopez"));
		stack.desapilar();
		assertTrue(stack.top()==null);
	}
	
	@Test
	public void stackEmptyTest() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		setup6();
		assertTrue(stack.isEmpty() == false);
		for(int i=0;i<4;i++) {
			stack.desapilar();
		}
		assertTrue(stack.isEmpty() == true);
		
		setup7();
		assertTrue(stack.isEmpty() == true);
	}
	
	

}
