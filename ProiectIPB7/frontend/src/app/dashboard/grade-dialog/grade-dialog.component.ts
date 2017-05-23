import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-grade-dialog',
  templateUrl: './grade-dialog.component.html',
  styleUrls: ['./grade-dialog.component.css']
})
export class GradeDialogComponent implements OnInit {
    grade: number;

    constructor(private backendService: BackendService) {}

    ngOnInit(){
        this.backendService.getStudentGrade(Cookie.get('sessionId'), 4).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                this.grade = jsonParsed.grade;
            },
            error => console.log('ERROR: BackendService - getStudentGrade()')
        );
    }
}
