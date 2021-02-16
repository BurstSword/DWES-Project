import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Credential, Restaurant } from 'src/app/interfaces/interfaces';
import { RestaurantService } from 'src/app/services/restaurant.service';
import Swal from 'sweetalert2'
import { Storage } from '@ionic/storage';
import { MenuController } from '@ionic/angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private router: Router, private formBuilder: FormBuilder, private restaurantService: RestaurantService, private storage: Storage, public menuCtrl: MenuController) { }
  public admin: Credential;
  public loginForm: FormGroup;
  public restaurant: Restaurant;
  ngOnInit() {
    this.menuCtrl.swipeGesture(false);
    this.createForm();
    this.storage.clear();
  }

  login() {
    if (this.loginForm.invalid) return
    this.restaurant = this.loginForm.value;
    this.restaurantService.loginRestaurant(this.restaurant).subscribe(
      data => {
        if (data) {
          this.restaurant = data;
          this.storage.set("restaurant", this.restaurant);
          Swal.fire({
            icon: 'success',
            title: 'Logged successfully',
            showConfirmButton: false,
            timer: 1500,
            allowOutsideClick:false,
            
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
          timer: 1500,
          allowOutsideClick:false,
          
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
      mail: ['', [Validators.required, Validators.email, Validators.maxLength(255)]],
      pwd: ['', [Validators.required, Validators.minLength(8),Validators.maxLength(255)]]
    })
  }
  validationMessages = {
    'mail': [
      { type: 'required', message: 'Mail required' },
      { type: 'maxlength', message: 'Max length of 255 characters' },
      { type: 'email', message: 'Valid email format' },
    ],
    'pwd': [
      { type: 'required', message: 'Password required' },
      { type: 'minlength', message: 'Min length of 8 characters' },
      { type: 'maxlength', message: 'Max length of 255 characters' }
    ]
  }
}
