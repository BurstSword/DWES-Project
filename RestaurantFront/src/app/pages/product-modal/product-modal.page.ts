import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Storage } from '@ionic/storage';
import { Category, Product } from 'src/app/interfaces/interfaces';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-modal-bar',
  templateUrl: './product-modal.page.html',
  styleUrls: ['./product-modal.page.scss'],
})
export class ProductModalPage implements OnInit {

  constructor(private ModalController: ModalController, private storage: Storage) { }
  @Input() category: Category
  public cart: Product[] = [];
  ngOnInit() {
    this.getCart();
  }

  getCart() {
    this.storage.get("cart").then(rest => {
      if (rest != null) {
        this.cart = rest;
      }
    }
    )
  }

  saveCart() {
    this.storage.set("cart", this.cart);
  }

  addItemToCart(product: Product) {
    let exist = false;
    for (let index = 0; index < this.cart.length; index++) {
      if (this.cart[index].name == product.name) {
        exist = true;
      }

    }
    if (exist == true) {
      Swal.fire({
        icon: 'warning',
        title: 'Already added to cart',
        showConfirmButton: false,
        timer: 1500,
        allowOutsideClick: false,
        backdrop: false
      })
    } else {
      product.quantity = 1;
      //product.categories=this.category;
      this.cart.push(product);
      Swal.fire({
        icon: 'success',
        title: 'Successfully added',
        showConfirmButton: false,
        timer: 1500,
        allowOutsideClick: false,
        backdrop: false
      })
      this.saveCart();
    }
  }

  exit() {
    this.ModalController.dismiss();
  }

}
