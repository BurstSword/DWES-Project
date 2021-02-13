import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cart} from '../interfaces/interfaces';

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

    saveCartItems(cart:Cart) {
        
        return this._http.post<any>(this.baseUrl + "saveOrder",cart);
    }

    getOrders(id:number) {
        return this._http.get<any>(this.baseUrl + "categoryList");
    }
   
}