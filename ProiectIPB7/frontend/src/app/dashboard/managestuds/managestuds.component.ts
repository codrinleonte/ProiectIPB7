import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { MdSnackBar } from '@angular/material';

@Component({
  selector: 'app-managestuds',
  templateUrl: './managestuds.component.html',
  styleUrls: ['./managestuds.component.css']
})
export class ManagestudsComponent implements OnInit {
    students = [];
    addStudentEmail: string = '';

    constructor(private backendService: BackendService, public snackBar: MdSnackBar) {}

    getStudentsGuided(){
        this.backendService.getStudentsGuided(Cookie.get('sessionId'), 1).subscribe(
            data => { this.students = data; },
            error => console.log('ERROR: BackendService - getStudentsGuided()')
        );
    }

    ngOnInit(){
        this.getStudentsGuided();
    }

    onRemoveStudentClick(event: any){
        this.backendService.removeStudentGuided(Cookie.get('sessionId'), 1, +event.target.id).subscribe(
            data => { this.getStudentsGuided(); },
            error => console.log('ERROR: BackendService - removeStudentGuided()')
        );
    }

    onAddStudentClick(){
        if(this.addStudentEmail == ''){
            this.snackBar.open('Campul email student trebuie completat!', '', {duration: 2000});
            return;
        }

        this.backendService.addStudentGuided(Cookie.get('sessionId'), 1, this.addStudentEmail).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                if(jsonParsed.response == true){
                    this.getStudentsGuided()
                }
                else{
                    this.snackBar.open('Nu s-a putut adauga studentul cu acest email!', '', {duration: 2000});
                }
            },
            error => console.log('ERROR: BackendService - addStudentGuided()')
        );
    }
}
