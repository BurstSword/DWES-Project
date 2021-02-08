import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Admin, Credential } from '../interfaces/interfaces';

@Injectable({ providedIn: 'root' })

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private _http: HttpClient) {

  }
  private baseUrl = 'http://localhost:8080/api/account/';

  loginAdmin(loginAdmin: Credential) {

    return this._http.post<any>(this.baseUrl + "loginAdmin", loginAdmin)


  }
  registerAdmin(registerAdmin: Credential) {

    return this._http.post<any>(this.baseUrl + "registerAdmin", registerAdmin)
  }
}