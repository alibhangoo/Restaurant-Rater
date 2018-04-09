import { Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import { RestaurantService } from '../../services/restaurant.service';
import { QueriesService } from '../../services/queries.service';
import {NgForm} from '@angular/forms';
import { MenuItemServices } from '../../services/menu-item.service';

@Component({
  selector: 'app-menu-page',
  templateUrl: './menu-page.component.html',
  styleUrls: ['./menu-page.component.css']
})

export class MenuPageComponent implements OnInit {
  public restaurants: any;
  public restaurantKeys: string[];

  public menuItems: any;
  public menuItemKeys: string[];



  constructor(private router: Router, private restaurantService:RestaurantService, private queryService:QueriesService, private menuItemService:MenuItemServices) { }

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

  public onSubmit(form: NgForm):void{
    this.queryService.queryB(form.value.id).subscribe(
      (loadedResult: any) =>{
        this.menuItems = loadedResult.menuItems;
        this.menuItemKeys = this.getKeys(this.menuItems);
    
      },
        (err:any) =>{
          console.log(err);
        }
    );

    form.resetForm();
 
   }

  
   public deleteMenuItem(menuItemName : string, menuItemKey: string, index:number){
  
    this.menuItemService.deleteMenuItem(menuItemName).subscribe(
      (response : any) => {
        console.log(response);
      }
    )
    this.menuItemKeys.splice(index, 1);
    delete this.menuItems[menuItemKey];
  }
  
}
