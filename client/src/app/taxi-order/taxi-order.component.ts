import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { TaxiService } from '../service/taxi.service';
import {Router} from "@angular/router";
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-taxi-order',
  templateUrl: './taxi-order.component.html',
  styleUrls: ['./taxi-order.component.css']
})
export class TaxiOrderComponent implements OnInit {

  customers: Array<any>;
  carservices: Array<any>;
  areas: Array<any>;
  orders: Array<any>;

  select: any={
        usernameSelect: '',
        carSelect: '',
        areasSelect: '',
  };

  or: any={};
  cp: any={
    carPrice: 0
  };
  ap: any={
    areaPrice: 0
  };

  Location1: any;
  Location2: any;
  note: any;
  
  carPrice: number = 0;
  areaPrice: number = 0;
  totalPrice: number = 0;

  data:any={
    // username:'',
    // carservice:'',
    // areas:'',
    // Location1:'',
    // Location2:'',
    // note:'',
    // totalPrice:''
  }

  constructor(private taxiService: TaxiService, private httpClient: HttpClient , private router:Router) { }

  ngOnInit() {
    this.taxiService.getCustomers().subscribe(data => {
    this.customers = data;
    console.log(this.customers);
    });
    this.taxiService.getCarServices().subscribe(data => {
      this.carservices = data;
      console.log(this.carservices);
    });
    this.taxiService.getAreas().subscribe(data => {
      this.areas = data;
      console.log(this.areas);
    });
    this.taxiService.getOrders().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
  }

  getCustomerDetail(){
    this.taxiService.getCustomerDetail(this.select.usernameSelect).subscribe(data => {
      this.or = data;
      console.log(this.or);
    });
  }
  getCarServiceDetail(){
    this.taxiService.getCarServiceDetail(this.select.carSelect).subscribe(data => {
      this.cp = data;
      console.log(this.cp);
    });
  }
  getAreaDetail(){
    this.taxiService.getAreaDetail(this.select.areaSelect).subscribe(data => {
      this.ap = data;
      console.log(this.ap);
    });
  }

  SubmittedData(){
    console.log(this.data)
    const data = this.data
    if (this.select.usernameSelect === '' || this.select.areas === '' || this.Location1 === '' || this.Location2 === '' || this.select.carSelect === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
    this.router.navigate(['taxi-show',{
      username:      data.username = this.or.name,
      carservices:    data.carservices = this.cp.carType,
      areas:          data.areas = this.ap.areaType,
      Location1:      data.Location1 = this.Location1,
      Location2:      data.Location2 = this.Location2,
      note:           data.note,
      totalPrice:     data.totalPrice = this.cp.carPrice  + this.ap.areaPrice
      }])
    }
  }

  sum(){
    this.carPrice = this.cp.carPrice;
    this.areaPrice = this.ap.this.areaPrice;
    return this.totalPrice = this.carPrice + this.areaPrice
  }

  save() {
    if (this.select.usernameSelect === '' || this.select.carSelect === '' || this.select.areasSelect === '' || this.Location1 === '' || this.Location2 === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/taxiOrders/' + this.select.usernameSelect + '/' + this.select.carSelect + '/' + this.select.areasSelect + '/' + this.Location1 + '/' + this.Location2 + '/' + this.note + '/' + this.totalPrice,this.orders)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
          },
          error => {
              console.log('Rrror', error);
          }
      );
    }
  }
 
}