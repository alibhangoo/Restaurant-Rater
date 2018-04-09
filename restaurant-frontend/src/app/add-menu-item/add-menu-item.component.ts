import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { RestaurantService } from '../../services/restaurant.service';
import {NgForm} from '@angular/forms';
import { MenuItem } from '../../models/menu-item.model';
import { MenuItemServices } from '../../services/menu-item.service';

@Component({
  selector: 'app-add-menu-item',
  templateUrl: './add-menu-item.component.html',
  styleUrls: ['./add-menu-item.component.css']
})
export class AddMenuItemComponent implements OnInit {
  public restaurants: any;
  public restaurantKeys: string[];

  constructor(private router: Router, private restaurantService:RestaurantService, private menuItemService:MenuItemServices) { }

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
    let menuItem: MenuItem = {
      name: form.value.name,
      type: form.value.type,
      category: form.value.category,
      description: form.value.description,
      price: form.value.price,
      itemID: "",
      restaurantID: form.value.restaurantID
    };
    this.menuItemService.createMenuItem(menuItem).subscribe(
      (res: any) => {
        console.log(res)
      }
    );

    form.resetForm();
 
   }

}
