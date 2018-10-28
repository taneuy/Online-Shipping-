import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

   public API = '//localhost:8080';

    constructor(private http: HttpClient) { }

    private customer = new BehaviorSubject('default message');
    currentMessage = this.customer.asObservable();

    getCustomers(): Observable<any> {
      return this.http.get(this.API + '/customers');
    }
    getMenus(): Observable<any> {
      return this.http.get(this.API + '/food/menus');
    }
    getBaskets(): Observable<any> {
      return this.http.get(this.API + '/food/baskets');
    }
    getOrders(): Observable<any> {
      return this.http.get(this.API + '/food/orders');
    }

    adder(username: string) {
        this.customer.next(username);
    }
    getFoodOrderId(id): Observable<any> {
      return this.http.get(this.API + '/food/orders/getdata/' + id);
    }
}
