package model.messages;

public class Message {
	
	private int id;
	private String fromUsername;
	private String toUsername;
	
	Message(){}

	public void setId( int id ){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setFrom( String from ){
		this.fromUsername = from;
	}
	
	public String getFrom(){
		return fromUsername;
	}
	
	public void setTo( String to ){
		this.fromUsername = to;
	}
	
	public String getTo(){
		return toUsername;
	}
}
