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

    types = [
        { name: 'Licenta' },
        { name: 'Diseratie' }
    ];
    profs = [];
    licenceTitle: string = '';
    selectedIdProf: number;
    selectedType: string = '';

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
        this.backendService.recordLicence(Cookie.get('sessionId'), this.licenceTitle, this.selectedType, this.selectedIdProf).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                if(jsonParsed.response == true){
                    this.snackBar.open("Lucrarea a fost uplodata!", '', {duration: 2000});
                }
                else {
                    this.snackBar.open("Nu s-a uploadat (lucrare deja uploadata?)" + this.selectedType, '', {duration: 2000});
                }
            },
            error => console.error('ERROR: BackendService - recordLicence()')
        );
    }
}
