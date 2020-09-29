package exceptions;

@SuppressWarnings("serial")
public class QueueIsEmptyException extends Exception{
	public QueueIsEmptyException(String structure) {
		super("The "+structure+ " is empty");
	}
}
