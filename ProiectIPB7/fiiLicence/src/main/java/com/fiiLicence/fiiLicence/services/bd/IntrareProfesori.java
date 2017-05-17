package com.fiiLicence.fiiLicence.services.bd;

public class IntrareProfesori {
	
	private int id;
	private int idCont;
	private String nume;
	private String prenume;
	private String gradDidactic;
	private int idComisie;
	private String functieComisie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdCont() {
		return idCont;
	}
	public void setIdCont(int idCont) {
		this.idCont = idCont;
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	
	public String getGradDidactic() {
		return gradDidactic;
	}
	public void setGradDidactic(String gradDidactic) {
		this.gradDidactic = gradDidactic;
	}
	
	public int getIdComisie() {
		return idComisie;
	}
	public void setIdComisie(int idComisie) {
		this.idComisie = idComisie;
	}
	
	public String getFunctieComisie() {
		return functieComisie;
	}
	public void setFunctieComisie(String functieComisie) {
		this.functieComisie = functieComisie;
	}
	
	@Override
	public String toString(){
		return "( ID:"+id+", Nume:"+nume+", Prenume:"+prenume+", Comisie:"+idComisie+" )";
	}
	

}
