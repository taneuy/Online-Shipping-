import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { FoodService } from '../service/food.service';
import { Router } from "@angular/router";
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { FoodCreateComponent } from '../food-create/food-create.component';

@Component({
  selector: 'app-food-order',
  templateUrl: './food-order.component.html',
  styleUrls: ['./food-order.component.css']
})
export class FoodOrderComponent implements OnInit {

  customers: Array<any>;
  orders: Array<any>;
  usernameSelect = '';
  customerName = '';

  name: string;
  dataColumns: string[] = ['no', 'customer', 'add', 'view'];

  constructor(private foodDeliveryService: FoodService, private httpClient: HttpClient, private router:Router,  private  dialog: MatDialog) { }

  ngOnInit() {
  this.foodDeliveryService.getCustomers().subscribe(data => {
    this.customers = data;
    console.log(this.customers);
  });
  this.foodDeliveryService.getOrders().subscribe(data => {
    this.orders = data;
    console.log(this.orders);
  });
  }


  openDialog(): void {
    this.foodDeliveryService.adder(this.usernameSelect);
    const dialogRef = this.dialog.open(FoodCreateComponent, {});
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.ngOnInit();
    });
  }

  manageTeam(element): void {
    this.router.navigate(['food-manage/' + element.orderId]);
  }
  viewPlaylist(element): void {
    this.router.navigate(['food-view/' + element.orderId]);
  }


}
