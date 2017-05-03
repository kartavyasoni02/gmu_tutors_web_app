import { Component, OnInit } from '@angular/core';
import {TutorService} from "../shared/tutor.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html'
})
export class AboutComponent implements OnInit {

  constructor(private router: Router, private tutorService: TutorService) { }

  ngOnInit() {
  }

}
