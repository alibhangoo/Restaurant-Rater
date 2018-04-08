import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Restaurant} from '../models/Restaurant.model';

@Injectable()
export class RestaurantService{
    constructor(private http: HttpClient){}
/*
    public getChores(): Observable<any>{
        return this.http.get(dbroot + 'chore.json')

    }
    public createChore(chore: Chore):Observable<any>{
        return this.http.post( dbroot + 'chore.json', chore);

    }

    public deleteChore(key: string): Observable<any>{
        return this.http.delete(dbroot + 'chore/' + key + '.json')
    }
    */

}