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
  private cols: any[];
  private currentDate: Date;

  constructor(private tutorService: TutorService) {
    console.log("constructor for find-tutors")
  }

  ngOnInit() {
    // populate with dummy data
    this.loadDummyData();
    this.getCols();
    this.currentDate = new Date();
  }

  private getCols() {
    this.cols = [
      {field: 'firstName', header: 'First', filterMatchMode: 'startsWith'},
      {field: 'lastName', header: 'Last', filterMatchMode: 'startsWith'},
      {field: 'rating', header: 'Rating', filterMatchMode: 'startsWith'}
    ];
    console.log(this.cols);
  }

  private loadDummyData() {
    this.tutors = [];
    this.tutors.push(
      {firstName: 'Andrew', lastName: 'Huynh', rating: 9.5},
      {firstName: 'Phong', lastName: 'Vo', rating: 3.125},
      {firstName: 'Randy', lastName: 'Tidd', rating: 9.8}
    );
    console.log(this.tutors);
  }

  /**
   * Loads data from the backend.
   */
  private loadData() {
    this.tutorService.getAllTutors().subscribe((data: Tutor[]) => {
        this.tutors = data;
        console.log(data);
      },
      error => {
        // an error occurred
      },
      () => {
        //stuff
      });
  }

}
