import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { OrderModalPage } from './order-modal.page';

describe('OrderModalPage', () => {
  let component: OrderModalPage;
  let fixture: ComponentFixture<OrderModalPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderModalPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(OrderModalPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
