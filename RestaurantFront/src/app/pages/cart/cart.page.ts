import { Component, OnInit } from '@angular/core';
import { Storage } from '@ionic/storage';
import { error } from 'protractor';
import { Orders, Product } from 'src/app/interfaces/interfaces';
import Swal from 'sweetalert2'
import { ShopService } from '../../services/shop.service';
import { Restaurant, ProductOrder } from '../../interfaces/interfaces';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.page.html',
  styleUrls: ['./cart.page.scss'],
})
export class CartPage implements OnInit {

  constructor(private storage: Storage, private shopService:ShopService) { }
  public cart: Product[] = [];
  public total:number=0;
  public order:Orders;
  public restaurant:Restaurant;
  public productOrder:ProductOrder;
  public product:Product;
  ngOnInit() {
    this.getCart();
    this.loadRestaurant();
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

  buy(){
    Swal.fire({
      icon: 'success',
      title: 'Confirmed payment',
      showConfirmButton: false,
      timer: 1500,
      allowOutsideClick:false,
      backdrop:false
    })
    this.saveOrder();
    
  }

  async loadRestaurant() {
    const rest = await this.storage.get('restaurant')
    if(rest){
      this.restaurant=rest;
      console.log(this.restaurant);
    }
  }

  saveOrder(){
    this.order={
    restaurant:this.restaurant,
    sent:0,
    v_Date:new Date()
    }
    this.cart.forEach(element => {
      this.product={
        categories:element.categories,
        name:element.name,
        price:element.price,
        stock:element.stock,
        weight:element.weight,
        description:element.description,
        id:element.id
      }
      this.productOrder={
        orders:this.order,
        product:this.product,
        units:element.quantity
      }
  
      console.log(this.productOrder);
      this.shopService.saveProductOrder(this.productOrder);
    });
    console.log(this.order)
    this.cart=[];
    this.calcTotal();
    this.saveCart();
  }
}
