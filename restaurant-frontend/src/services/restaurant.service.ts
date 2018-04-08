import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Restaurant} from '../models/Restaurant.model';

@Injectable()
export class RestaurantService{
    constructor(private http: HttpClient){}

    public getRestaurants(): Observable<any>{
        return this.http.get('http://localhost:8080/restaurants')

    }
    public createRestaurant(restaurant: Restaurant):Observable<any>{
        return this.http.post( 'http://localhost:8080/login' + 'chore.json', restaurant);

    }

    public deleteRestaurant(key: string): Observable<any>{
        return this.http.delete('http://localhost:8080/login' + 'chore/' + key + '.json')
    }

}