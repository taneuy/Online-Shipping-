import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { MessengerService } from '../service/messenger.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  customer:any = {
    username:'',
    password:'',
    name:'',
    phone:'',
    email:'',
    address:'',
  }

  constructor(private messengerService: MessengerService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
  }

  create(){
    this.httpClient.post('http://localhost:8080/customers/' + 
    this.customer.username + '/' + 
    this.customer.password + '/' + 
    this.customer.name  + '/' + 
    this.customer.phone  + '/' + 
    this.customer.email  + '/' + 
    this.customer.address,this.customer)
    .subscribe(
      data =>   {
        console.log('PUT Request is successful', data);
      },
      error =>  {
        console.log('Error', error);
      }
    );
  }

}
