import {ZonedDateTime} from 'js-joda';
export interface Tutor {
  firstName: string;
  lastName: string;
  start: ZonedDateTime;
  end: ZonedDateTime;
  rating: number;
  // todo: look at json response from Location
  // and TutorSubject from backend
}
