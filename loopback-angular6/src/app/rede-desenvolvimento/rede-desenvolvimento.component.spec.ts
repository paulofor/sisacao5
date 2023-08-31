import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RedeDesenvolvimentoComponent } from './rede-desenvolvimento.component';

describe('RedeDesenvolvimentoComponent', () => {
  let component: RedeDesenvolvimentoComponent;
  let fixture: ComponentFixture<RedeDesenvolvimentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RedeDesenvolvimentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RedeDesenvolvimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
