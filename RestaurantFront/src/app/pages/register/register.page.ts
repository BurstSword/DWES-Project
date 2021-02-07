import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  public registerForm: FormGroup;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.createForm();
  }


  register() {
    if (this.registerForm.invalid) return
    console.log("Patata");
  }

  get mail() {
    return this.registerForm.get('mail')
  }
  get password() {
    return this.registerForm.get('password')
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
  get postCode() {
    return this.registerForm.get('postCode')
  }

  createForm() {
    this.registerForm = this.formBuilder.group({
      mail: ['', [Validators.required, Validators.email, Validators.maxLength(50)]],
      password: ['', [Validators.required, Validators.minLength(8),
      Validators.maxLength(200)]],
      country: ['', [Validators.required, Validators.maxLength(50)]],
      city: ['', [Validators.required, Validators.maxLength(50)]],
      address: ['', [Validators.required, Validators.maxLength(50)]],
      postCode: ['', [Validators.required, Validators.pattern('^([0-9]{5})$')]]
    })
  }

  validationMessages = {
    'mail': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 50 characters' },
      { type: 'email', message: 'Valid email' },
    ],
    'password': [
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
    'postalCode': [
      { type: 'required', message: 'Required' },
      { type: 'pattern', message: 'Spanish postalCode (5 numbers)' },
    ]
  }
}
