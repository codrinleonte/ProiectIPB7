import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { MdSnackBar } from '@angular/material';
import { saveAs } from 'file-saver';

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
    hasLicense: number = 0;

    files: FileList = null;

    idUser: number = -1;

    constructor(private backendService: BackendService, private snackBar: MdSnackBar) {}

    ngOnInit() {

        this.backendService.getUserInfo(Cookie.get('sessionId')).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                this.idUser = jsonParsed.idUser;
                this.backendService.hasLicense(Cookie.get('sessionId'), jsonParsed.idUser).subscribe(
                    data => {
                        let jsonParsed = JSON.parse(JSON.stringify(data));
                        if(jsonParsed.response == true)
                            this.hasLicense = 2;
                        else
                            this.hasLicense = 1;
                    },
                    error => console.error('ERROR: BackendService - hasLicense()')
                );
            },
            error => console.error('ERROR: BackendService - getUserInfo()')
        );

        this.backendService.getProfs(Cookie.get('sessionId')).subscribe(
            data => {
                this.profs = data;
            },
            error => console.error('ERROR: BackendService - getProfs()')
        );
    }

    onFilesChanged(event:any){
        console.log(event.target.files);
        this.files = event.target.files;
    }

    onDownloadClick(){
        this.backendService.getLicenseInfo(Cookie.get('sessionId'), this.idUser).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));

                let byteCharacters = atob(jsonParsed.continut);
                let byteNumbers = new Array(byteCharacters.length);
                for(let i = 0; i < byteCharacters.length; i++){
                    byteNumbers[i] = byteCharacters.charCodeAt(i);
                }
                let byteArray = new Uint8Array(byteNumbers);

                let file = new Blob([byteArray], { type: 'application/octet-stream' });
                saveAs(file, jsonParsed.numeLucrare + '.zip')
            },
            error => console.error('ERROR: BackendService - getLicenseInfo()')
        );
    }

    onSubmitClick(){
        if(this.licenceTitle == '' || this.selectedType == '' || this.selectedIdProf == null){
            this.snackBar.open("Toate campurile trebuie sa fie completate!", '', {duration: 2000});
            return;
        }

        if(this.files == null){
            this.snackBar.open("Nu s-a selectat nici un fisier pentru uploadare!", '', {duration: 2000});
            return;
        }

        if(this.files.length == 0){
            this.snackBar.open("Nu s-a selectat nici un fisier pentru uploadare!", '', {duration: 2000});
            return;
        }

        if(this.files.length > 1){
            this.snackBar.open("Nu se poate uploada decat un singur fisier!", '', {duration: 2000});
            return;
        }

        if(this.files[0].type != 'application/x-zip-compressed'){
            this.snackBar.open("Se pot uploada doar fisiere .zip!", '', {duration: 2000});
            return;
        }

        let reader = new FileReader();
        reader.onload = this.fileReaderLoadHandler.bind(this);
        reader.readAsBinaryString(this.files[0]);
    }

    fileReaderLoadHandler(event: any){
        let binaryString = event.target.result;
        let fileData = btoa(binaryString);

        this.backendService.recordLicence(Cookie.get('sessionId'), this.licenceTitle, this.selectedType, this.selectedIdProf).subscribe(
            data => {
                let jsonParsed = JSON.parse(JSON.stringify(data));
                if(jsonParsed.response == true){
                    if(this.idUser != -1){
                        // Upload license
                        this.backendService.uploadLicense(Cookie.get('sessionId'), this.idUser, fileData).subscribe(
                            data => {
                                let jsonParsed = JSON.parse(JSON.stringify(data));
                                if(jsonParsed.response == true){
                                    this.hasLicense = 2;
                                }
                                else{
                                    this.snackBar.open("Eroare la uploadarea licentei!" + this.selectedType, '', {duration: 2000});
                                }
                            },
                            error => console.log('ERROR: BackendService - uploadLicense()')
                        );
                    }
                    else{
                        this.snackBar.open("Eroare fatala!" + this.selectedType, '', {duration: 2000});
                    }
                }
                else {
                    this.snackBar.open("Nu s-a uploadat (lucrare deja uploadata?)" + this.selectedType, '', {duration: 2000});
                }
            },
            error => console.error('ERROR: BackendService - recordLicence()')
        );
    }
}
