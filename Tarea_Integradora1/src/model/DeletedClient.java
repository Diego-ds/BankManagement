package model;

public class DeletedClient extends Client {

	private String reason;
	
	public DeletedClient(String name, String iD, int priority, String reason) {
		super(name, iD, priority);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}
	
	
}
