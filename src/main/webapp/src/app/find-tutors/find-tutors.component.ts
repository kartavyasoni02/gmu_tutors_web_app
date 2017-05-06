import {Component, OnInit} from '@angular/core';
import {Tutor} from "../shared/objs/tutor.obj";
import {TutorService} from "../shared/services/tutor.service";
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
  private validInputs: boolean = false; // control for confirmation button
  private validFirstName: boolean = false;
  private validLastName: boolean = false;
  private validEmail: boolean = false;
  private validPhoneNumber: boolean = false;
  private inputFirstName: string;
  private inputLastName: string;
  private inputEmail: string; // todo: requires validation and security
  private inputPhoneNumber: string; // todo: masked input and security
  private inputStartDate: Date; // note: these dates will be in local time.. need to make sure they are converted to UTC time at some point
  private inputEndDate: Date; // end date must come after start date -> validate this!
  private inputSubjects: TutorSubject[];
  private inputLocations: Locations[];
  private showUserDefinedLocations: boolean = false; // if this is true, the input value below must be non-empty to complete the form
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
    //this.loadDummyData();
    this.loadData();
    this.getCols();
    this.currentDate = new Date();

    // create dropdown values for select form
    // note: utilize PrimeNG's multi-select component
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
      this.loadingService.toggleLoadingIndicator(true);
      this.tutorService.addTutor(tutor).subscribe((data: string) => {
          this.loadingService.toggleLoadingIndicator(false);
          console.log(data);
        },
        error => {
          this.messagingService.addErrorMessage(error);
          setTimeout(() => {this.loadingService.toggleLoadingIndicator(false)}, 1000);
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
    this.loadingService.toggleLoadingIndicator(true);
    this.tutorService.getAllTutors().subscribe((data: Tutor[]) => {
        this.loadingService.toggleLoadingIndicator(false);
        this.tutors = data;
        console.log(data);
        this.messagingService.addSuccessMessage("Successfully fetched tutor data");
      },
      error => {
        // an error occurred
        console.log(error);
        //this.messagingService.addErrorMessage("An error occurred in loading data");
        this.messagingService.addErrorMessage(error._body);
        setTimeout(this.loadingService.toggleLoadingIndicator(false),1000);
      },
      () => {
        //stuff
        console.log("after starting subscription");
      });
  }

  private validateAllInputs(): boolean{
    // rather than disabling the button based on this function return value,
    // we should do all the validation onClick of the save button.
    // This way, the browser won't be constantly calling this function while the page is loaded.
    //return this.validFirstName && this.validLastName && this.validEmail && this.validPhoneNumber && this.validDateRange();
    let invalid: string[] = []; // keep track of all of the invalid inputs to display at the end.
    if (!this.validateNameInput(true)){
      invalid.push("First Name");
    }
    if (!this.validateNameInput(false)){
      invalid.push("Last Name");
    }
    if (!this.validateEmailInput()){
      invalid.push("Email");
    }
    if (!this.validatePhoneNumber()){
      invalid.push("Phone");
    }
    if (!this.validDateRange()){
      invalid.push("Dates");
    }

    this.messagingService.addWarningMessage("Invalid inputs: "+invalid);
    return invalid.length == 0;
  }
  // validation checks onBlur events for each of the inputs.
  private validateEmailInput(): boolean{
    let email = this.inputEmail;
    // validations:
    // 1) characters before @ symbol
    // 2) one @ symbol
    // 3) characters after @ symbol
    // 4) at least 1 . after @
    // ends in a valid domain - net, org, com, edu, etc.
    // The email ahuynh11@masonlive.gmu.edu is valid. This validation is based off of this example
    // todo: validate
    this.validEmail = true;
    return this.validEmail;
  }
  private validateNameInput(isFirstName: boolean): boolean{
    let name = isFirstName ? this.inputFirstName : this.inputLastName;
    // validate that the name only contains letters.
    let check = /^[a-zA-Z]$/.test(name); // rudimentary testing of the input. todo: make this more robust
    // this test fails for names like "O'Malley" and "Van Duke" and "Walsh-Smith"
    if (isFirstName){
      this.validFirstName = check;
    }
    else {
      this.validLastName = check;
    }
    return check;
  }
  private validatePhoneNumber(){
    this.validPhoneNumber = true; //todo: validate
    return this.validPhoneNumber;
  }
  private validDateRange(): boolean{
    // first check if start and end date are defined.
    if (this.inputStartDate == null || this.inputEndDate == null){ return false; }
    else {
      // since they're both checked, just compare the two values.
      return this.inputStartDate < this.inputEndDate;
    }
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
    // do a last validation check before we save the tutor information
    if (this.validateAllInputs()) { //wrap everything in this. If any of the inputs are invalid, we shouldn't save the info.
      let tutor: Tutor = <Tutor>{
        firstName: this.inputFirstName,
        lastName: this.inputLastName,
        email: this.inputEmail,
        phoneNumber: this.inputPhoneNumber,
        start: this.inputStartDate,
        end: this.inputEndDate,
        subjects: this.inputSubjects,
        locations: this.inputLocations
      };

      // persist this tutor into the database through the PUT request
      this.loadingService.toggleLoadingIndicator(true);
      this.tutorService.addTutor(tutor).subscribe((data: string) => {
          this.loadingService.toggleLoadingIndicator(false);
          this.tutors.push(tutor);
          console.log(data);
          this.messagingService.addSuccessMessage("Successfully added");
        },
        error => {
          console.log(error);
          //this.messagingService.addErrorMessage("An error occurred while trying to add");
          this.messagingService.addErrorMessage(error._body);
          setTimeout(this.loadingService.toggleLoadingIndicator(false), 1000);
        },
        () => {
          console.log("after starting subscription");
        }
      );
    }
  }
}
