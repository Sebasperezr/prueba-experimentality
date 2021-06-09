import { TestBed } from '@angular/core/testing';

import { SearhcService } from './searhc.service';

describe('SearhcService', () => {
  let service: SearhcService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearhcService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
