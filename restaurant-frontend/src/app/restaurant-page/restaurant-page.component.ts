import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { RestaurantService } from '../../services/restaurant.service';
import { Restaurant } from "../../models/restaurant.model";

@Component({
  selector: 'app-restaurant-page',
  templateUrl: './restaurant-page.component.html',
  styleUrls: ['./restaurant-page.component.css']
})


export class RestaurantPageComponent implements OnInit {
  public restaurants: any;
  public restaurantKeys: string[];

  constructor(private router: Router, private restaurantService: RestaurantService) { }
  
  
  ngOnInit() {
    this.restaurantService.getRestaurants().subscribe(
      (loadedRestaurant: any) =>{
        this.restaurants = loadedRestaurant;
        this.restaurantKeys = this.getKeys(this.restaurants);
      },
        (err:any) =>{
          console.log(err);
        }
        //next, err, final or some sht
    );
  }

  public goToRoute(route: string){
    this.router.navigate([route]);
  }

  public getKeys(obj: any): string[]{
    return Object.keys(obj); //random order
  }
  

}
