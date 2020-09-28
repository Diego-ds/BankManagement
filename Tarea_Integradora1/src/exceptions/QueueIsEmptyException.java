package exceptions;

public class QueueIsEmptyException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public QueueIsEmptyException() {
		super("The queue is empty");
	}
}
