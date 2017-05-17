package com.fiiLicence.fiiLicence.services.bd;

public class IntrareComisii {
	int id;
	int idProfSef;
	int idProf2;
	int idProf3;
	int idProf4;
	int idSecretar;
	String tipComisie;
	String numeComisie;
	int idEvaluare;
	String dataEvaluare;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getIdProfSef() {
		return idProfSef;
	}
	public void setIdProfSef(int idProfSef) {
		this.idProfSef = idProfSef;
	}
	public int getIdProf2() {
		return idProf2;
	}
	public void setIdProf2(int idProf2) {
		this.idProf2 = idProf2;
	}
	public int getIdProf3() {
		return idProf3;
	}
	public void setIdProf3(int idProf3) {
		this.idProf3 = idProf3;
	}
	public int getIdProf4() {
		return idProf4;
	}
	public void setIdProf4(int idProf4) {
		this.idProf4 = idProf4;
	}
	public int getIdSecretar() {
		return idSecretar;
	}
	public void setIdSecretar(int idSecretar) {
		this.idSecretar = idSecretar;
	}
	public String getTipComisie() {
		return tipComisie;
	}
	public void setTipComisie(String tipComisie) {
		this.tipComisie = tipComisie;
	}
	public String getNumeComisie() {
		return numeComisie;
	}
	public void setNumeComisie(String numeComisie) {
		this.numeComisie = numeComisie;
	}
	public int getIdEvaluare() {
		return idEvaluare;
	}
	public void setIdEvaluare(int idEvaluare) {
		this.idEvaluare = idEvaluare;
	}
	public String getDataEvaluare() {
		return dataEvaluare;
	}
	public void setDataEvaluare(String dataEvaluare) {
		this.dataEvaluare = dataEvaluare;
	}
	@Override
	public String toString() {
		return "IntrareComisii [id=" + id + ", idProfSef=" + idProfSef + ", idProf2=" + idProf2 + ", idProf3=" + idProf3
				+ ", idProf4=" + idProf4 + ", idSecretar=" + idSecretar + ", tipComisie=" + tipComisie + ", idEvaluare="
				+ idEvaluare + "]";
	}
	
	

}
