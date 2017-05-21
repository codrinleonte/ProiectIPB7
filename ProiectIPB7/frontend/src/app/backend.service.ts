
import 'rxjs/Rx';
import { Injectable } from "@angular/core";
import { Http, Headers } from "@angular/http";

@Injectable()
export class BackendService {
    constructor(private http : Http) {}

    register(email: string, password: string){
        let header = new Headers();
        header.append('Content-Type', 'application/json');

        let json = JSON.stringify({ email: email, password: password });
        return this.http.post('http://localhost:4500/registration', json, { headers: header }).map(res => res.json());
    }

    activate(token: string){
        let header = new Headers();
        header.append('Content-Type', 'application/json');

        let json = JSON.stringify({ confirmToken: token });
        return this.http.post('http://localhost:4500/confirmregistration', json, { headers: header }).map(res => res.json());
    }

    login(email: string, password: string){
        let header = new Headers();
        header.append('Content-Type', 'application/json');

        let json = JSON.stringify({ email: email, password: password });
        return this.http.post('http://localhost:4500/login', json, { headers: header }).map(res => res.json());
    }

    getUserInfo(token: string){
        let header = new Headers();
        header.append('Content-Type', 'application/json');
        header.append('Authorization', token);

        return this.http.get('http://localhost:4500/userinfo', { headers: header }).map(res => res.json());
    }

    getProfs(token: string){
        let header = new Headers();
        header.append('Content-Type', 'application/json');
        header.append('Authorization', token);

        return this.http.get('http://localhost:4500/profesorlist', { headers: header }).map(res => res.json());
    }

    getProfsWithoutComitte(token: string){
        let header = new Headers();
        header.append('Content-Type', 'application/json');
        header.append('Authorization', token);

        return this.http.get('http://localhost:4500/getProfsWithoutCommitte', { headers: header }).map(res => res.json());
    }

    getComitteList(token: string){
        let header = new Headers();
        header.append('Content-Type', 'application/json');
        header.append('Authorization', token);

        return this.http.get('http://localhost:4500/getCommitteList', { headers: header }).map(res => res.json());
    }

    getProfsFromComitte(token: string, id: number){
        let header = new Headers();
        header.append('Content-Type', 'application/json');
        header.append('Authorization', token);

        let json = JSON.stringify({ id: id });
        return this.http.post('http://localhost:4500/getProfsFromCommitte', json, { headers: header }).map(res => res.json());
    }

    recordLicence(token: string, title: string, description: string, idProf: number){
        let header = new Headers();
        header.append('Content-Type', 'application/json');
        header.append('Authorization', token);

        let json = JSON.stringify({ nameOfLicence: title, idProfesor: idProf, descriptionOfLicence: description });
        return this.http.post('http://localhost:4500/recordlicence', json, { headers: header }).map(res => res.json());
    }
}