import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-grades',
  templateUrl: './grades.component.html',
  styleUrls: ['./grades.component.css']
})
export class GradesComponent implements OnInit {
    grades = [];
    pagenumber: number = 1;
    pagesize: number = 3;

    constructor(private backendService: BackendService) {}

    getNewPage(){
        this.backendService.getStudentGradeList(Cookie.get('sessionId'), this.pagenumber, this.pagesize).subscribe(
            data => {
                this.grades = data;
                if(this.grades.length == 0){
                    this.pagenumber--;
                    this.getNewPage();
                }
            },
            error => console.log('ERROR: BackendService - getStudentGradeList')
        );
    }

    ngOnInit(){
        this.getNewPage();
    }

    onPrevPageClick(){
        if(this.pagenumber > 1){
            this.pagenumber--;
            this.getNewPage();
        }
    }

    onNextPageClick(){
        this.pagenumber++;
        this.getNewPage();
    }
}
