import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {Restaurant} from '../models/Restaurant.model';
import { Rating } from '../models/rating.model';
import { RatingItems } from '../models/ratingItems.model';


@Injectable()
export class RatingServices {
    
    constructor(private http: HttpClient){}


    public getRating(id: string): Observable<any> {
        return this.http.get('http://localhost:8080/rating?restaurant=' + id);
    }

    public addRating(rating: Rating):Observable<any>{
        return this.http.post('http://localhost:8080/rating/add', rating);
    }

    public getRatingItems(): Observable<any> {
        return this.http.get('http://localhost:8080/ratingitems');
    } 

    public addRatingItems(ratingItems: RatingItems):Observable<any>{
        return this.http.post('http://localhost:8080/ratingitem/add', ratingItems);
    }


    
}