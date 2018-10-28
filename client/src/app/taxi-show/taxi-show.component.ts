import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import { HttpClient} from '@angular/common/http';
import{TaxiService} from '../service/taxi.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-taxi-show',
  templateUrl: './taxi-show.component.html',
  styleUrls: ['./taxi-show.component.css']
})
export class TaxiShowComponent implements OnInit {
  data:any={}

  constructor(private route:ActivatedRoute, private TaxiService: TaxiService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
  this.route.params.subscribe(prams=>{
          this.data = prams
          console.log(prams)
  })
  }

  save() {
    this.httpClient.post('http://localhost:8080/taxiOrders/' + this.data.username + '/' + this.data.carservices + '/' + this.data.areas + '/' + this.data.Location1 + '/' + this.data.Location2 + '/' + this.data.note + '/' + this.data.totalPrice,this.data)
    .subscribe(
      data =>   {console.log('PUT Request is successful', data);},
      error =>  {console.log('Error', error);}
      );
    }

}
