import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { HttpClient} from '@angular/common/http';
import { BikeService } from '../service/bike.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-bike-show',
  templateUrl: './bike-show.component.html',
  styleUrls: ['./bike-show.component.css']
})
export class BikeShowComponent implements OnInit {

  data:any={}

  constructor(private route:ActivatedRoute, private BikeService: BikeService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    })
  }

  save() {
    this.httpClient.post('http://localhost:8080/bikeOrders/' + this.data.username + '/' + this.data.payments + '/' + this.data.areas + '/' + this.data.pickLocation + '/' + this.data.dropLocation + '/' + this.data.totalPrice,this.data)
    .subscribe(
      data =>   {console.log('PUT Request is successful', data);},
      error =>  {console.log('Error', error);}
      );
    }
}

