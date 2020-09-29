package exceptions;

@SuppressWarnings("serial")
public class QueueIsAlreadyFullException extends Exception {

	public QueueIsAlreadyFullException(String structure) {
		super("The costumer cant be added because the " + structure+ " is full");
	}
}
