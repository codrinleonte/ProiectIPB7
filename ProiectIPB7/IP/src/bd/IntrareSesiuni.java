package bd;

import java.sql.Timestamp;

public class IntrareSesiuni {
	
	int id;
	Timestamp inceputSesiune;
	Timestamp sfarsitSesiune;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getInceputSesiune() {
		return inceputSesiune;
	}
	public void setInceputSesiune(Timestamp inceputSesiune) {
		this.inceputSesiune = inceputSesiune;
	}
	public Timestamp getSfarsitSesiune() {
		return sfarsitSesiune;
	}
	public void setSfarsitSesiune(Timestamp sfarsitSesiune) {
		this.sfarsitSesiune = sfarsitSesiune;
	}
	
}
