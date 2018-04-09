import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RatingServices } from '../../services/ratings.service';
import { RestaurantService } from '../../services/restaurant.service';
import { MenuItemServices } from '../../services/menu-item.service';
import { RaterServices } from '../../services/rater.service';

@Component({
  selector: 'app-rating-items',
  templateUrl: './rating-items.component.html',
  styleUrls: ['./rating-items.component.css']
})
export class RatingItemsComponent implements OnInit {
  public restaurants: any;
  public restaurantKeys: string[];

  public menuItems: any;
  public menuItemKeys: string[];

  public ratingItems: any;
  public ratingItemKeys: string[];

  public raters : any;
  public raterKeys : string[];

  constructor(private router: Router, private ratingsService : RatingServices, private restaurantService:RestaurantService, private menuServices: MenuItemServices, private raterService: RaterServices) { }

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

    this.menuServices.getMenuItems().subscribe(
      (loadedMenuItems: any) =>{
        this.menuItems = loadedMenuItems.menuItems;
        this.menuItemKeys = this.getKeys(this.menuItems);
      },
        (err:any) =>{
          console.log(err);
        }
    );

    this.raterService.getRaters().subscribe(
      (loadedRaters : any) =>{
        this.raters = loadedRaters;
        this.raterKeys = this.getKeys(this.raters);
      },
        (err:any) =>{
          console.log(err);
        }
    );

  }

  public goToRoute(route: string){
    this.router.navigate([route])
  }

  public getKeys(obj: any): string[]{
    return Object.keys(obj); //random order
  }

  public displayRatingItems():void{
    this.ratingsService.getRatingItems().subscribe(
      (loadedResult: any) =>{
        this.ratingItems = loadedResult.ratingItems;
        this.ratingItemKeys = this.getKeys(this.ratingItems);
    
      },
        (err:any) =>{
          console.log(err);
        }
    );
 
   }


}
