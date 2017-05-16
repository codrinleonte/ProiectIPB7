package com.fiiLicence.fiiLicence.models.old;

import com.fiiLicence.fiiLicence.models.old.AccessRights;
import com.fiiLicence.fiiLicence.models.old.Committee;
import com.fiiLicence.fiiLicence.models.old.Student;
import com.fiiLicence.fiiLicence.models.old.Teacher;

import java.util.*;

public class StudentRights extends AccessRights {
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
