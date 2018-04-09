import { Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import { RestaurantService } from '../../services/restaurant.service';
import { Restaurant } from "../../models/restaurant.model";
import {NgForm} from '@angular/forms';
import { QueriesService } from '../../services/queries.service';

@Component({
  selector: 'app-by-category',
  templateUrl: './by-category.component.html',
  styleUrls: ['./by-category.component.css']
})
export class ByCategoryComponent implements OnInit {
  
  public categories: any;
  public categoryKeys: string[];

  public qC: any;
  public qCKeys: string[];

  constructor(private router: Router, private queryService:QueriesService, private restaurantService:RestaurantService) { }

  ngOnInit() {
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
    this.router.navigate([route]);
  }

  public getKeys(obj: any): string[]{
    return Object.keys(obj); 
  }

  public onSubmit(form: NgForm):void{
    console.log(form.value.category)
    this.queryService.queryC(form.value.category).subscribe(
      (loadedResult: any) =>{
        this.qC = loadedResult.result;
        this.qCKeys = this.getKeys(this.qC);
    
      },
        (err:any) =>{
          console.log(err);
        }
    );

    form.resetForm();
 
   }

}
