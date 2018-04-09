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
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginPageComponent,
    RestaurantPageComponent,
    MenuPageComponent,
    RegisterComponent,
    AddRestaurantComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [RaterServices,RestaurantService, QueriesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
