import { Component, OnInit } from '@angular/core';
import { Storage } from '@ionic/storage';
import { Product } from 'src/app/interfaces/interfaces';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.page.html',
  styleUrls: ['./cart.page.scss'],
})
export class CartPage implements OnInit {

  constructor(private storage: Storage) { }
  public cart: Product[] = [];
  public total:number=0;
  ngOnInit() {
    this.getCart();
    
  }

  getCart() {
    this.storage.get("cart").then(rest => {
      if (rest != null) {
        this.cart = rest;
        this.calcTotal();
      }
    }
    )
  }

  addItem(product:Product){
    const index = this.cart.findIndex(prod=>prod.name==product.name);

    if(index>-1){
      this.cart[index].quantity+=1
      this.calcTotal();
      this.saveCart();
    }
  }

  sustractItem(product:Product){
    const index = this.cart.findIndex(prod=>prod.name==product.name);

    if(index>-1){
      if(this.cart[index].quantity>1){
        this.cart[index].quantity-=1
        this.calcTotal();
        this.saveCart();
      }
      
    }
  }
  saveCart(){
    this.storage.set("cart", this.cart);
  }

  calcTotal(){
    this.total=0;
    for (let index = 0; index < this.cart.length; index++) {
      this.total+=this.cart[index].quantity*this.cart[index].price;
      
    }
  }
}
