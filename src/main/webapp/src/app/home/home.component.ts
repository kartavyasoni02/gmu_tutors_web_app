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
  private dummyData: any;
  private options: any;

  constructor(private router: Router, private tutorService: TutorService, private loadingService: LoadingService,
              private messagingService: MessagingService) { }

  ngOnInit() {
    this.dummyData = {
      datasets: [{
        data: [
          11,
          16,
          7,
          3,
          14
        ],
        backgroundColor: [
          "#FF6384",
          "#4BC0C0",
          "#FFCE56",
          "#E7E9ED",
          "#36A2EB"
        ],
        label: 'My dataset'
      }],
      labels: [
        "Red",
        "Green",
        "Yellow",
        "Grey",
        "Blue"
      ]
    };


    this.options = {
      title: {
        display: true,
        text: 'My Title',
        fontSize: 16
      },
      legend: {
        position: 'bottom'
      }
    };
  }

}
