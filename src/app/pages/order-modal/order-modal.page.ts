import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Product } from 'src/app/interfaces/interfaces';

@Component({
  selector: 'app-order-modal',
  templateUrl: './order-modal.page.html',
  styleUrls: ['./order-modal.page.scss'],
})
export class OrderModalPage implements OnInit {

  constructor(private modalController:ModalController) { }
  @Input() products:Product[]
  ngOnInit() {
  }

  async exit() {
    await this.modalController.dismiss();
  }
}
