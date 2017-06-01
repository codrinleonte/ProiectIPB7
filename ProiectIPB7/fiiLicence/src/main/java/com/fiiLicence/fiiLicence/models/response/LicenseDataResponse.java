package com.fiiLicence.fiiLicence.models.response;

import java.util.List;

public class LicenseDataResponse {
	String numeLucrare;
	String tip;
	String coordonator;
	byte[] continut;
	public String getNumeLucrare() {
		return numeLucrare;
	}
	public void setNumeLucrare(String numeLucrare) {
		this.numeLucrare = numeLucrare;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getCoordonator() {
		return coordonator;
	}
	public void setCoordonator(String coordonator) {
		this.coordonator = coordonator;
	}
	public byte[] getContinut() {
		return continut;
	}
	public void setContinut(byte[] continut) {
		this.continut = continut;
	}

}
