package model.committee;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import model.users.types.Secretary;
import model.users.types.Teacher;

public class Committee {

	private int id;
	private Secretary       secretary;
	private Vector<Teacher> teachers;
	private Timestamp       start;
	private Timestamp       end;
	private String          tip;
	
	

}
