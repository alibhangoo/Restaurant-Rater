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
    public queryD(id : string): Observable<any> {
        return this.http.get('http://localhost:8080/expensiveItem?restaurant=' + id);
    }

    public queryF(): Observable<any> {
        return this.http.get('http://localhost:8080/totalRatings');
    }

    public queryG(): Observable<any> {
        return this.http.get('http://localhost:8080/notRatedJuly2015');
    }
    public queryE(): Observable<any>{
        return this.http.get('http://localhost:8080/averagePrices');
    }

    public queryH(userid: string): Observable<any>{
        return this.http.get('http://localhost:8080/staffRatingLowerThan?user='+userid);
    }

    public queryJ(category: string): Observable<any>{
        return this.http.get('http://localhost:8080/morePopular?type='+category);
    }

    public queryI(userid: string): Observable<any>{
        return this.http.get('http://localhost:8080/highestFoodRating?type='+userid);
    }

    public queryK(): Observable<any>{
        return this.http.get('http://localhost:8080/highestOverallRating1');
    }

    public queryL(): Observable<any>{
        return this.http.get('http://localhost:8080/highestOverallRating2');
    }

    public queryN(): Observable<any>{
        return this.http.get('http://localhost:8080/lowerThan?user=15');
    }


}
