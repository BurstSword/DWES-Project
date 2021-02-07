import { Component, OnInit } from '@angular/core';
import { Credential } from 'src/app/interfaces/interfaces';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private adminService:AdminService) { }
  public admin:Credential
  ngOnInit() {
    this.admin={
     mail:"",
     pwd:""
    }
  }

  login(){
    console.log(this.admin);
    this.adminService.loginAdmin(this.admin);
  }


}
