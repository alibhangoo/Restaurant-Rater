import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../../models/login.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit() {
  }

  public goToRoute(route: string){
    this.router.navigate([route])
  }

  public login: Login = {
    username: "",
    password: ""
  }

  public submit(): void {
    this.color="green";
      this.http.post("http://localhost:8080/login",this.login).subscribe(result=>console.log("working"),err=>console.log(err));
  }

  public color = "red";
}
