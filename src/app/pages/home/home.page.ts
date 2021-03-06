import { Component} from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Storage } from '@ionic/storage';
import { Category, Product, Restaurant } from 'src/app/interfaces/interfaces';
import { ShopService } from 'src/app/services/shop.service';
import { ProductModalPage } from 'src/app/pages/product-modal/product-modal.page';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage {

  constructor(private storage: Storage, private shopService: ShopService, private modalController: ModalController) { }
  public restaurant: Restaurant = {};
  public categories: Category[] = [];
  public products: Product[] = [];
  
  

  ionViewWillEnter(){
    this.loadRestaurant();
    this.getCategories();
  }

 async loadRestaurant() {
    const rest = await this.storage.get('restaurant')
    if(rest){
      this.restaurant=rest;
    }
  }

  

  async getCategories() {
    await this.shopService.getCategories().subscribe(
      data => {
        this.categories = data;
      }
    )

  }

  async showProducts(category: Category) {
    const modal = await this.modalController.create({
      component: ProductModalPage,
      cssClass: 'my-custom-modal-css',
      componentProps: {
        category
      }
    })
    await modal.present();
  }
}
