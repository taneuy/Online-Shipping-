import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { BikeService } from '../service/bike.service';
import { Router } from "@angular/router";
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-bike-order',
  templateUrl: './bike-order.component.html',
  styleUrls: ['./bike-order.component.css']
})
export class BikeOrderComponent implements OnInit {

  customers: Array<any>;
  payments: Array<any>;
  areas: Array<any>;
  orders: Array<any>;

  select: any = {
    usernameSelect: '',
    paymentSelect: '',
    areasSelect: '',
  };

  cus: any = {};
  pm: any = {};
  ap: any = {
    areaPrice: 0
  };

  pickLocation: any;
  dropLocation: any;

  areaPrice: number = 0;
  totalPrice: number = 0;

  data: any = {
    //username:'',
    //areas:'',
    //payments:'',
    //pickLocation:'',
    //dropLocation:'',
    //totalPrice:''
  }

  constructor(private bikeService: BikeService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
    this.bikeService.getCustomers().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });
    this.bikeService.getPayments().subscribe(data => {
      this.payments = data;
      console.log(this.payments);
    });
    this.bikeService.getAreas().subscribe(data => {
      this.areas = data;
      console.log(this.areas);
    });
    this.bikeService.getOrders().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
  }

  getCustomerDetail(){
    this.bikeService.getCustomerDetail(this.select.usernameSelect).subscribe(data => {
      this.cus = data;
      console.log(this.cus);
    });
  }
  getPaymentDetail(){
    this.bikeService.getPaymentDetail(this.select.paymentSelect).subscribe(data => {
      this.pm = data;
      console.log(this.pm);
    });
  }
  getAreaDetail(){
    this.bikeService.getAreaDetail(this.select.areaSelect).subscribe(data => {
      this.ap = data;
      console.log(this.ap);
    });
  }

  SubmittedData(){
      console.log(this.data)
      const data  = this.data
      if (this.select.usernameSelect === '' || this.select.paymentSelect === '' || this.select.areaSelect === '' || this.pickLocation === '' || this.dropLocation === '') {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      } else {
        this.router.navigate(['bike-show',{
          username: data.username = this.cus.name,
          payments:  data.payments = this.pm.paymentType,
          areas:     data.areas = this.ap.areaType,
          pickLocation: data.pickLocation = this.pickLocation,
          dropLocation: data.dropLocation = this.dropLocation,
          totalPrice: data.totalPrice = 20 + this.ap.areaPrice
          }])
      }
  }

  sum(){
    this.areaPrice = this.ap.this.areaPrice;
    return this.totalPrice = 20 + this.areaPrice
  }

  save() {
    if (this.select.usernameSelect === '' || this.select.paymentSelect === '' || this.select.areasSelect === '' || this.pickLocation === '' || this.dropLocation === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/bikeOrders/' + this.select.usernameSelect + '/' + this.select.paymentSelect + '/' + this.select.areaSelect + '/' + this.pickLocation + '/' + this.dropLocation + '/' + this.totalPrice,this.orders)
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

