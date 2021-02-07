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
    return new Promise<Admin>(resolve => {
      this._http.post<any>(this.baseUrl + "loginAdmin", loginAdmin).subscribe(resp => {
        resolve(resp);
      });
    });

  }
  registerAdmin(registerAdmin: Credential) {
    return new Promise<any>(resolve => {
      this._http.post<any>(this.baseUrl + "registerAdmin", registerAdmin).subscribe(resp => {
        resolve(resp);
      });
    });

  }
}