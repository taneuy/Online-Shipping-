import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { ConvenienceService } from '../service/convenience.service';
import { Router } from "@angular/router";
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { ConvenienceCreateComponent } from '../convenience-create/convenience-create.component';

@Component({
  selector: 'app-convenience-order',
  templateUrl: './convenience-order.component.html',
  styleUrls: ['./convenience-order.component.css']
})
export class ConvenienceOrderComponent implements OnInit {

  customers: Array<any>;
  orders: Array<any>;
  usernameSelect = '';

  name: string;
  dataColumns: string[] = ['no', 'customer', 'add', 'view'];

  constructor(private convenienceService: ConvenienceService , private httpClient: HttpClient, private router:Router, private  dialog: MatDialog) { }

  ngOnInit() {
  this.convenienceService.getCustomers().subscribe(data => {
    this.customers = data;
    console.log(this.customers);
  });
  this.convenienceService.getOrders().subscribe(data => {
    this.orders = data;
    console.log(this.orders);
  });
  }

  openDialog(): void {
    this.convenienceService.adder(this.usernameSelect);
    const dialogRef = this.dialog.open(ConvenienceCreateComponent, {});
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.ngOnInit();
    });
  }

  manageTeam(element): void {
    this.router.navigate(['convenience-manage/' + element.orderId]);
  }
  viewConvenienceOrder(element): void {
    this.router.navigate(['convenience-view/' + element.orderId]);
  }
}









