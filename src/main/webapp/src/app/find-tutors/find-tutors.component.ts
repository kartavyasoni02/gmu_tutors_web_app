import {Component, OnInit} from '@angular/core';
import {Tutor} from "../shared/tutor.obj";
import {TutorService} from "../shared/tutor.service";
import {SearchPayload} from "../shared/search.payload.obj";
import {DateRange} from "../shared/date.range.obj";
import {Locations} from "../shared/location.enum";

@Component({
  selector: 'app-find-tutors',
  templateUrl: './find-tutors.component.html'
})
export class FindTutorsComponent implements OnInit {

  private tutors: Tutor[]; // payload extracted from service get method

  constructor(private tutorService: TutorService) {
  }

  ngOnInit() {

  }

  /**
   *
   */
  private loadData(subjects?, dateRange?: DateRange, locations?: Locations[]) {

  }

}
