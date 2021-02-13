import { Component, OnInit } from '@angular/core';
import { Storage } from '@ionic/storage';
import { error } from 'protractor';
import { Cart, CartItem, Orders, Product } from 'src/app/interfaces/interfaces';
import Swal from 'sweetalert2'
import { ShopService } from '../../services/shop.service';
import { Restaurant, ProductsOrders } from '../../interfaces/interfaces';

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
  public productOrder:ProductsOrders;
  public product:Product;
  public cartRequest:Cart;
  public cartItems:CartItem[]=[];
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
    this.cartItems=[];
    this.cart.forEach(element => {
      console.log("Cantidad "+element.quantity);
      this.cartItems.push({
        id:element.id,
        quantity:element.quantity
      });
    });
    this.cartRequest={
      restaurant_id:this.restaurant.id,
      cartItems:this.cartItems
    }
    console.log(this.cartRequest);
    this.shopService.saveCartItems(this.cartRequest).subscribe(data=>{
      
      if(data==200){
        
        Swal.fire({
          icon: 'success',
          title: 'Confirmed payment',
          showConfirmButton: false,
          timer: 1500,
          allowOutsideClick:false,
          backdrop:false
        })
        this.cart=[];
        this.saveCart();
        this.total=0;
      }
    },error=>{
      
      if(error.error==415){
        Swal.fire({
          icon: 'error',
          title: 'User does not exist',
          showConfirmButton: false,
          timer: 1500,
          allowOutsideClick:false,
          backdrop:false
        })
      }else if(error.error==416){
        Swal.fire({
          icon: 'error',
          title: 'Insufficient stock :(',
          showConfirmButton: false,
          timer: 1500,
          allowOutsideClick:false,
          backdrop:false
        })
      }
    })
    
  }
}
