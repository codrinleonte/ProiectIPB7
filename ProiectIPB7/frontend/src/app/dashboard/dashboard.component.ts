import { Component, OnInit } from '@angular/core';
import { Cookie } from 'ng2-cookies/ng2-cookies';
import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

    constructor(private router: Router) {}

    ngOnInit() {
        if(Cookie.get('sessionId') == null){
            this.router.navigateByUrl('/login');
        }
    }

    onLogoutClick() {
        Cookie.delete('sessionId');
        this.router.navigateByUrl('/login');
    }
}
