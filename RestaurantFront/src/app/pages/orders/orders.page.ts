import { Component, OnInit } from '@angular/core';
import { Storage } from '@ionic/storage';
import { History, ProductsOrders, Restaurant } from 'src/app/interfaces/interfaces';
import { ShopService } from 'src/app/services/shop.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.page.html',
  styleUrls: ['./orders.page.scss'],
})
export class OrdersPage implements OnInit {

  constructor(private shopService: ShopService, private storage: Storage) { }
  public orders: ProductsOrders[] = [];
  public restaurant: Restaurant={};
  public ids:number[]=[];
  public loaded:boolean=false;
  public history:History[]=[];
  ngOnInit() {
    this.getRestaurant();
  }

  async getRestaurant() {
    await this.storage.get('restaurant').then(rest => {
      if (rest) {
        this.restaurant = rest;
      }
    })
    
    await this.shopService.getRestaurant(this.restaurant).subscribe(data=>{
      if(data){
        this.restaurant=data;
        this.getOrdersWithRestaurant()
      }
    })

    
  }

  async getOrdersWithRestaurant(){

    this.restaurant.ordersList.forEach(element => {
      this.ids.push(element.id);
    });

    await this.shopService.getOrders(this.ids).subscribe(
      data=>{
      if(data){
        this.orders=data;
        this.orders=this.orders.filter((v,i,a)=>a.findIndex(t=>(t.id.orderId===v.id.orderId && t.id.orderId===v.id.orderId))===i);
      }
    })
  }
}