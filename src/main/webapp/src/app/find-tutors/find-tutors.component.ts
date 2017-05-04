import {Component, OnInit} from '@angular/core';
import {Tutor} from "../shared/objs/tutor.obj";
import {TutorService} from "../shared/services/tutor.service";
import {DateRange} from "../shared/objs/date.range.obj";
import {Locations} from "../shared/objs/location.enum";
import {Router} from "@angular/router";
import {TutorSubject} from "../shared/objs/subject.enum";
import {MessagingService} from "../shared/services/messaging.service";
import {LoadingService} from "../shared/services/loading.service";

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
  private inputSubjects: TutorSubject[];
  private inputLocations: Locations[];
  private showUserDefinedLocations: boolean = false;
  private userDefinedLocations: string; //expects a comma-separated list of input locations that aren't already defined.

  // options for select options in the form.
  // note: need to account for user input for the location
  private availableSubjects;
  private availableLocations;

  constructor(private router: Router, private tutorService: TutorService, private loadingService: LoadingService,
              private messagingService: MessagingService) {
    console.log("constructor for find-tutors")
  }

  ngOnInit() {
    // populate with dummy data
    this.loadDummyData();
    this.getCols();
    this.currentDate = new Date();

    // create dropdown values for select form
    // note: utilize PrimeNG's dropdown component
    this.createSubjectsList();
    this.createLocationsList();
  }

  private getCols() {
    this.cols = [
      {field: 'firstName', header: 'First', filterMatchMode: 'startsWith'},
      {field: 'lastName', header: 'Last', filterMatchMode: 'startsWith'},
      {field: 'rating', header: 'Rating', filterMatchMode: 'startsWith'}
    ];
    console.log(this.cols);
  }

  private createSubjectsList() {
    // hard code these for now. could potentially get these values from an endpoint call from the backend.
    this.availableSubjects = [
      {label: 'Select Subject', value: null},
      {label: TutorSubject[TutorSubject.ASTRO], value: TutorSubject.ASTRO},
      {label: TutorSubject[TutorSubject.BIO], value: TutorSubject.BIO},
      {label: TutorSubject[TutorSubject.CHEM], value: TutorSubject.CHEM},
      {label: TutorSubject[TutorSubject.COMPSCI], value: TutorSubject.COMPSCI},
      {label: TutorSubject[TutorSubject.ECON], value: TutorSubject.ECON},
      {label: TutorSubject[TutorSubject.ENGH], value: TutorSubject.ENGH},
      {label: TutorSubject[TutorSubject.ENVIR], value: TutorSubject.ENVIR},
      {label: TutorSubject[TutorSubject.HIST], value: TutorSubject.HIST},
      {label: TutorSubject[TutorSubject.IT], value: TutorSubject.IT},
      {label: TutorSubject[TutorSubject.MATH], value: TutorSubject.MATH},
      {label: TutorSubject[TutorSubject.MUSIC], value: TutorSubject.MUSIC},
      {label: TutorSubject[TutorSubject.PHYS], value: TutorSubject.PHYS},
      {label: TutorSubject[TutorSubject.PSYCH], value: TutorSubject.PSYCH},
      {label: TutorSubject[TutorSubject.STAT], value: TutorSubject.STAT}
    ];
  }

  private createLocationsList() {
    // same as createSubjectsList()
    this.availableLocations = [
      // todo: stuff
    ];
  }

  // event listener for the available locations dropdown.
  // if the list contains UserDefined, we have to allow the user to type in locations.
  private onSelectLocations(event){
    // event.value is the list of values
    this.showUserDefinedLocations = event.value.indexOf(Locations.UserDefined);
  }

  // invoked by UI button click
  // takes dummy tutors and inserts them.
  // todo: this is for testing purposes
  private loadTutors() {
    this.tutors.forEach(tutor => {
      this.tutorService.addTutor(tutor).subscribe((data: string) => {
          console.log(data);
        },
        error => {
          this.messagingService.addErrorMessage(error._body);
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
        this.messagingService.addSuccessMessage("Successfully fetched tutor data");
      },
      error => {
        // an error occurred
        console.log(error);
        //this.messagingService.addErrorMessage("An error occurred in loading data");
        this.messagingService.addErrorMessage(error._body);
      },
      () => {
        //stuff
        console.log("after starting subscription");
      });
  }

  private showForm() {
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

  private cancelForm() {
    this.showFormPopup = false;
    this.messagingService.addInfoMessage("Cancelled form input");
  }

  private confirmForm() {
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
    this.tutorService.addTutor(tutor).subscribe((data: string) => {
        this.tutors.push(tutor);
        console.log(data);
        this.messagingService.addSuccessMessage("Successfully added");
      },
      error => {
        console.log(error);
        //this.messagingService.addErrorMessage("An error occurred while trying to add");
        this.messagingService.addErrorMessage(error._body);
      },
      () => {
        console.log("after starting subscription");
      }
    );
  }
}
