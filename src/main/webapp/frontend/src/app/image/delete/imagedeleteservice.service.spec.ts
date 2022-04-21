import { TestBed } from '@angular/core/testing';

import { ImagedeleteserviceService } from './imagedeleteservice.service';

describe('ImagedeleteserviceService', () => {
  let service: ImagedeleteserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImagedeleteserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
