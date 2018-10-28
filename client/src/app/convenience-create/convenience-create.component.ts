import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { ConvenienceService } from '../service/convenience.service';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-convenience-create',
  templateUrl: './convenience-create.component.html',
  styleUrls: ['./convenience-create.component.css']
})
export class ConvenienceCreateComponent implements OnInit {

    userName = '';
    constructor(private httpClient: HttpClient, private convenienceService: ConvenienceService, private dialogRef:MatDialogRef<ConvenienceCreateComponent>) { }

    ngOnInit() {
      this.convenienceService.currentMessage.subscribe(message => this.userName  = message);
      console.log(this.userName);
    }

    save() {
      if (this.userName === '') {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      } else {
        this.httpClient.post('http://localhost:8080/convenience/orders/new' + '/' +  this.userName, this.userName)
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

