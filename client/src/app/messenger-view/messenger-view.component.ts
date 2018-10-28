import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { MessengerService } from '../service/messenger.service';
import {Router} from "@angular/router";
import { Location } from '@angular/common';


@Component({
  selector: 'app-messenger-view',
  templateUrl: './messenger-view.component.html',
  styleUrls: ['./messenger-view.component.css']
})
export class MessengerViewComponent implements OnInit {

  orders: Array<any>;

  displayedColumns: string[] = ['no', 'serviceType', 'areaType',
                                  'customerName','customerPhone','customerAddress',
                                  'receiverName','receiverPhone','receiverAddress',
                                  'note','totalPrice'];

  constructor(private messengerService: MessengerService , private httpClient: HttpClient, private router:Router,private location: Location) { }

  pageRefresh() {
    location.reload();
 }

  ngOnInit() {
    this.messengerService.getOrders().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
  }
}
