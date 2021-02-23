import { Component, OnInit } from '@angular/core';
import { Storage } from '@ionic/storage';
import { Restaurant } from 'src/app/interfaces/interfaces';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.page.html',
  styleUrls: ['./profile.page.scss'],
})
export class ProfilePage implements OnInit {

  constructor(private storage:Storage) { }
  public restaurant:Restaurant;
  
  ngOnInit() {
    this.getRestaurant();
  }

  getRestaurant(){
    this.storage.get("restaurant").then(resp=>{
      this.restaurant=resp;
    })
  }
}
