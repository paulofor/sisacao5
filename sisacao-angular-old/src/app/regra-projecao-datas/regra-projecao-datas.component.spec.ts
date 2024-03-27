import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegraProjecaoDatasComponent } from './regra-projecao-datas.component';

describe('RegraProjecaoDatasComponent', () => {
  let component: RegraProjecaoDatasComponent;
  let fixture: ComponentFixture<RegraProjecaoDatasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegraProjecaoDatasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegraProjecaoDatasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
