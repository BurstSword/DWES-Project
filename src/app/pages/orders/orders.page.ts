import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Storage } from '@ionic/storage';
import { History, Orders, Product, ProductsOrders, Restaurant } from 'src/app/interfaces/interfaces';
import { ShopService } from 'src/app/services/shop.service';
import { OrderModalPage } from '../order-modal/order-modal.page';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.page.html',
  styleUrls: ['./orders.page.scss'],
})
export class OrdersPage implements OnInit {

  constructor(private shopService: ShopService, private storage: Storage, private modalController:ModalController) { }
  public orders: ProductsOrders[] = [];
  public restaurant: Restaurant = {};
  public ids: number[] = [];
  public loaded: boolean = false;
  public mapProducts = new Map<number, Product[]>();
  public mapOrders = new Map<number, Orders>();
  ngOnInit() {
    this.getRestaurant();
  }

  async getRestaurant() {
    await this.storage.get('restaurant').then(rest => {
      if (rest) {
        this.restaurant = rest;
      }
    })

    await this.shopService.getRestaurant(this.restaurant).subscribe(data => {
      if (data) {
        this.restaurant = data;
        this.getOrdersWithRestaurant()
      }
    })


  }

  async getOrdersWithRestaurant() {

    this.restaurant.ordersList.forEach(element => {
      this.ids.push(element.id);
    });

    await this.shopService.getOrders(this.ids).subscribe(
      data => {
        if (data) {
          this.orders = data;
          this.orders.forEach(element => {
            if (!this.mapProducts.has(element.orders.id)) {
              this.mapProducts.set(element.orders.id, []);
              this.mapOrders.set(element.orders.id, element.orders);
            }
            this.mapProducts.get(element.orders.id).push(element.products);
          })
          console.log(this.mapOrders);
          console.log(this.mapProducts);
        }
      })
  }

  async showProducts(products: Product[]) {
    const modal = await this.modalController.create({
      component: OrderModalPage,
      cssClass: 'productsModal',
      componentProps: {
        products
      }
    })
    await modal.present();
  }
}