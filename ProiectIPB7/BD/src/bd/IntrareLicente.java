package bd;

import java.sql.Timestamp;

public class IntrareLicente {
	int id;
	String titlu;
	int idProfesor;
	int idStudent;
	String materialeLicenta;
	int idSesiune;
	int tipLucrare;
	int idComisie;
	int nota1Oral;
	int nota1Proiect;
	int nota2Oral;
	int nota2Proiect;
	int nota3Oral;
	int nota3Proiect;
	int nota4Oral;
	int nota4Proiect;
	Timestamp dataOraSustinerii;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getMaterialeLicenta() {
		return materialeLicenta;
	}
	public void setMaterialeLicenta(String materialeLicenta) {
		this.materialeLicenta = materialeLicenta;
	}
	public int getIdSesiune() {
		return idSesiune;
	}
	public void setIdSesiune(int idSesiune) {
		this.idSesiune = idSesiune;
	}
	public int getTipLucrare() {
		return tipLucrare;
	}
	public void setTipLucrare(int tipLucrare) {
		this.tipLucrare = tipLucrare;
	}
	public int getIdComisie() {
		return idComisie;
	}
	public void setIdComisie(int idComisie) {
		this.idComisie = idComisie;
	}
	public int getNota1Oral() {
		return nota1Oral;
	}
	public void setNota1Oral(int nota1Oral) {
		this.nota1Oral = nota1Oral;
	}
	public int getNota1Proiect() {
		return nota1Proiect;
	}
	public void setNota1Proiect(int nota1Proiect) {
		this.nota1Proiect = nota1Proiect;
	}
	public int getNota2Oral() {
		return nota2Oral;
	}
	public void setNota2Oral(int nota2Oral) {
		this.nota2Oral = nota2Oral;
	}
	public int getNota2Proiect() {
		return nota2Proiect;
	}
	public void setNota2Proiect(int nota2Proiect) {
		this.nota2Proiect = nota2Proiect;
	}
	public int getNota3Oral() {
		return nota3Oral;
	}
	public void setNota3Oral(int nota3Oral) {
		this.nota3Oral = nota3Oral;
	}
	public int getNota3Proiect() {
		return nota3Proiect;
	}
	public void setNota3Proiect(int nota3Proiect) {
		this.nota3Proiect = nota3Proiect;
	}
	public int getNota4Oral() {
		return nota4Oral;
	}
	public void setNota4Oral(int nota4Oral) {
		this.nota4Oral = nota4Oral;
	}
	public int getNota4Proiect() {
		return nota4Proiect;
	}
	public void setNota4Proiect(int nota4Proiect) {
		this.nota4Proiect = nota4Proiect;
	}
	public Timestamp getDataOraSustinerii() {
		return dataOraSustinerii;
	}
	public void setDataOraSustinerii(Timestamp dataOraSustinerii) {
		this.dataOraSustinerii = dataOraSustinerii;
	}
}