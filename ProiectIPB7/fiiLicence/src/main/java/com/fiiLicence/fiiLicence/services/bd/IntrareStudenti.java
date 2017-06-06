package com.fiiLicence.fiiLicence.services.bd;


public class IntrareStudenti {

	private int    id;
	private int    idCont;
	private String nrMatricol;
	private String nume;
	private String prenume;
	private int    id_comisie;
	private int    idSesiune;
	
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
	
	public String getNrMatricol() {
		return nrMatricol;
	}
	public void setNrMatricol(String nrMatricol) {
		this.nrMatricol = nrMatricol;
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
	
	public int getIdSesiune() {
		return idSesiune;
	}
	public void setIdSesiune(int idSesiune) {
		this.idSesiune = idSesiune;
	}
	
	@Override
	public String toString(){
		return "( ID:"+id+", Nume:"+nume+", Prenume:"+prenume+", Sesiune:" +idSesiune+" )";
	}
	public int getId_comisie() {
		return id_comisie;
	}
	public void setId_comisie(int id_comisie) {
		this.id_comisie = id_comisie;
	}
	
}
