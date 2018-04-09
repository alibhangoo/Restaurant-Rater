import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginPageComponent } from './login-page/login-page.component'
import { RestaurantPageComponent } from './restaurant-page/restaurant-page.component';
import { MenuPageComponent } from './menu-page/menu-page.component';
import { RestaurantService } from '../services/restaurant.service';
import { RaterServices } from '../services/rater.service';
import { QueriesService } from "../services/queries.service";
import { RegisterComponent } from './register/register.component';
import { AddMenuItemComponent } from './add-menu-item/add-menu-item.component';
import { MenuItemServices } from '../services/menu-item.service';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
<<<<<<< HEAD
import { RatingsComponent } from './ratings/ratings.component';
import { RatingServices } from '../services/ratings.service';
import { AddRatingComponent } from './add-rating/add-rating.component';


=======
import { ByCategoryComponent } from './by-category/by-category.component';
>>>>>>> 5b7537a40c1490028af969f3b12f6c5548e97e76

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginPageComponent,
    RestaurantPageComponent,
    MenuPageComponent,
    RegisterComponent,
    AddMenuItemComponent,
    AddRestaurantComponent,
<<<<<<< HEAD
    RatingsComponent,
    AddRatingComponent
=======
    ByCategoryComponent
>>>>>>> 5b7537a40c1490028af969f3b12f6c5548e97e76
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [RaterServices, RestaurantService, QueriesService, MenuItemServices, RatingServices],
  bootstrap: [AppComponent]
})
export class AppModule { }
