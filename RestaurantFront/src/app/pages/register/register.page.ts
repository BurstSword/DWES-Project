import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Restaurant } from 'src/app/interfaces/interfaces';
import { RestaurantService } from '../../services/restaurant.service';
import Swal from 'sweetalert2'
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  public registerForm: FormGroup;
  constructor(private router: Router, private formBuilder: FormBuilder, private restaurantService: RestaurantService) { }
  private restaurant: Restaurant;

  ngOnInit() {
    this.createForm();
  }



  register() {
    if (this.registerForm.invalid) return
    this.restaurant = this.registerForm.value;

    this.restaurantService.registerRestaurant(this.restaurant).subscribe(
      data => {
        ;
        
        if (data == 200) {
          Swal.fire({
            icon: 'success',
            title: 'Registered successfully',
            showConfirmButton: false,
            timer: 1500
          }).then((result) => {
            if (result.isDismissed) {
              this.router.navigate(['/login']);
            }
          })
        }
      }, error => {
        Swal.fire({
          icon: 'error',
          title: 'That email already exists',
          showConfirmButton: false,
          timer: 1500
        })
      }
    )

  }

  get mail() {
    return this.registerForm.get('mail')
  }
  get pwd() {
    return this.registerForm.get('pwd')
  }
  get country() {
    return this.registerForm.get('country')
  }
  get city() {
    return this.registerForm.get('city')
  }
  get address() {
    return this.registerForm.get('address')
  }
  get cp() {
    return this.registerForm.get('cp')
  }

  createForm() {
    this.registerForm = this.formBuilder.group({
      mail: ['', [Validators.required, Validators.email, Validators.maxLength(50)]],
      pwd: ['', [Validators.required, Validators.minLength(8),
      Validators.maxLength(200)]],
      country: ['', [Validators.required, Validators.maxLength(50)]],
      city: ['', [Validators.required, Validators.maxLength(50)]],
      address: ['', [Validators.required, Validators.maxLength(50)]],
      cp: ['', [Validators.required, Validators.pattern('^([0-9]{5})$')]]
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
    ],
    'country': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 50 characters' },
    ],
    'city': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 50 characters' },
    ],
    'address': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 50 characters' },
    ],
    'cp': [
      { type: 'required', message: 'Required' },
      { type: 'pattern', message: 'Spanish postalCode (5 numbers)' },
    ]
  }
}
