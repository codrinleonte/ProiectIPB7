import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

    firstname: string = '';
    lastname: string = '';
    email: string = '';
    account_class: string = '';

    constructor(private backendService: BackendService) { }

    ngOnInit() {
        this.backendService.getUserInfo(Cookie.get('sessionId')).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                this.firstname = jsonParsed.nume;
                this.lastname = jsonParsed.prenume;
                this.email = jsonParsed.email;
                this.account_class = jsonParsed.tip;
            },
            error => console.error('ERROR: BackendService - getUserInfo()')
        );
    }
}
