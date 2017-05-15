package model.session;
import java.sql.Timestamp;

public class Session 
{
	private int id;
	private Timestamp start;
	private Timestamp end;

	public void setId( int id){
		this.id=id;
	}
	
	public void setStart( Timestamp start ){
		this.start=start;
	}
	
	public void setEnd( Timestamp end ){
		this.end=end;
	}
	
	public int getId(){
		return id;
	}
	
	public Timestamp getStart(){
		return start;
	}
	
	public Timestamp getEnd(){
		return end;
	}
}
