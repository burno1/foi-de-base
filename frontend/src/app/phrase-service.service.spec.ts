import { TestBed } from '@angular/core/testing';

import { PhraseService } from './phrase.service';

describe('PhraseServiceService', () => {
  let service: PhraseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PhraseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
