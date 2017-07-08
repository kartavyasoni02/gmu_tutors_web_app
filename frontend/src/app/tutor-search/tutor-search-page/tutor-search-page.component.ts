import {Component, OnInit} from '@angular/core';
import {Tutor} from 'app/shared/models/tutor.model';
import {ZonedDateTime, ZoneId} from 'js-joda';

@Component({
  selector: 'gmu-tutor-search-page',
  templateUrl: './tutor-search-page.component.html',
  styleUrls: ['./tutor-search-page.component.css']
})
export class TutorSearchPageComponent implements OnInit {

  // end result should use an Observable
  // public tutors$: Observable<Tutor[]>;

  // for now, mock it with random data generation in frontend
  // todo: move random generation to backend and hook up REST endpoints
  public tutors: Tutor[];
  private firstNames: string[] = [
    'Andrew', 'Anthony', 'Alice', 'Alvin', 'Amanda', 'Amy', 'Beth', 'Bernie', 'Brian', 'Carl', 'Carly', 'Charlie', 'Chris',
    'Cody', 'Danny', 'Dennis', 'Drake', 'Edward', 'Eric', 'Elizabeth', 'Emily', 'Finn', 'Francis', 'George', 'Ginny',
    'Haley', 'Harper', 'James', 'Jason', 'Jennifer', 'Jimmy', 'Josh', 'Katie', 'Kelsey', 'Kevin', 'Kimberly', 'Lane',
    'Laura', 'Lauren', 'Michelle', 'Monica', 'Mark', 'Norman', 'Nick', 'Ollie', 'Patrick', 'Percy', 'Peter', 'Penelope',
    'Quinn', 'Rachel', 'Ruth', 'Steven', 'Sally', 'Stan', 'Sarah', 'Tanner', 'Thomas', 'Tony', 'Veronica', 'Victoria',
    'Wallace', 'Walter', 'Will', 'Yolanda'
  ];
  private lastNames: string[] = [
    'Allen', 'Anderson', 'Belladona', 'Brown', 'Carson', 'Clark', 'Davis', 'Dee', 'Ellis', 'Ferdinand', 'Gray', 'Garcia',
    'Hall', 'Harris', 'Jackson', 'Jacobs', 'King', 'Lee', 'Lewis', 'Martin', 'Moore', 'Morris', 'Nelson', 'Oliver', 'Parsons',
    'Peterson', 'Smith', 'Stewart', 'Taylor', 'Thomas', 'Turner', 'Ward', 'White', 'Williams', 'Wilson'
  ];

  constructor() {
    this.tutors = this.generateDummyTutorList();
  }

  ngOnInit() {
  }

  private generateDummyTutorList(): Tutor[] {
    const resultList = [];
    const range: number = Math.floor(Math.random() * 50) + 50;
    for (let i = 0; i < range; i++) {
      resultList.push(this.generateRandomTutor())
    }
    return resultList as Tutor[];
  }

  private generateRandomTutor() {
    return {
      firstName: this.getRandomName(this.firstNames),
      lastName: this.getRandomName(this.lastNames),
      start: this.getRandomDate(),
      end: ZonedDateTime.now(),
      rating: this.getRandomRating()
    } as Tutor;
  }

  private getRandomName(names: string[]) {
    const index: number = Math.floor(Math.random() * names.length);
    return names[index];
  }

  private getRandomRating() {
    return (Math.random() * 9) + 1;
  }

  private getRandomDate() {
    const yearDecider: number = Math.random();
    const year: number = yearDecider < 0.33 ? 2017 : yearDecider < 0.66 ? 2016 : 2015;
    const month: number = Math.floor(Math.random() * 10) + 1;
    const day: number = Math.floor(Math.random() * 25) + 1;
    return ZonedDateTime.of(year, month, day, 1, 1, 1, 1, ZoneId.SYSTEM);
  }
}
