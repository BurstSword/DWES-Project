import { Component, OnInit } from '@angular/core';
import { Storage } from '@ionic/storage';
import { ProductsOrders, Restaurant } from 'src/app/interfaces/interfaces';
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
  ngOnInit() {
    this.getOrders();
  }

  async getOrders() {
    await this.storage.get('restaurant').then(rest => {
      if (rest) {
        
        this.restaurant = rest;
        
        console.log(this.restaurant);
      }
    })

    this.restaurant.ordersList.forEach(element => {
      this.ids.push(element.id);
    });

    await this.shopService.getOrders(this.ids).subscribe(data=>{
      if(data){
        this.orders=data;
        this.loaded=true;
        console.log(this.orders);
      }
    })
  }
}