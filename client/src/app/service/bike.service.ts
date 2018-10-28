import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class BikeService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getMembers(): Observable<any> {
    return this.http.get(this.API + '/members');
  }
  getCustomers(): Observable<any> {
    return this.http.get(this.API + '/customers');
  }
  getPayments(): Observable<any> {
    return this.http.get(this.API + '/bike/payments');
  }
  getAreas(): Observable<any> {
    return this.http.get(this.API + '/bike/areas');
  }
  getOrders(): Observable<any> {
    return this.http.get(this.API + '/bike/orders');
  }
  getCustomerDetail(name: number): Observable<any> {
    return this.http.get(this.API + '/customers/getById/' + name);
  }
  getPaymentDetail(payment:number): Observable<any> {
    return this.http.get(this.API + '/bike/payments/getByPaymentId/' + payment);
  }
  getAreaDetail(area:number): Observable<any> {
    return this.http.get(this.API + '/bike/areas/getByAreaId/' + area);
  }
}
