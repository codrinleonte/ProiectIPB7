
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
}