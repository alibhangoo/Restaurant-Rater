import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RaterServices } from '../../services/rater.service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public user = localStorage.getItem('username');

  constructor(private router: Router,private raterServices: RaterServices) { }
  
  ngOnInit() {
  }

  public goToRoute(route: string){
    this.router.navigate([route]);
  }

  public onDelete(user): void{
 
  this.raterServices.delete(user).subscribe(
    (response : any) => {
     
      console.log(response)
    },
    (err: any) => {
      console.log(err);
    }
  )

  this.goToRoute('login');

  }

}
