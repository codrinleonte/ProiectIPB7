import { Component, OnInit } from '@angular/core';
import { BackendService } from "../backend.service";
import { MdSnackBar } from '@angular/material';
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
    emailTextBox: string = '';
    passwordTextBox: string = '';

    constructor(private backendService: BackendService, public snackBar: MdSnackBar, private router: Router) {}

    ngOnInit(){
        if(Cookie.get('sessionId') != null){
            this.router.navigateByUrl('');
        }
    }

    onLoginClick(){
        if(this.emailTextBox == '' || this.passwordTextBox == ''){
            this.snackBar.open('Toate campurile trebuie completate!', '', {duration: 2000});
            return;
        }

        /*if(this.emailTextBox.indexOf('@info.uaic.ro') == -1) {
            this.snackBar.open('Email-ul trebuie sa fie cel furnizat de facultate! (ex: prenume.nume@info.uaic.ro)', '', {duration: 2000});
            return;
        }*/

        this.backendService.login(this.emailTextBox, this.passwordTextBox).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                if(jsonParsed.token != ''){
                    Cookie.set('sessionId', jsonParsed.token);
                    this.router.navigateByUrl('');
                }
                else{
                    this.snackBar.open('Email sau parola incorecta!', '', {duration: 2000});
                }
            },
            error => console.error('ERROR: BackendService - login()')
        );
    }
}
