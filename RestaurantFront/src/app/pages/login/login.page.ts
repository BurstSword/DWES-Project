import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Credential, Restaurant } from 'src/app/interfaces/interfaces';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { AdminService } from '../../services/admin.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private adminService:AdminService, private router: Router, private formBuilder: FormBuilder, private restaurantService: RestaurantService) { }
  public admin:Credential;
  public loginForm: FormGroup;
  public restaurant:Restaurant;
  ngOnInit() {
    this.createForm()
  }

  login(){
    if (this.loginForm.invalid) return
    this.restaurant = this.loginForm.value;
    console.log(this.restaurant)
    this.restaurantService.loginRestaurant(this.restaurant).subscribe(
      data => {
        ;
        
        if (data !=null) {
          Swal.fire({
            icon: 'success',
            title: 'Logged successfully',
            showConfirmButton: false,
            timer: 1500
          }).then((result) => {
            if (result.isDismissed) {
              this.router.navigate(['/home']);
            }
          })
        }
      }, error => {
        Swal.fire({
          icon: 'error',
          title: 'Wrong credentials',
          showConfirmButton: false,
          timer: 1500
        })
      }
    )
  }

  get mail() {
    return this.loginForm.get('mail')
  }
  get pwd() {
    return this.loginForm.get('pwd')
  }

 

  createForm() {
    this.loginForm = this.formBuilder.group({
      mail: ['', [Validators.required, Validators.email, Validators.maxLength(50)]],
      pwd: ['', [Validators.required, Validators.minLength(8)]]
    })
  }
  validationMessages = {
    'mail': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 50 characters' },
      { type: 'email', message: 'Valid email' },
    ],
    'pwd': [
      { type: 'required', message: 'Required' },
      { type: 'minlength', message: 'Min length of 8 characters' },
      { type: 'maxlength', message: 'Max length of 40 characters' }
    ]
  }
}
