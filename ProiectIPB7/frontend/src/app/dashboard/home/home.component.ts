import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

    userClass = 1;

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
}
