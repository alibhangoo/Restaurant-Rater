import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { RestaurantService } from '../../services/restaurant.service';


@Component({
  selector: 'app-menu-page',
  templateUrl: './menu-page.component.html',
  styleUrls: ['./menu-page.component.css']
})

export class MenuPageComponent implements OnInit {

  public restaurants: any;
  public restaurantKeys: string[];

  constructor(private router: Router, private restaurantService:RestaurantService) { }

  ngOnInit() {
    this.restaurantService.getRestaurants().subscribe(
      (loadedRestaurant: any) =>{
        this.restaurants = loadedRestaurant;
        this.restaurantKeys = this.getKeys(this.restaurants);
      },
        (err:any) =>{
          console.log(err);
        }
    );
  }
  public goToRoute(route: string){
    this.router.navigate([route]);
  }

  public getKeys(obj: any): string[]{
    return Object.keys(obj); 
  }

  
}
