import { Component, Input} from '@angular/core';
import { ModalController, ToastController } from '@ionic/angular';
import { Storage } from '@ionic/storage';
import { Category, Product } from 'src/app/interfaces/interfaces';

@Component({
  selector: 'app-modal-bar',
  templateUrl: './product-modal.page.html',
  styleUrls: ['./product-modal.page.scss'],
})
export class ProductModalPage {
  

  constructor(private ModalController: ModalController, private storage: Storage, private toastController:ToastController) { }
  @Input() category: Category;
 
  public cart: Product[] = [];

  ionViewWillEnter(){
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

  async presentToast() {
    const toast = await this.toastController.create({
      message: "Successfully added",
      duration: 2000
    });
    toast.present();
  }
  async saveCart() {
    await this.storage.set("cart", this.cart);
  }

  addItemToCart(product: Product) {
    let exist = false;
    for (let index = 0; index < this.cart.length; index++) {
      if (this.cart[index].name == product.name) {
        exist = true;
      }
      if (exist) {
        this.cart[index].quantity+=1;
        this.saveCart();
      } 
      
    }
    if(!exist){
      product.quantity = 1;
      this.cart.push(product);
      this.saveCart();
    }
     
    
    this.presentToast();
  }

  async exit() {
    await this.ModalController.dismiss();
  }

  

    

    
}
