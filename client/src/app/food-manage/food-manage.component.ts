import { Component, OnInit } from '@angular/core';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material';
import { Router } from '@angular/router';
import { FoodService } from '../service/food.service';
import { ActivatedRoute } from '@angular/router';
import { map, filter } from 'rxjs/operators';
import { HttpClient} from '@angular/common/http';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';


export interface MenuElement {
no: number;
name: string;
}

@Component({
  selector: 'app-food-manage',
  templateUrl: './food-manage.component.html',
  styleUrls: ['./food-manage.component.css']
})
export class FoodManageComponent implements OnInit {

  displayedColumns: string[] = ['select', 'no', 'image','name','price'];

  private id: number;
  private sub: any;

  menus: Array<any>;
  selectMenu: Array<any>;

  private listMenus: any[] = [];

  selection = new SelectionModel<MenuElement>(true, []);


  private order = {
      id : '',
      adder : [],
      listMenu: []
    };

    sum:any;
    url: any;


  constructor(private httpClient: HttpClient, private router: Router, private foodDeliveryService: FoodService,
                  private rout: ActivatedRoute, private sanitizer: DomSanitizer) { this.sanitizer = sanitizer; }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
      this.id = +params['id'];
      console.log(this.id);
    });
    this.foodDeliveryService.getFoodOrderId(this.id).subscribe(data => {
      this.order = data;
      console.log(this.order);
    });
    this.foodDeliveryService.getMenus().subscribe(data => {
      this.menus = data;
      console.log(this.menus);
    });
  }

    /** Whether the number of selected elements matches the total number of rows. */
    isAllSelected() {
      const numSelected = this.selection.selected.length;
      const numRows = this.menus.length;
      if ( numSelected !== 0) {
        this.menus[numSelected - 1].orderId = this.id;
      }
      return numSelected === numRows;
    }

    /** Selects all rows if they are not all selected; otherwise clear selection. */
    masterToggle() {
      this.isAllSelected() ?
      this.selection.clear() :
      this.menus.forEach(row => this.selection.select(row));
    }

    cancel() {
      this.router.navigate(['food']);
    }

    save() {
      this.selectMenu= this.selection.selected;
      console.log(this.selectMenu);
      if (this.selectMenu.length === 0 ) {
        alert('กรุณาเลือกเมนูที่ต้องการ');
      } else {
        this.listMenus = [];
        this.selectMenu.forEach(row => {

          this.listMenus.push(row.foodMenuName);

        });
        console.log(this.listMenus.toString());
        this.httpClient.post('http://localhost:8080/food/orders/addMenu/' + this.id + '/' + this.listMenus.toString(), this.menus)
        .subscribe(
            data => {
                console.log('PUT Request is successful', data);
                this.sum = data;
                this.router.navigate(['food-view/' + this.id,{sum:this.sum}]);
            },
            error => {
                console.log('Error', error);
            }
        );
      }
    }

    summ() {
      this.httpClient.get('http://localhost:8080/food/orders/sum/')
        .subscribe(
            data => {
                console.log('PUT Request is successful', data);
                this.sum = data;
                this.router.navigate(['food-view/' + this.id + '/' + this.sum]);
            },
            error => {
                console.log('Error', error);
            }
        );
    }

   imageURL(code) {
     this.url = 'https://www.img.live/images/2018/10/27/' + code ;
    return this.sanitizer.bypassSecurityTrustResourceUrl(this.url);
  }
}
