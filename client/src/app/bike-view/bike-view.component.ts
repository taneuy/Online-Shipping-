import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { BikeService } from '../service/bike.service';
import {Router} from "@angular/router";
import { Location } from '@angular/common';


@Component({
  selector: 'app-bike-view',
  templateUrl: './bike-view.component.html',
  styleUrls: ['./bike-view.component.css']
})
export class BikeViewComponent implements OnInit {

  orders: Array<any>;

  displayedColumns: string[] = ['no', 'customerName', 'areaType',
                                  'paymentType','pickLocation','dropLocation',
                                  'totalPrice'];

  constructor(private bikeService: BikeService , private httpClient: HttpClient, private router:Router,private location: Location) { }

  pageRefresh() {
    location.reload();
 }

  ngOnInit() {
    this.bikeService.getOrders().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
  }




}
