import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubissuerComponent } from './subissuer.component';

describe('SubissuerComponent', () => {
  let component: SubissuerComponent;
  let fixture: ComponentFixture<SubissuerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubissuerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubissuerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
