import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { HttpClient} from '@angular/common/http';
import { MessengerService } from '../service/messenger.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-messenger-show',
  templateUrl: './messenger-show.component.html',
  styleUrls: ['./messenger-show.component.css']
})
export class MessengerShowComponent implements OnInit {

  data:any={}

  constructor(private route:ActivatedRoute, private messengerService: MessengerService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    });
  }
  
  save() {
    this.httpClient.post('http://localhost:8080/messengerOrders/' + this.data.name + '/' + this.data.service + '/' + this.data.area + '/' + this.data.rn + '/' + this.data.rp + '/' + this.data.rl + '/' + this.data.note,this.data)
    .subscribe(
      data =>   {console.log('PUT Request is successful', data);},
      error =>  {console.log('Error', error);}
      );
    }
}
