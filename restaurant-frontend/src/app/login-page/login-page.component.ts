import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../../models/login.model';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { RaterServices } from '../../services/rater.service';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  public res : string;
  public flag : boolean = false;

  constructor(private router: Router, private raterServices: RaterServices) { }

  ngOnInit() {
  }

  public goToRoute(route: string){
    this.router.navigate([route])
  }

  public onSubmit(form: NgForm): void{
    let login: Login = {
      username: form.value.username,
      password: form.value.password,
    };
  

  this.raterServices.login(login).subscribe(
    (response : any) => {
      let rUsername : string = response.username;
      localStorage.setItem('username', rUsername);
      console.log(response.status);
      if(response.status == 'success'){
        this.goToRoute('home');
      }else {
        this.flag = true;
        this.res = "Username or password incorrect."
      }
    },
    (err: any) => {
      console.log(err);
    }
  )

  }

}
