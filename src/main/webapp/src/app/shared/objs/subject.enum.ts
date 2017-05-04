/**
 * Created by Andrew on 4/28/2017.
 *
 * Note: This should match the backend enum TutorSubject
 */
export enum TutorSubject {
  ENGH = <any>"English",
  HIST = <any>"History",
  PSYCH = <any>"Psychology",
  ECON = <any>"Economics",
  BIO = <any>"Biology",
  CHEM = <any>"Chemistry",
  PHYS = <any>"Physics",
  ASTRO = <any>"Astronomy",
  ENVIR = <any>"Environmental Science",
  MATH = <any>"Math",
  STAT = <any>"Statistics",
  IT = <any>"IT",
  COMPSCI = <any>"Computer Science",
  MUSIC = <any>"Music"

  // enum values in Typescript are interesting.
  // example:
  // TutorSubject.ENGH = ENGH.
  // TutorSubject[TutorSubject.ENGH] = "English
}
