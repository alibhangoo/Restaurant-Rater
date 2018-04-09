import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs/Observable'
import { Login } from '../models/login.model';
import { Register } from '../models/register.model';

@Injectable()
export class RaterServices {
    constructor(private http: HttpClient){}

    /*public makeData(obj: any): Observable<any>{
        return this.http.post(dbroot + '.json', obj);
    }*/

    public login(login: Login): Observable<any> {
        return this.http.post('http://localhost:8080/login', login)
    }

    public register(register: Register): Observable<any> {
        return this.http.post('http://localhost:8080/register', register)
    }

    public delete(username: string): Observable<any> {
        return this.http.post('http://localhost:8080/user/delete', username)
    }
    
}