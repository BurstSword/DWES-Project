import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Orders, ProductOrder } from '../interfaces/interfaces';

@Injectable({ providedIn: 'root' })

@Injectable({
    providedIn: 'root'
})
export class ShopService {

    constructor(private _http: HttpClient) {

    }
    private baseUrl = 'http://localhost:8080/api/user/';

    getCategories() {
        return this._http.get<any>(this.baseUrl + "categoryList");
    }

    saveProductOrder(order:ProductOrder) {
        console.log(order);
        return this._http.post<any>(this.baseUrl + "saveOrder",order);
    }

   
}