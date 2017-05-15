package bd;

public class Account {

	private int id;
	private String username;
	private String hashparola;
	private String email;
	private String tip;
	private boolean status;
	private String cod_activare;
	
	public int getID() {
		return id;
	}
	
	public void setID(int iD) {
		id = iD;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getHashparola() {
		return hashparola;
	}
	
	public void setHashparola(String hashparola) {
		this.hashparola = hashparola;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTip() {
		return tip;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getCod_activare() {
		return cod_activare;
	}
	public void setCod_activare(String cod_activare) {
		this.cod_activare = cod_activare;
	}
	
	@Override
	public String toString(){
		return (id+" "+username+' '+email+' '+hashparola+' '+tip+' '+status+' '+cod_activare);
	}
	
	
}
