import {inject, TestBed} from '@angular/core/testing';

import {TutorsService} from './tutors.service';

describe('TutorsService', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({
            providers: [TutorsService]
        });
    });

    it('should be created', inject([TutorsService], (service: TutorsService) => {
        expect(service).toBeTruthy();
    }));
});
