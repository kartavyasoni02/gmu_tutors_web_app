import { Component, OnInit } from '@angular/core';
import {TutorService} from "../shared/services/tutor.service";
import {Router} from "@angular/router";
import {MessagingService} from "../shared/services/messaging.service";
import {LoadingService} from "../shared/services/loading.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private tutorService: TutorService, private loadingService: LoadingService,
              private messagingService: MessagingService) { }

  ngOnInit() {
  }

}
