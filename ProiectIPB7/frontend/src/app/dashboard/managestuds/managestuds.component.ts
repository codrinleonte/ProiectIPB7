import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-managestuds',
  templateUrl: './managestuds.component.html',
  styleUrls: ['./managestuds.component.css']
})
export class ManagestudsComponent implements OnInit {
    students = [];

    constructor(private backendService: BackendService) {}

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
}
