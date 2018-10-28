import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { FoodService } from '../service/food.service';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-food-create',
  templateUrl: './food-create.component.html',
  styleUrls: ['./food-create.component.css']
})

export class FoodCreateComponent implements OnInit {

  userName = '';
  constructor(private httpClient: HttpClient, private fooddeliveryService: FoodService, private dialogRef:MatDialogRef<FoodCreateComponent>) { }

  ngOnInit() {
    this.fooddeliveryService.currentMessage.subscribe(message => this.userName  = message);
    console.log(this.userName);
  }

  save() {
    if (this.userName === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/food/orders/new' + '/' +  this.userName, this.userName)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.dialogRef.close();
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }
}