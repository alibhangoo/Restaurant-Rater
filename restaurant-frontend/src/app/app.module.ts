import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
<<<<<<< HEAD
=======
import { HttpClientModule } from '@angular/common/http';
>>>>>>> 5c79a5467e76f8e5f016951704f3fdfd43c89ca9


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
