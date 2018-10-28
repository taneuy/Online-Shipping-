import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { MessengerService } from '../service/messenger.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  customer: any ={
    username:'',
    password:''
  }

  check:any =''
  constructor(private messengerService: MessengerService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
  }

  login(){
    if (this.customer.username === '' || this.customer.password === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.get('http://localhost:8080/customers/' + this.customer.username + '/' + this.customer.password,this.customer)
      .subscribe(
        data =>   {
          this.check = data;
          console.log('PUT Request is successful', data);
          if (this.check === true) {
            // alert('login sucessful');
            this.router.navigate(['home',{
              }]);
          } else {
            alert('username หรือ password ของท่านไม่ถูกต้อง กรุณา login ใหม่');
          }
        },
        error =>  {
          console.log('Error', error);
        }
      );
    }

  }

}
