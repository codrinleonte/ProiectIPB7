import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { BackendService } from "../../backend.service";

@Component({
  selector: 'app-activation',
  templateUrl: './activation.component.html',
  styleUrls: ['./activation.component.css']
})
export class ActivationComponent implements OnInit {

    activationStatus = 2;
    activationCode: string = '';

    constructor(private activatedRoute: ActivatedRoute, private backendService: BackendService) { }

    ngOnInit() {
        this.activatedRoute.queryParams.subscribe(params => { this.activationCode = params['activate']});

        this.backendService.activate(this.activationCode).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                if(jsonParsed.response == true){
                    this.activationStatus = 1;
                }
            },
            error => console.error('ERROR: BackendService - activate()')
        );
    }

}
