import { TestBed } from '@angular/core/testing';

import { ImageeditService } from './imageedit.service';

describe('ImageeditService', () => {
  let service: ImageeditService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImageeditService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
