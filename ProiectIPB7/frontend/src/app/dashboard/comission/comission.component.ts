import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../backend.service";
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-comission',
  templateUrl: './comission.component.html',
  styleUrls: ['./comission.component.css', './dragula.min.css']
})
export class ComissionComponent implements OnInit {

    comittes: any = [];
    profs: any = [];
    profs_without_comitte: any = [];

    constructor(private backendService: BackendService) { }

    getProfById(id){
        for(var i = 0; i < this.profs.length; i++){
            if(this.profs[i].id == id) {
                return this.profs[i];
            }
        }
    }

    getUnassignedProfs(){
        var index = 0;
        this.backendService.getProfsWithoutComitte(Cookie.get('sessionId')).subscribe(
            data => {
                for(var i = 0; i < data.length; i++){
                    this.profs_without_comitte[index++] = this.getProfById(data[i].id);
                }
            },
            error => console.error('ERROR: BackendService - getProfsWithoutComitte()')
        );
    }

    getProfsFromComittes(i: number){
        if(i < this.comittes.length) {
            this.backendService.getProfsFromComitte(Cookie.get('sessionId'), this.comittes[i].id).subscribe(
                data => {
                    var index = 0;
                    for(var j = 0; j < data.length; j++){
                        this.comittes[i].profs[index++] = this.getProfById(data[j].id);
                    }
                    this.getProfsFromComittes(i+1);
                },
                error => console.error('ERROR: BackendService - getProfsFromComitte()')
            );
        }
    }

    getComittes(){
        this.backendService.getComitteList(Cookie.get('sessionId')).subscribe(
            data => {
                this.comittes = data;
                for(var i = 0; i < this.comittes.length; i++){
                    this.comittes[i].profs = [];
                }
                this.getProfsFromComittes(0);
            },
            error => console.error('ERROR: BackendService - getComitteLest()')
        );
    }

    ngOnInit() {
        this.backendService.getProfs(Cookie.get('sessionId')).subscribe(
            data => {
                this.profs = data;
                this.getUnassignedProfs();
                this.getComittes();
            },
            error => console.error('ERROR: BackendService - getProfs()')
        );
    }
}
