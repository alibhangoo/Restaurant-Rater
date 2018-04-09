import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { RestaurantService } from '../../services/restaurant.service';
import { Restaurant } from "../../models/restaurant.model";
import {NgForm} from '@angular/forms';
import { QueriesService } from '../../services/queries.service';

@Component({
  selector: 'app-restaurant-page',
  templateUrl: './restaurant-page.component.html',
  styleUrls: ['./restaurant-page.component.css']
})


export class RestaurantPageComponent implements OnInit {
  public restaurants: any;
  public restaurantKeys: string[];

  public selectedRes: string;

  public isRestaurant: boolean = true;

  //QUERY A
  public qA: any;
  public qAKeys: string[];


  constructor(private router: Router, private restaurantService: RestaurantService, private queryService: QueriesService) { }
  
  
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

  public deleteRest(restName : string){
    this.restaurantService.deleteRestaurant(restName).subscribe(
      (response : any) => {
        console.log(response);
      }
    )
  }

  public getKeys(obj: any): string[]{
    return Object.keys(obj); //random order
  }

  public onSubmit(form: NgForm):void{
    this.queryService.queryA(form.value.id).subscribe(
      (loadedResult: any) =>{
        this.qA = loadedResult.result;
        this.qAKeys = this.getKeys(this.qA);
    
      },
        (err:any) =>{
          console.log(err);
        }
    );

    form.resetForm();
 
   }

   public changView(wantedView : string){
      if(wantedView == "restaurant"){
        this.isRestaurant = true;
      }
      else{
        this.isRestaurant = false;
      }
  }
  

}
