import { Component, OnInit } from '@angular/core';
import {TutorService} from "../shared/tutor.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private tutorService: TutorService) { }

  ngOnInit() {
  }

}
