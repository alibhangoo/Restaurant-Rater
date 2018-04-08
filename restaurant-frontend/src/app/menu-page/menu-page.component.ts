import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-menu-page',
  templateUrl: './menu-page.component.html',
  styleUrls: ['./menu-page.component.css']
})

export class MenuPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  public goToRoute(route: string){
    this.router.navigate([route]);
  }

}
