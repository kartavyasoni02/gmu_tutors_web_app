import {Component, OnInit} from '@angular/core';
import {Tutor} from "../shared/tutor.obj";
import {TutorService} from "../shared/tutor.service";
import {SearchPayload} from "../shared/search.payload.obj";
import {DateRange} from "../shared/date.range.obj";
import {Locations} from "../shared/location.enum";
import {Router} from "@angular/router";
import {Subject} from "../shared/subject.enum";

@Component({
  selector: 'app-find-tutors',
  templateUrl: './find-tutors.component.html'
})
export class FindTutorsComponent implements OnInit {

  private tutors: Tutor[]; // payload extracted from service get method
  private cols: any[];
  private currentDate: Date;

  // form inputs are kept here
  private showFormPopup: boolean = false; // p-dialog control
  private inputFirstName: string;
  private inputLastName: string;
  private inputEmail: string; // todo: requires validation
  private inputPhoneNumber: string; // todo: masked input
  private inputStartDate: Date;
  private inputEndDate: Date;
  private inputSubjects: Subject[];
  private inputLocations: Locations[];

  // options for select options in the form.
  // note: need to account for user input for the location
  private availableSubjects;
  private availableLocations;

  constructor(private router: Router, private tutorService: TutorService) {
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

  // invoked by UI button click
  // takes dummy tutors and inserts them.
  private loadTutors() {
    this.tutors.forEach(tutor => {
      this.tutorService.addTutor(tutor).subscribe((data: string) => {
          console.log(data);
        },
        error => {
          console.log(error);
        },
        () => {
          console.log("success");
        })
    });
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
   * todo: incorporate lazy load
   */
  private loadData() {
    this.tutorService.getAllTutors().subscribe((data: Tutor[]) => {
        this.tutors = data;
        console.log(data);
      },
      error => {
        // an error occurred
        console.log(error);
      },
      () => {
        //stuff
        console.log("success");
      });
  }

  private showForm(){
    // initialize all of the fields as empty
    this.inputFirstName = '';
    this.inputLastName = '';
    this.inputEmail = '';
    this.inputPhoneNumber = '';
    this.inputStartDate = new Date();
    this.inputEndDate = new Date();
    this.inputSubjects = [];
    this.inputLocations = [];

    this.showFormPopup = true;
  }

  private cancelForm(){
    this.showFormPopup = false;
  }

  private confirmForm(){
    let tutor: Tutor = <Tutor>{
      firstName: this.inputFirstName,
      lastName: this.inputLastName,
      email: this.inputEmail,
      phoneNumber: this.inputPhoneNumber,
      start: this.inputStartDate,
      end: this.inputEndDate,
      subjects: this.inputSubjects,
      locations: this.inputLocations
    }

    // persist this tutor into the database through the PUT request
    this.tutorService.addTutor(tutor);
  }
}
