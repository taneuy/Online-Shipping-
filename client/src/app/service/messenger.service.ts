import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class MessengerService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getMembers(): Observable<any> {
    return this.http.get(this.API + '/members');
  }
  getCustomers(): Observable<any> {
    return this.http.get(this.API + '/customers');
  }
  getServices(): Observable<any> {
    return this.http.get(this.API + '/messenger/services');
  }
  getAreas(): Observable<any> {
    return this.http.get(this.API + '/messenger/areas');
  }
  getOrders(): Observable<any> {
    return this.http.get(this.API + '/messenger/orders');
  }
  getCustomerDetail(name): Observable<any> {
    return this.http.get(this.API + '/customers/getById/' + name);
  }
  getServiceDetail(service): Observable<any> {
    return this.http.get(this.API + '/messenger/services/getByServiceId/' + service);
  }
  getAreaDetail(area): Observable<any> {
    return this.http.get(this.API + '/messenger/areas/getByAreaId/' + area);
  }
}
