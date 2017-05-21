import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { MdSnackBar } from '@angular/material';

@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.css']
})
export class SubmitComponent implements OnInit {

    profs = [];
    licenceTitle: string = '';
    licenceDescription: string = '';
    selectedIdProf: number;

    constructor(private backendService: BackendService, private snackBar: MdSnackBar) {}

    ngOnInit() {
        this.backendService.getProfs(Cookie.get('sessionId')).subscribe(
            data => {
                this.profs = data;
            },
            error => console.error('ERROR: BackendService - getProfs()')
        );
    }

    onSubmitClick(){
        this.backendService.recordLicence(Cookie.get('sessionId'), this.licenceTitle, this.licenceDescription, this.selectedIdProf).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                if(jsonParsed.response == true){
                    this.snackBar.open("A mers totu bine, cred!", '', {duration: 2000});
                }
                else {
                    this.snackBar.open("Eroare la uploadarea licentei!", '', {duration: 2000});
                }
            },
            error => console.error('ERROR: BackendService - recordLicence()')
        );
        this.snackBar.open(this.licenceTitle + ' ' + this.licenceDescription + ' ' + this.selectedIdProf, '', {duration: 2000});
    }
}
