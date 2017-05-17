package com.fiiLicence.fiiLicence.models.old;

import com.fiiLicence.fiiLicence.models.old.AccessRights;

/*import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import static javax.swing.text.StyleConstants.FontFamily;
import static sun.plugin.javascript.navig.JSType.Document;*/

public class SecretaryRights extends AccessRights {
    public SecretaryRights() {
        super();
    }/*1 sec

    public Vector<Student> examinedStudents(Committee c) {
        Vector<Student> examinedStudents = new Vector<Student>();
        for (Teacher t : c.getCoordinators()) {
            examinedStudents.addAll(t.getCoordinatedStudents());
        }
        return examinedStudents;
    }


    public Vector<StudentMark> viewFinalMarks() {
        Vector<StudentMark> finalMarksList = new Vector<StudentMark>();
        // finalMarksList=DaoObject.getMarksList();
        return finalMarksList;
    }

    public void setCommittee(Secretary s, Committee c) {
        c.setSecretary(s);
    }

    public void assignCommitteeToTeacher(Committee c, Teacher t) {
        Vector<Teacher> currentTeacherList = c.getTeachers();
        currentTeacherList.add(t);
        c.setTeachers(currentTeacherList);
    }

    public void modifyStudentMark(Student s, Integer newMrk) {
        // call method from Dao class that modify a StudentMark with newMrk
    }


    public void proposeStudentTeacherArrangement(Vector<Committee> committeeList, Vector<Teacher> coordinatesList,
                                                 int examType) {
        Vector<Student> studentsList = new Vector<Student>();

        Collections.sort(coordinatesList, Collections.reverseOrder());
        for (Teacher t : coordinatesList) {
            studentsList.addAll(t.getCoordinatedStudents());
            //System.out.println(t.getCoordinatedStudents().size());
        }

        int idealNumberOfStudentsPerCommittee = (int) Math.floor(studentsList.size() / committeeList.size()) + coordinatesList.lastElement().getNumberOfStudents() - 2;
        if (examType == 0) { // license examination


            for (Teacher t : coordinatesList) {
                for (Committee c : committeeList) {
                    if (idealNumberOfStudentsPerCommittee >= this.examinedStudents(c).size() + t.getNumberOfStudents()) {
                        c.getCoordinators().add(t);
                        break;
                    }
                }

            }

        }

    }


    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

    public void generateProgrammedStudentsPDFReport(String fileName) {

        Document doc = new Document();
        try {
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            desktopPath.replace("\\", "/");
            PdfWriter.getInstance(doc, new FileOutputStream(desktopPath + fileName + ".pdf"));
            doc.open();
            doc.addTitle("Lista Studenti : ");
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

            Paragraph paragraph = new Paragraph();
            paragraph.add("Lista Studenti :");
            float[] columnWidths = {1.5f, 2f, 5f, 2f};
            PdfPTable table = new PdfPTable(columnWidths);
            // set table width a percentage of the page width
            table.setWidthPercentage(90f);

            //insert column headings
            insertCell(table, "Nume Student", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Coordonator", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Ora", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nume Proiect", Element.ALIGN_CENTER, 1, bfBold12);
            table.setHeaderRows(1);

            //insert an empty row
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);

            //add the PDF table to the paragraph
            paragraph.add(table);
            // add the paragraph to the document
            doc.add(paragraph);
            doc.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void generateDayStudentsMarksPDFReport() {
        Document doc = new Document();
        try {
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            desktopPath.replace("\\", "/");
            PdfWriter.getInstance(doc, new FileOutputStream(desktopPath + "Note ziua x.pdf"));

            doc.open();
            doc.addTitle("Situatie Ziua x : ");
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

            Paragraph paragraph = new Paragraph();
            paragraph.add("Situatie Ziua x :");
            paragraph.add(Chunk.NEWLINE);
            float[] columnWidths = {1.5f, 1.5f, 1.5f, 1f, 1f, 1f, 1f};
            PdfPTable table = new PdfPTable(columnWidths);
            // set table width a percentage of the page width
            table.setWidthPercentage(90f);

            //insert column headings
            insertCell(table, "Nume Student", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Coordonator", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nume Proiect", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nota 1", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nota 2", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nota 3", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Medie", Element.ALIGN_CENTER, 1, bfBold12);

            table.setHeaderRows(1);

            //insert an empty row
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            //add the PDF table to the paragraph
            paragraph.add(table);
            // add the paragraph to the document
            doc.add(paragraph);
            doc.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void generateFinalSituationPDFReport() {
        Document doc = new Document();
        try {
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            desktopPath.replace("\\", "/");
            PdfWriter.getInstance(doc, new FileOutputStream(desktopPath + "Lista Finala.pdf"));

            doc.open();
            doc.addTitle("Lista Finala : ");
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

            Paragraph paragraphEvaluationCommittee = new Paragraph();
            paragraphEvaluationCommittee.add("Presedinte:");
            paragraphEvaluationCommittee.add(Chunk.NEWLINE);
            paragraphEvaluationCommittee.add("Evaluatori:");
            paragraphEvaluationCommittee.add(Chunk.NEWLINE);
            paragraphEvaluationCommittee.add("Secretar:");
            paragraphEvaluationCommittee.add(Chunk.NEWLINE);
            paragraphEvaluationCommittee.add(Chunk.NEWLINE);
            paragraphEvaluationCommittee.add(Chunk.NEWLINE);
            doc.add(paragraphEvaluationCommittee);

            Paragraph paragraphDay1 = new Paragraph();
            paragraphDay1.add("Situatie Ziua 1 :");
            float[] columnWidths = {1.5f, 1.5f, 1.5f, 1f, 1f, 1f, 1f};
            PdfPTable table = new PdfPTable(columnWidths);
            // set table width a percentage of the page width
            table.setWidthPercentage(90f);

            //insert column headings
            insertCell(table, "Nume Student", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Coordonator", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nume Proiect", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nota 1", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nota 2", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Nota 3", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "Medie", Element.ALIGN_CENTER, 1, bfBold12);

            table.setHeaderRows(1);

            //insert an empty row
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            insertCell(table, "", Element.ALIGN_CENTER, 1, bfBold12);
            //add the PDF table to the paragraph
            paragraphDay1.add(table);
            // add the paragraph to the document
            doc.add(paragraphDay1);
            doc.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }*/

}

