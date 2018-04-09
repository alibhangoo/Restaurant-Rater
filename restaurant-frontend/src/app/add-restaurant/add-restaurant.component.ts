import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantService } from '../../services/restaurant.service';
import {NgForm} from '@angular/forms';
import { Restaurant } from "../../models/restaurant.model";


@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.css']
})
export class AddRestaurantComponent implements OnInit {
  public res : string;
  public clicked: boolean= false;

  constructor(private router: Router, private restaurantServices: RestaurantService) { }

  ngOnInit() {
  }

  public goToRoute(route: string){
    this.router.navigate([route])
  }


  public onSubmit(form: NgForm): void{
    let restaurant: Restaurant = {
      restaurantId: form.value.restaurantId,
      name: form.value.name,
      type : form.value.type,
      url : form.value.url
    };
  

  this.restaurantServices.addRestaurant(restaurant).subscribe(
    (response : any) => {
      console.log(response)

      this.clicked = true

      if(response.status == 'success')
        this.goToRoute("restaurants")
      else
        this.res = "Username already taken!"
      
    },
    (err: any) => {
      console.log(err);
    }
  )

  }

}

