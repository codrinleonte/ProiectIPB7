package bd;

public class UserBD {

	private String tip;
	private int id;
	private String username;
	
	UserBD(){}
	
	UserBD( String tip ){
		this.tip=tip;
	}
	
	public String getTip() {
		return tip;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString(){
		return "[ ID:"+id +", TIP:"+tip+", USERNAME:" +username+" ]";
	}
	
	
}
