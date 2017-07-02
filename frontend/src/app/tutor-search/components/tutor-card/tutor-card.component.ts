import {Component, Input, OnInit} from '@angular/core';
import {Tutor} from 'app/shared/models/tutor.model';

@Component({
  selector: 'gmu-tutor-card',
  templateUrl: './tutor-card.component.html',
  styleUrls: ['./tutor-card.component.css']
})
export class TutorCardComponent implements OnInit {

  @Input()
  public tutor: Tutor;

  constructor() { }

  ngOnInit() {
  }

}
