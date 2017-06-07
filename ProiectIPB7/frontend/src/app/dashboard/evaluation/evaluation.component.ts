import { Component, OnInit } from '@angular/core';
import {BackendService} from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { MdSnackBar } from '@angular/material';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.css']
})
export class EvaluationComponent implements OnInit {
    students = [];
    oralValues = [];
    proiectValues = [];

    constructor(private backendService: BackendService, public snackBar: MdSnackBar) {}

    ngOnInit(){
        this.backendService.getStudentsEvaluatedByCommitte(Cookie.get('sessionId'), 1).subscribe(
            data => {
                this.students = data;
                for(let i = 0; i < this.students.length; i++){
                    this.backendService.hasLicense(Cookie.get('sessionId'), this.students[i].idStudent).subscribe(
                        data => {
                            let jsonParsed = JSON.parse(JSON.stringify(data));
                            this.students[i].hasLicense = jsonParsed.response;
                        },
                        error => console.error('ERROR: BackendService - hasLicense()')
                    );
                }
            },
            error => console.log('ERROR: BackendService - getStudentsEvaluatedByComitte()')
        );
    }

    onSaveGradeBtnClick(idStudent: number){
        if(this.oralValues[idStudent] == null || this.proiectValues[idStudent] == null) {
            this.snackBar.open('Nota oral si nota proiect trebuie sa fie completate!', '', {duration: 2000});
            return;
        }

        this.backendService.setGrade(Cookie.get('sessionId'), idStudent, 1, this.oralValues[idStudent], this.proiectValues[idStudent]).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                if(jsonParsed.response == true){
                    this.snackBar.open('Nota a fost salvata!', '', {duration: 2000});
                }
                else{
                    this.snackBar.open('Eroare la salvarea notei!', '', {duration: 2000});
                }
            },
            error => console.error('ERROR: BackendService - setGrade()')
        );
    }

    onDownloadLicenseClick(idStudent: any){
        this.backendService.getLicenseInfo(Cookie.get('sessionId'), idStudent).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));

                let byteCharacters = atob(jsonParsed.continut);
                let byteNumbers = new Array(byteCharacters.length);
                for(let i = 0; i < byteCharacters.length; i++){
                    byteNumbers[i] = byteCharacters.charCodeAt(i);
                }
                let byteArray = new Uint8Array(byteNumbers);

                let file = new Blob([byteArray], { type: 'application/octet-stream' });
                saveAs(file, jsonParsed.numeLucrare + '.zip')
            },
            error => console.error('ERROR: BackendService - getLicenseInfo()')
        );
    }
}
