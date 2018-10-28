import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class PostalService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<any> {
    return this.http.get(this.API + '/customers');
  }
  getPostalCategories(): Observable<any> {
    return this.http.get(this.API + '/postal/categories');
  }
  getPostalAmounts(): Observable<any> {
    return this.http.get(this.API + '/postal/amounts');
  }
  getPostalOrders(): Observable<any> {
    return this.http.get(this.API + '/postal/orders');
  }
  createPostalOrders(postalOrder: Object): Observable<Object> {
    return this.http.post(this.API + '/postal/orders/create', postalOrder);
  }
}
