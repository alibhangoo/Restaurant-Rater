import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { RaterServices } from '../../services/rater.service';
import { Register } from '../../models/register.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router, private raterServices: RaterServices) { }

  ngOnInit() {
  }

  public goToRoute(route: string){
    this.router.navigate([route])
  }

  public onSubmit(form: NgForm): void{
    let register: Register = {
      email: form.value.email,
      name: form.value.name,
      joinDate: form.value.joinDate,
      type: form.value.type,
      password: form.value.password,
      reputation: 1,
      userID: "",
    };
  

  this.raterServices.register(register).subscribe(
    (response : any) => {
      console.log(response)
    },
    (err: any) => {
      console.log(err);
    }
  )

  }


}
