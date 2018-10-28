import { Component, OnInit } from '@angular/core';
import { PostalService } from '../service/postal.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-postal-show',
  templateUrl: './postal-show.component.html',
  styleUrls: ['./postal-show.component.css']
})
export class PostalShowComponent implements OnInit {
  customers: Array<any>;
  postalAmounts: Array<any>;
  postalCategories: Array<any>;

  postalOrders: Array<any>;
  constructor(private postalService: PostalService, private httpClient: HttpClient) { }

  ngOnInit() {
     this.postalService.getPostalOrders().subscribe(data => {
      this.postalOrders = data;
      console.log(this.postalOrders);
    });
      this.postalService.getCustomers().subscribe(data => {
        this.customers = data;
        console.log(this.customers);
      });
      this.postalService.getPostalCategories().subscribe(data => {
        this.postalCategories = data;
        console.log(this.postalCategories);
      });
      this.postalService.getPostalAmounts().subscribe(data => {
        this.postalAmounts = data;
        console.log(this.postalAmounts);
      });
    }

}
