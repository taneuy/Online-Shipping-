import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConvenienceService {

  public API = '//localhost:8080';

    constructor(private http: HttpClient) { }

    private customer = new BehaviorSubject('default message');
    currentMessage = this.customer.asObservable();

    getMembers(): Observable<any> {
      return this.http.get(this.API + '/members');
    }
    getCustomers(): Observable<any> {
      return this.http.get(this.API + '/customers');
    }
    getProducts(): Observable<any> {
      return this.http.get(this.API + '/convenience/products');
    }
    getSetProducts(): Observable<any> {
      return this.http.get(this.API + '/convenience/setProducts');
    }
    getOrders(): Observable<any> {
      return this.http.get(this.API + '/convenience/orders');
    }

    adder(username: string) {
        this.customer.next(username);
    }
    getOrderId(id): Observable<any> {
      return this.http.get(this.API + '/convenience/orders/getdata/' + id);
    }
}
