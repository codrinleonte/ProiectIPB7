import { Component, OnInit } from '@angular/core';
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { Router } from "@angular/router";
import { BackendService } from "../backend.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

    firstname: string = '';
    lastname: string = '';

    constructor(private router: Router, private backendService: BackendService) {}

    ngOnInit() {
        if(Cookie.get('sessionId') == null){
            this.router.navigateByUrl('/login');
        }

        this.backendService.getUserInfo(Cookie.get('sessionId')).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                this.firstname = jsonParsed.nume;
                this.lastname = jsonParsed.prenume;
            },
            error => console.error('ERROR: BackendService - getUserInfo()')
        );
    }

    onLogoutClick() {
        Cookie.delete('sessionId');
        this.router.navigateByUrl('/login');
    }
}
