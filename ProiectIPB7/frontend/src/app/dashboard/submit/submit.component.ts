import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.css']
})
export class SubmitComponent implements OnInit {

    profs = [];

    constructor(private backendService: BackendService) {}

    ngOnInit() {
        this.backendService.getProfs(Cookie.get('sessionId')).subscribe(
            data => {
                this.profs = data;
            },
            error => console.error('ERROR: BackendService - getProfs()')
        );
    }
}
