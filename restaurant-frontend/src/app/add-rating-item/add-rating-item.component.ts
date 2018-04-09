import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RatingServices } from '../../services/ratings.service';
import { RestaurantService } from '../../services/restaurant.service';
import { MenuItemServices } from '../../services/menu-item.service';
import { RaterServices } from '../../services/rater.service';
import {NgForm} from '@angular/forms';
import { RatingItems } from '../../models/ratingItems.model';

@Component({
  selector: 'app-add-rating-item',
  templateUrl: './add-rating-item.component.html',
  styleUrls: ['./add-rating-item.component.css']
})
export class AddRatingItemComponent implements OnInit {
  public menuItems: any;
  public menuItemKeys: string[];

  constructor(private router: Router, private menuServices: MenuItemServices, private ratingService:RatingServices) { }

  ngOnInit() {
    this.menuServices.getMenuItems().subscribe(
      (loadedMenuItems: any) =>{
        this.menuItems = loadedMenuItems.menuItems;
        this.menuItemKeys = this.getKeys(this.menuItems);
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
    let ratingItem: RatingItems = {
      rating: form.value.rating,
      comment: form.value.comment,
      date: form.value.date,
      UserID: +localStorage.getItem('userID'),
      itemID: form.value.itemID
    };


    this.ratingService.addRatingItems(ratingItem).subscribe(
      (res: any) => {
        console.log(res)
      }
    );

    form.resetForm();
 
   }

}
