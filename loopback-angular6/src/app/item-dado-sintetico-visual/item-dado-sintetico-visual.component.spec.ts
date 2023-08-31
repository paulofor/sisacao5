import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemDadoSinteticoVisualComponent } from './item-dado-sintetico-visual.component';

describe('ItemDadoSinteticoVisualComponent', () => {
  let component: ItemDadoSinteticoVisualComponent;
  let fixture: ComponentFixture<ItemDadoSinteticoVisualComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemDadoSinteticoVisualComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemDadoSinteticoVisualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
