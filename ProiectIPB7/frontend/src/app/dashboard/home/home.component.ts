import { Component } from '@angular/core';
import { GradeDialogComponent } from "../grade-dialog/grade-dialog.component";
import { MdDialog } from '@angular/material';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

    userClass = 1;

    constructor(public dialog: MdDialog) {}

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
}
