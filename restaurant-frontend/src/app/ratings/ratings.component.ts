import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { RatingServices } from '../../services/ratings.service';
import { Register } from '../../models/register.model';
import { QueriesService } from '../../services/queries.service';
import { Restaurant } from "../../models/restaurant.model";
import { RestaurantService } from '../../services/restaurant.service';
import { RaterServices } from '../../services/rater.service';

@Component({
  selector: 'app-ratings',
  templateUrl: './ratings.component.html',
  styleUrls: ['./ratings.component.css']
})
export class RatingsComponent implements OnInit {
  public restaurants: any;
  public restaurantKeys: string[];
  
  public raters : any;
  public raterKeys : string[];

  public ratings: any;
  public ratingKeys: string[];



  public userx = localStorage.getItem('username');

  constructor(private router: Router,private restaurantService: RestaurantService, private ratingService : RatingServices, private raterService : RaterServices) { }
  //private ratingServices: RatingServices
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

  
  public onSubmit(form: NgForm):void{
    this.ratingService.getRating(form.value.id).subscribe(
      (loadedResult: any) =>{
        this.ratings = loadedResult.ratings;
        this.ratingKeys = this.getKeys(this.ratings);
    
      },
        (err:any) =>{
          console.log(err);
        }
    );

    form.resetForm();
 
   }


  
}
