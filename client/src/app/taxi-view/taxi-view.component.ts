import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { TaxiService } from '../service/taxi.service';
import {Router} from "@angular/router";
import { Location } from '@angular/common';


@Component({
  selector: 'app-taxi-view',
  templateUrl: './taxi-view.component.html',
  styleUrls: ['./taxi-view.component.css']
})
export class TaxiViewComponent implements OnInit {

  orders: Array<any>;

  displayedColumns: string[] = ['no', 'customerName', 'areaType',
                                  'carType','Location1','Location2',
                                  'note','totalPrice'];

  constructor(private TaxiService: TaxiService , private httpClient: HttpClient, private router:Router,private location: Location) { }

  pageRefresh() {
    location.reload();
 }

  ngOnInit() {
    this.TaxiService.getOrders().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
  }
}
