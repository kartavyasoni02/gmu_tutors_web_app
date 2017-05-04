/**
 * Created by Andrew on 4/23/2017.
 *
 * front end tutor object that defines properties of a tutor
 */
export interface Tutor {
  firstName?;
  lastName?;
  email?;
  phoneNumber?;
  start?; // start time of availability
  end?; // end date time of availability
  rating?;
  subjects?; // list of subjects - mapped to front end enum
  locations?; // list of locations - mapped to front end enum
  available?; // boolean that determines whether this tutor is available
}
