import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {MenuItem} from '../models/menu-item.model';

@Injectable()
export class MenuItemServices {
    constructor(private http: HttpClient){}


    public getMenuItems(): Observable<any>{
        return this.http.get('http://localhost:8080/menuitems')

    }

    public createMenuItem(menuItem: MenuItem):Observable<any>{
        return this.http.post( 'http://localhost:8080/menuitem/add', menuItem);

    }

    public deleteMenuItem(menuItemName: String):Observable<any>{
        return this.http.post( 'http://localhost:8080/menuitem/delete', menuItemName);

    }


}