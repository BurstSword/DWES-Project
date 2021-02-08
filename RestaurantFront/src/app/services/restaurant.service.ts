import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Credential, Restaurant} from '../interfaces/interfaces';

@Injectable({ providedIn: 'root' })

@Injectable({
    providedIn: 'root'
})
export class RestaurantService {

    constructor(private _http: HttpClient) {

    }
    private baseUrl = 'http://localhost:8080/api/account/';

    loginRestaurant(loginRestaurant: Credential) {

        return this._http.post<any>(this.baseUrl + "loginRestaurant", loginRestaurant);
    }

    registerRestaurant(registerRestaurant: Restaurant) {

        return this._http.post<any>(this.baseUrl + "registerRestaurant", registerRestaurant)
    }
}