import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { QueriesService } from '../../services/queries.service';
import { RaterServices } from '../../services/rater.service';
@Component({
  selector: 'app-name-date-x',
  templateUrl: './name-date-x.component.html',
  styleUrls: ['./name-date-x.component.css']
})
export class NameDateXComponent implements OnInit {
  public raters : any;
  public raterKeys : string[];

   //QUERY H
   public qH: any;
   public qHKeys: string[];

  constructor(private router: Router, private raterService : RaterServices, private queryService : QueriesService) { }

  ngOnInit() {
    this.raterService.getRaters().subscribe(
      (loadedRaters : any) =>{
        this.raters = loadedRaters;
        this.raterKeys = this.getKeys(this.raters);
      },
        (err:any) =>{
          console.log(err);
        }
    );
  }

  public goToRoute(route: string){
    this.router.navigate([route])
  }

  public getKeys(obj: any): string[]{
    return Object.keys(obj);
  }

  public onSubmit(form: NgForm):void{

    this.queryService.queryH(form.value.id).subscribe(
      (loadedResult: any) =>{
        this.qH = loadedResult.result;
        this.qHKeys = this.getKeys(this.qH);
      },
        (err:any) =>{
          console.log(err);
        }
    );

    form.resetForm();
 
   }


}
