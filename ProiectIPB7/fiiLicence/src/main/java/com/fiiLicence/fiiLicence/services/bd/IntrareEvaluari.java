package com.fiiLicence.fiiLicence.services.bd;

import java.sql.Timestamp;

public class IntrareEvaluari {
	
	int id;
	int idSesiune;
	int idComisie;
	Timestamp inceputEvaluare;
	Timestamp sfarsitEvaluare;
	String sala;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSesiune() {
		return idSesiune;
	}
	public void setIdSesiune(int idSesiune) {
		this.idSesiune = idSesiune;
	}
	public int getIdComisie() {
		return idComisie;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public void setIdComisie(int idComisie) {
		this.idComisie = idComisie;
	}
	public Timestamp getInceputEvaluare() {
		return inceputEvaluare;
	}
	public void setInceputEvaluare(Timestamp inceputEvaluare) {
		this.inceputEvaluare = inceputEvaluare;
	}
	public Timestamp getSfarsitEvaluare() {
		return sfarsitEvaluare;
	}
	public void setSfarsitEvaluare(Timestamp sfarsitEvaluare) {
		this.sfarsitEvaluare = sfarsitEvaluare;
	}
	
}
