package exceptions;

public class QueueIsAlreadyFullException extends Exception {

	private static final long serialVersionUID = 1L;

	public QueueIsAlreadyFullException() {
		super("The costumer cant be unqueued because the queue its full");
	}
}
