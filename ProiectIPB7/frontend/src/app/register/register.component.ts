import { Component, OnInit } from '@angular/core';
import { BackendService } from "../backend.service";
import { MdSnackBar } from '@angular/material';
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { Router } from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

    cardMode = 1;
    emailTextBox: string = '';
    passwordTextBox: string = '';
    passwordConfirmTextBox: string = '';

    constructor(private backendService: BackendService, public snackBar: MdSnackBar, private router: Router) {}

    ngOnInit(){
        if(Cookie.get('sessionId') != null){
            this.router.navigateByUrl('');
        }
    }

    onRegisterClick(){
        if(this.emailTextBox == '' || this.passwordTextBox == '' || this.passwordConfirmTextBox == '') {
            this.snackBar.open('Toate campurile trebuie completate!', '', {duration: 2000});
            return;
        }

        if(this.emailTextBox.indexOf('@info.uaic.ro') == -1) {
            this.snackBar.open('Email-ul trebuie sa fie cel furnizat de facultate! (ex: prenume.nume@info.uaic.ro)', '', {duration: 2000});
            return;
        }

        if(this.passwordTextBox != this.passwordConfirmTextBox) {
            this.snackBar.open('Parola si Confirmarea Parolei nu se potrivesc!', '', { duration: 2000 });
            return;
        }

        this.backendService.register(this.emailTextBox, this.passwordTextBox).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                if(jsonParsed.response == true) {
                    this.cardMode = 2;
                }
                else{
                    this.snackBar.open('Adresa de email deja exista sau este invalida!', '', { duration: 2000 });
                }
            },
            error => console.error('ERROR: BackendService - register()')
        );
    }
}
