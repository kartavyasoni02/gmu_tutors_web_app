import {Component, Input, OnInit} from '@angular/core';
import {Tutor} from 'app/shared/models/tutor.model';

@Component({
  selector: 'gmu-tutor-list-view',
  templateUrl: './tutor-list-view.component.html',
  styleUrls: ['./tutor-list-view.component.css']
})
export class TutorListViewComponent implements OnInit {

  @Input()
  public tutors: Tutor[];

  constructor() {
  }

  ngOnInit() {
  }

}
