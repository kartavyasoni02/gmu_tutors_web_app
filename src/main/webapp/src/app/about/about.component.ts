import { Component, OnInit } from '@angular/core';
import {TutorService} from "../shared/services/tutor.service";
import {Router} from "@angular/router";
import {LoadingService} from "../shared/services/loading.service";
import {MessagingService} from "../shared/services/messaging.service";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html'
})
export class AboutComponent implements OnInit {

  constructor(private router: Router, private tutorService: TutorService, private loadingService: LoadingService,
              private messagingService: MessagingService) { }

  ngOnInit() {
  }

}
