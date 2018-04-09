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

  public queryFArr: any;
  public queryFArrKeys: string[];

  public queryGArr: any;
  public queryGArrKeys: string[];

  public categories: any;
  public categoryKeys: string[];

  public qI: any;
  public qIKeys: string[];

  public queryKArr: any;
  public queryKArrKeys: string[];

  public queryLArr: any;
  public queryLArrKeys: string[];

  public qM: any;
  public qMKeys: string[];

  public queryNArr: any;
  public queryNArrKeys: string[];

  public qO: any;
  public qOKeys: string[];

  public userx = localStorage.getItem('username');

  constructor(private router: Router,private restaurantService: RestaurantService, private ratingService : RatingServices, private raterService : RaterServices, private queryService : QueriesService) { }
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

    this.restaurantService.getCategories().subscribe(
      (loadedCategory: any) =>{
        this.categories = loadedCategory;
        console.log(this.categories);
        this.categoryKeys = this.getKeys(this.categories);
        console.log(this.categoryKeys);
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


  public onSubmitQueryF():void{
    this.queryService.queryF().subscribe(
      (loadedResult: any) =>{
        this.queryFArr = loadedResult;
        this.queryFArrKeys = this.getKeys(this.queryFArr);
      },
        (err:any) =>{
          console.log(err);
        }
    ); 
   }

  public onSubmitQueryG():void{
    this.queryService.queryG().subscribe(
      (loadedResult: any) =>{
        this.queryGArr = loadedResult;
        this.queryGArrKeys = this.getKeys(this.queryGArr);
      },
        (err:any) =>{
          console.log(err);
        }
    ); 
   }

   public onSubmitQueryI(form: NgForm):void{
    console.log(form.value.category)
    this.queryService.queryI(form.value.category).subscribe(
      (loadedResult: any) =>{
        this.qI = loadedResult.result;
        this.qIKeys = this.getKeys(this.qI);
    
      },
        (err:any) =>{
          console.log(err);
        }
    );

    form.resetForm();
 
   }


  public onSubmitQueryK():void{
    this.queryService.queryK().subscribe(
      (loadedResult: any) =>{
        this.queryKArr = loadedResult;
        this.queryKArrKeys = this.getKeys(this.queryKArr);
      },
        (err:any) =>{
          console.log(err);
        }
    ); 
   }

  public onSubmitQueryL():void{
    this.queryService.queryL().subscribe(
      (loadedResult: any) =>{
        this.queryLArr = loadedResult;
        this.queryLArrKeys = this.getKeys(this.queryLArr);
      },
        (err:any) =>{
          console.log(err);
        }
    ); 
   }


  public onSubmitQueryN():void{
    this.queryService.queryN().subscribe(
      (loadedResult: any) =>{
        this.queryNArr = loadedResult.result;
        this.queryNArrKeys = this.getKeys(this.queryNArr);
      },
        (err:any) =>{
          console.log(err);
        }
    ); 
   }

   public onSubmitQueryM(form: NgForm):void{
    this.queryService.queryM(form.value.id).subscribe(
      (loadedResult: any) =>{
        this.qM = loadedResult.result;
        this.qMKeys = this.getKeys(this.qM);
      },
        (err:any) =>{
          console.log(err);
        }
    ); 
   }


   public onSubmitQueryO():void{
    this.queryService.queryO().subscribe(
      (loadedResult: any) =>{
        this.qO = loadedResult;
        this.qOKeys = this.getKeys(this.qO);
      },
        (err:any) =>{
          console.log(err);
        }
    ); 
   }
}
