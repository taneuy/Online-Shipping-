import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { ConvenienceService } from '../service/convenience.service';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';

export interface ProductElement {
  no: number;
  name: string;
}

@Component({
  selector: 'app-convenience-view',
  templateUrl: './convenience-view.component.html',
  styleUrls: ['./convenience-view.component.css']
})
export class ConvenienceViewComponent implements OnInit {

  displayedColumns: string[] = ['no', 'name'];
    private sub: any;
    private id: number;

    private order = {
      id : '',
      adder : {},
      listProduct : []
    };
    url: any;

    constructor(private router: Router, private rout: ActivatedRoute, private convenienceService: ConvenienceService,
      private sanitizer: DomSanitizer) {
      this.sanitizer = sanitizer;
    }
    ngOnInit() {
      this.sub = this.rout.params.subscribe(params => {
        this.id = +params['id'];
        console.log(this.id);
      });
      this.convenienceService.getOrderId(this.id).subscribe(data => {
        this.order = data;
        console.log(this.order);
      });
    }
    cancel() {
          this.router.navigate(['convenience']);
        }
}

