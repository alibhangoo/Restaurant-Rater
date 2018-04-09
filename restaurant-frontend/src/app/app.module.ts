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
import { RatingsComponent } from './ratings/ratings.component';
import { RatingServices } from '../services/ratings.service';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { ByCategoryComponent } from './by-category/by-category.component';
import { AverageItemsComponent } from './average-items/average-items.component';
import { NameDateXComponent } from './name-date-x/name-date-x.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import { RatingItemsComponent } from './rating-items/rating-items.component';
import { AddRatingItemComponent } from './add-rating-item/add-rating-item.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginPageComponent,
    RestaurantPageComponent,
    MenuPageComponent,
    RegisterComponent,
    AddMenuItemComponent,
    ByCategoryComponent,
    AverageItemsComponent,
    NameDateXComponent,
    RatingsComponent,
    AddRatingComponent,
    AddRestaurantComponent,
    RatingItemsComponent,
    AddRatingItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule
  ],
  providers: [RaterServices, RestaurantService, QueriesService, MenuItemServices, RatingServices],
  bootstrap: [AppComponent]
})
export class AppModule { }
