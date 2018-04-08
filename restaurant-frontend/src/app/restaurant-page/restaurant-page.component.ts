import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-restaurant-page',
  templateUrl: './restaurant-page.component.html',
  styleUrls: ['./restaurant-page.component.css']
})
export class RestaurantPageComponent implements OnInit {

  constructor(private router: Router) { }
  
  
  ngOnInit() {
  }

  public goToRoute(route: string){
    this.router.navigate([route]);
  }
  

}
