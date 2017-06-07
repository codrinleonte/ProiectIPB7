import { Component } from '@angular/core';
import { GradeDialogComponent } from "../grade-dialog/grade-dialog.component";
import { MdDialog } from '@angular/material';
import { BackendService } from "app/backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';

declare var jsPDF: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

    userClass = 1;

    constructor(public dialog: MdDialog, private backendService: BackendService) {}

    onStudentCPClick(){
        this.userClass = 1;
    }

    onProfesorCPClick(){
        this.userClass = 2;
    }

    onSecretarCPClick(){
        this.userClass = 3;
    }

    onAdminCPClick(){
        this.userClass = 4;
    }

    openMyGradeDialog() {
        this.dialog.open(GradeDialogComponent, { width: '525px', height: '210px'});
    }

    generateGradesPdf(){
        let doc = new jsPDF('p', 'pt');
        let columns = ['Nume', 'Prenume', 'Nota Finala'];
        let rows = [];

        this.backendService.getStudentGradeList(Cookie.get('sessionId'), 1, 1000).subscribe(
            data => {
                for(let i = 0; i < data.length; i++){
                    let nota;
                    if(data[i].notaFinala == -1 || data[i].notaFinala == 0){
                        nota = 'Fara nota';
                    }
                    else {
                        nota = data[i].notaFinala;
                    }

                    rows.push([data[i].numeStudent, data[i].prenumeStudent, nota]);
                }

                doc.autoTable(columns, rows);
                doc.save('grades.pdf');
            },
            error => console.log('ERROR: BackendService - getStudentGradeList()')
        );
    }

    generateRepartitionPdf(){
        let doc = new jsPDF('p', 'pt');
        let columns = ['Nume', 'Prenume', 'Ora', 'Data', 'Sala'];
        let rows = [['No Data', 'No Data', 'No Data', 'No Data', 'No Data'],
            ['No Data', 'No Data', 'No Data', 'No Data', 'No Data'],
            ['No Data', 'No Data', 'No Data', 'No Data', 'No Data']];

        doc.autoTable(columns, rows);
        doc.save('repartition.pdf');
    }
}
