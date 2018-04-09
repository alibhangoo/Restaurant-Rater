import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { RatingServices } from '../../services/ratings.service';
import { Register } from '../../models/register.model';
import { QueriesService } from '../../services/queries.service';
import { Restaurant } from "../../models/restaurant.model";
import { RestaurantService } from '../../services/restaurant.service';
import { Rating } from '../../models/rating.model';

@Component({
  selector: 'app-add-rating',
  templateUrl: './add-rating.component.html',
  styleUrls: ['./add-rating.component.css']
})
export class AddRatingComponent implements OnInit {
  public restaurants: any;
  public restaurantKeys: string[];

  public res : string;
  public clicked: boolean= false;

  constructor(private router: Router, private ratingServices : RatingServices, private restaurantService: RestaurantService) { }

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

  public getKeys(obj: any): string[]{
    return Object.keys(obj); //random order
  }

  public goToRoute(route: string){
    this.router.navigate([route])
  }

  public onSubmit(form: NgForm): void{
    let rating : Rating = {
      userID: +localStorage.getItem('userID'),
      date: form.value.date,
      price: form.value.price,
      food: form.value.food,
      mood: form.value.mood,
      staff: form.value.staff,
      comments: form.value.comments,
      restaurantID: form.value.restaurantid
    };
  

  this.ratingServices.addRating(rating).subscribe(
    (response : any) => {
      console.log(response)

      this.clicked = true

      if(response.status == 'success')
        this.res = "Added rating!"
      else
        this.res = "Sorry but you cannot add this rating!"
      
    },
    (err: any) => {
      console.log(err);
    }
  )

  }




}
