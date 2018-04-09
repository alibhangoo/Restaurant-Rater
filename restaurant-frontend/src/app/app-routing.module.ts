import {NgModule} from '@angular/core';
import {Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MenuPageComponent } from './menu-page/menu-page.component';
import { RestaurantPageComponent } from './restaurant-page/restaurant-page.component';
import { RegisterComponent } from './register/register.component';
import { AddMenuItemComponent } from './add-menu-item/add-menu-item.component';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
<<<<<<< HEAD
import { RatingsComponent } from './ratings/ratings.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
=======
import { ByCategoryComponent } from './by-category/by-category.component';

>>>>>>> 5b7537a40c1490028af969f3b12f6c5548e97e76

const routes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: HomePageComponent},
    {path: 'login', component: LoginPageComponent},
    {path: 'menus', component: MenuPageComponent},
    {path: 'restaurants', component: RestaurantPageComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'addMenuItem', component: AddMenuItemComponent},
    {path: 'addrestaurant', component: AddRestaurantComponent},
<<<<<<< HEAD
    {path: 'ratings', component: RatingsComponent},
    {path: 'addrating', component: AddRatingComponent}
=======
    {path: 'byCategory', component: ByCategoryComponent}
>>>>>>> 5b7537a40c1490028af969f3b12f6c5548e97e76
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{} //Moule to modify anoither one