import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class TaxiService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }
  getCustomers(): Observable<any> {
    return this.http.get(this.API + '/customers');
  }
  getMembers(): Observable<any> {
    return this.http.get(this.API + '/members');
  }
  getCarServices(): Observable<any> {
    return this.http.get(this.API + '/taxi/CarServices');
  }
  getAreas(): Observable<any> {
    return this.http.get(this.API + '/taxi/areas');
  }
  getOrders(): Observable<any> {
    return this.http.get(this.API + '/taxi/orders');
  }
  getCustomerDetail(name: number): Observable<any> {
    return this.http.get(this.API + '/customers/getById/' + name);
  }
  getCarServiceDetail(carservice:number): Observable<any> {
    return this.http.get(this.API + '/taxi/service/getByServiceId/' + carservice);
  }
  getAreaDetail(area:number): Observable<any> {
    return this.http.get(this.API + '/taxi/areas/getByAreaId/' + area);
  }
}
