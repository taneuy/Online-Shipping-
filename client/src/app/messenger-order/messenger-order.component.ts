import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { MessengerService } from '../service/messenger.service';
import { Router } from "@angular/router";
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-messenger-order',
  templateUrl: './messenger-order.component.html',
  styleUrls: ['./messenger-order.component.css']
})
export class MessengerOrderComponent implements OnInit {

  customers: Array<any>;
  services: Array<any>;
  areas: Array<any>;
  orders: Array<any>;

  select: any = {
    usernameSelect: '',
    serviceSelect: '',
    areaSelect: '',
  };

  cus: any = {};
  sp: any = {
    servicePrice: 0
  };
  ap: any = {
    areaPrice: 0
  };

  receiverName: any;
  receiverPhone: any;
  receiverLocation: any;

  note: any;

  servicePrice: number = 0;
  areaPrice: number = 0;
  totalPrice: number = 0;
 
  data: any = {
    service:'',
    area:'',
    name:'',
    phone:'',
    address:'',
    rn:'',
    rp:'',
    rl:'',
    note:'----',
    tp:''
  }

  constructor(private messengerService: MessengerService , private httpClient: HttpClient, private router:Router, public dialog: MatDialog) { }

  ngOnInit() {
    this.messengerService.getCustomers().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });
    this.messengerService.getServices().subscribe(data => {
      this.services = data;
      console.log(this.services);
    });
    this.messengerService.getAreas().subscribe(data => {
      this.areas = data;
      console.log(this.areas);
    });
    this.messengerService.getOrders().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
  }

  getCustomerDetail(){
    this.messengerService.getCustomerDetail(this.select.usernameSelect).subscribe(data => {
      this.cus = data;
      console.log(this.cus);
    });
  }
  getServiceDetail(){
    this.messengerService.getServiceDetail(this.select.serviceSelect).subscribe(data => {
      this.sp = data;
      console.log(this.sp);
    });
  }
  getAreaDetail(){
    this.messengerService.getAreaDetail(this.select.areaSelect).subscribe(data => {
      this.ap = data;
      console.log(this.ap);
    });
  }

  SubmittedData(){
      console.log(this.data)
      const data  = this.data
      if (this.select.usernameSelect === '' || this.select.serviceSelect === '' || this.select.areaSelect === '' || this.receiverName === '' || this.receiverPhone === '' || this.receiverLocation === '') {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      } else {
        this.router.navigate(['messenger-show',{
          service:  data.service = this.sp.serviceType,
          area:     data.area = this.ap.areaType,
          name:     data.name = this.cus.name,
          phone:    data.phone = this.cus.phone,
          address:  data.address = this.cus.address,
          rn:       data.rn,
          rp:       data.rp,
          rl:       data.rl,
          note:     data.note,
          tp:       data.tp = this.sp.servicePrice + this.ap.areaPrice
          }])
      } 
  }

  sum(){
    this.servicePrice = this.sp.servicePrice;
    this.areaPrice = this.ap.areaPrice;
    return this.totalPrice = this.servicePrice + this.areaPrice;
  }

  save() {
    if (this.select.usernameSelect === '' || this.select.serviceSelect === '' || this.select.areaSelect === '' || this.receiverName === '' || this.receiverPhone === '' || this.receiverLocation === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/messengerOrders/' + this.select.usernameSelect + '/' + this.select.serviceSelect + '/' + this.select.areaSelect + '/' + this.receiverName + '/' + this.receiverPhone + '/' + this.receiverLocation + '/' + this.note,this.select)
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
