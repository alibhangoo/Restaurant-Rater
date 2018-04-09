import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import { QueriesService } from '../../services/queries.service';

@Component({
  selector: 'app-average-items',
  templateUrl: './average-items.component.html',
  styleUrls: ['./average-items.component.css']
})
export class AverageItemsComponent implements OnInit {
  public qE: any;
  public qEKeys: string[];

  constructor(private router: Router, private queryService:QueriesService) { }

  ngOnInit() {

    this.queryService.queryE().subscribe(
      (loadedResult: any) =>{
        this.qE = loadedResult;
        console.log(this.qE);
        this.qEKeys = this.getKeys(this.qE);
    
      },
        (err:any) =>{
          console.log(err);
        }
    );

  }

  public goToRoute(route: string){
    this.router.navigate([route]);
  }

  public getKeys(obj: any): string[]{
    return Object.keys(obj); 
  }

}
