package exceptions;

@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception{
	
	public InsufficientFundsException() {
		super("Theres no sufficients funds to do the operation");
	}
}
