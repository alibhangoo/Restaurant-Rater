import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs/Observable'
import { Login } from '../models/login.model';
import {Restaurant} from '../models/Restaurant.model';
import {Location} from '../models/Location.model';


@Injectable()
export class QueriesService {
    constructor(private http: HttpClient){}

    public queryA(restaurantid : string): Observable<any> {
        return this.http.get('http://localhost:8080/restaurant?id='+ restaurantid);
    }

    public queryB(restaurantid : string): Observable<any> {
        return this.http.get('http://localhost:8080/menuitems?restaurant='+ restaurantid);
    }

    public queryC(category:string): Observable<any>{
        return this.http.get('http://localhost:8080/manager?type='+category)

    }


}
