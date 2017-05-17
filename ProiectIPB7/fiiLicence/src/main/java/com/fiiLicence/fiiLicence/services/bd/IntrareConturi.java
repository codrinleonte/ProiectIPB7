package com.fiiLicence.fiiLicence.services.bd;

public class IntrareConturi {

	private int id;
	private String username;
	private String hashparola;
	private String email;
	private String tipUtilizator;
	private int    status;
	private String codActivare;
	
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
	
	public String getTipUtilizator() {
		return tipUtilizator;
	}
	
	public void setTipUtilizator(String tipUtilizator) {
		this.tipUtilizator = tipUtilizator;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getCodActivare() {
		return codActivare;
	}
	
	public void setCodActivare(String codActivare) {
		this.codActivare = codActivare;
	}
	
	@Override
	public String toString(){
		return "( ID:"+id+", Username:"+username+", hash parola:"+hashparola+", cod_activare:"+codActivare +" )";
	}
	
	
}
