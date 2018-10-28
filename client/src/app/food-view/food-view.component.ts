import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { FoodService } from '../service/food.service';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';


export interface PlaylistElement {
  no: number;
  name: string;
  price: number;
}
@Component({
  selector: 'app-food-view',
  templateUrl: './food-view.component.html',
  styleUrls: ['./food-view.component.css']
})
export class FoodViewComponent implements OnInit {
  displayedColumns: string[] = ['no', 'image','name','price'];
  private sub: any;
  private id: number;
  data:any = {sum:''};

  private order = {
    id : '',
    adder : {},
    listMenu : [
      {
        foodmenu:{
          foodMenuPrice:0
        }
      }
    ]
  };

  url: any;
  totalPrice:number;
  menu:any

  constructor(private router: Router, private rout: ActivatedRoute, private foodService: FoodService,
    private sanitizer: DomSanitizer) {
    this.sanitizer = sanitizer;
  }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
      this.data = params;
      this.id = +params['id'];
      console.log(this.id);
    });
    this.foodService.getFoodOrderId(this.id).subscribe(data => {
      this.order = data;
      console.log(this.order);
    });
  }

    imageURL(code) {
     this.url = 'https://www.img.live/images/2018/10/27/' + code ;
    return this.sanitizer.bypassSecurityTrustResourceUrl(this.url);
  }
  }
