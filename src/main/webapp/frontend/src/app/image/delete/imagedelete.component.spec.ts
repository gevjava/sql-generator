import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImagedeleteComponent } from './imagedelete.component';

describe('ImagedeleteComponent', () => {
  let component: ImagedeleteComponent;
  let fixture: ComponentFixture<ImagedeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImagedeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImagedeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
