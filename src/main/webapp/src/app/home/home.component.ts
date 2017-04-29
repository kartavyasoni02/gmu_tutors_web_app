import { Component, OnInit } from '@angular/core';
import {TutorService} from "../shared/tutor.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  constructor(private tutorService: TutorService) { }

  ngOnInit() {
  }

}
