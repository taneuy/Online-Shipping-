import { TestBed, inject } from '@angular/core/testing';

import { ConvenienceService } from './convenience.service';

describe('ConvenienceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConvenienceService]
    });
  });

  it('should be created', inject([ConvenienceService], (service: ConvenienceService) => {
    expect(service).toBeTruthy();
  }));
});
