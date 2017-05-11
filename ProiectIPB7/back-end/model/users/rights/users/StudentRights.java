package model.users.rights.users;

import model.committee.Committee;
import model.users.rights.AccessRights;
import model.users.types.Student;
import model.users.types.Teacher;

import java.util.*;
public class StudentRights extends AccessRights {

    // TODO Implements all the actions a Student might take in this class( addLinkToProject(String link) etc. )

	
	

	public Map<String,Double> getMarksOfStudents(Vector<Committee> Com){
		Map <String, Double> result = new HashMap <String, Double>();
		for (Committee committee : Com) {
			for (Teacher teacher : committee.getTeachers()) {
				for(Student student : teacher.getCoordinatedStudents()){
										
					
					result.put(student.getName(),student.getMark().finalMark());
				}
			}
		}
		return result;
	}
}
