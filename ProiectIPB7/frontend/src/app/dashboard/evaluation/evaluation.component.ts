import { Component, OnInit } from '@angular/core';
import {BackendService} from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.css']
})
export class EvaluationComponent implements OnInit {
    students = [];

    constructor(private backendService: BackendService) {}

    ngOnInit(){
        this.backendService.getStudentsEvaluatedByCommitte(Cookie.get('sessionId'), 1).subscribe(
            data => { this.students = data; },
            error => console.log('ERROR: BackendService - getStudentsEvaluatedByComitte()')
        );
    }
}
