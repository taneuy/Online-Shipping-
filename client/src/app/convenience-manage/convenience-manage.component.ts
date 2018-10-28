import { Component, OnInit } from '@angular/core';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material';
import { Router } from '@angular/router';
import { ConvenienceService } from '../service/convenience.service';
import { ActivatedRoute } from '@angular/router';
import { map, filter } from 'rxjs/operators';
import { HttpClient} from '@angular/common/http';

export interface ProductElement {
  no: number;
  name: string;
}

@Component({
  selector: 'app-convenience-manage',
  templateUrl: './convenience-manage.component.html',
  styleUrls: ['./convenience-manage.component.css']
})
export class ConvenienceManageComponent implements OnInit {

  displayedColumns: string[] = ['select', 'no', 'name'];

  private id: number;
  private sub: any;

  products: Array<any>;
  selectProduct: Array<any>;

  private listProduct: any[] = [];

  selection = new SelectionModel<ProductElement>(true, []);


  private order = {
      id : '',
      adder : [],
      listProduct : []
    };

  constructor(private httpClient: HttpClient, private router: Router, private convenienceService: ConvenienceService,
                  private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
      this.id = +params['id'];
      console.log(this.id);
    });
    this.convenienceService.getOrderId(this.id).subscribe(data => {
      this.order = data;
      console.log(this.order);
    });
    this.convenienceService.getProducts().subscribe(data => {
      this.products = data;
      console.log(this.products);
    });
  }

    /** Whether the number of selected elements matches the total number of rows. */
    isAllSelected() {
      const numSelected = this.selection.selected.length;
      const numRows = this.products.length;
      if ( numSelected !== 0) {
        this.products[numSelected - 1].orderId = this.id;
        console.log(this.selection.selected);
      }
      return numSelected === numRows;
    }

    masterToggle() {
      this.isAllSelected() ?
      this.selection.clear() :
      this.products.forEach(row => this.selection.select(row));
    }
    cancel() {
      this.router.navigate(['convenience']);
    }

    save() {
      this.selectProduct = this.selection.selected;
      console.log(this.selectProduct);
      if (this.selectProduct.length === 0 ) {
        alert('กรุณาเลือก product ใน order');
      } else {
        this.listProduct = [];
        this.selectProduct.forEach(row => {
          this.listProduct.push(row.productName);
        });
        console.log(this.listProduct.toString());
        this.httpClient.post('http://localhost:8080/convenience/orders/addProduct/' + this.id + '/' + this.listProduct.toString(), this.products)
        .subscribe(
            data => {
                console.log('PUT Request is successful', data);
                this.router.navigate(['convenience-view/' + this.id]);
            },
            error => {
                console.log('Error', error);
            }
        );
      }
    }
}

