import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { PostalService } from '../service/postal.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-postal-order',
  templateUrl: './postal-order.component.html',
  styleUrls: ['./postal-order.component.css']
})

export class PostalOrderComponent implements OnInit {
  customers: Array<any>;
  postalAmounts: Array<any>;
  postalCategories: Array<any>;

  postalOrders: any = {nameSelect: '', categorySelect: '', amountSelect: ''};
  data:any={};
  constructor(private router:Router,private postalService: PostalService, private httpClient: HttpClient) { }

  ngOnInit() {

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

  save() {
    if (this.postalOrders.nameSelect === '' || this.postalOrders.categorySelect === '' || this.postalOrders.amountSelect === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/postal/orders/' + this.postalOrders.nameSelect + '/' + this.postalOrders.categorySelect + '/' + this.postalOrders.amountSelect ,this.postalOrders)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }
}
