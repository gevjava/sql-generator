import { TestBed } from '@angular/core/testing';

import { DeleteimageserviceService } from './deleteimageservice.service';

describe('DeleteimageserviceService', () => {
  let service: DeleteimageserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteimageserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
