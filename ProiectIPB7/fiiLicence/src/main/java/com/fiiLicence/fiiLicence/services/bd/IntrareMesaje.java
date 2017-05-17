package com.fiiLicence.fiiLicence.services.bd;

public class IntrareMesaje {

	int id;
	int idEmitator;
	int idDestinatar;
	String mesaj;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	public int getIdEmitator() {
		return idEmitator;
	}
	
	public void setIdEmitator(int idEmitator) {
		this.idEmitator = idEmitator;
	}
	
	public int getIdDestinatar() {
		return idDestinatar;
	}

	public void setIdDestinatar(int idDestinatar) {
		this.idDestinatar = idDestinatar;
	}
	
	@Override
	public String toString(){
		return "( ID:" + id +", Emitator:"+idEmitator+", Destinatar:"+idDestinatar+", Mesaj:"+mesaj+" )";
	}
	
	
}
