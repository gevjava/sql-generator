import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletesubissuerComponent } from './deletesubissuer.component';

describe('DeletesubissuerComponent', () => {
  let component: DeletesubissuerComponent;
  let fixture: ComponentFixture<DeletesubissuerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletesubissuerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletesubissuerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
