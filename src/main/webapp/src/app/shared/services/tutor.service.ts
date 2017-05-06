// service class that interacts with backend endpoints.
import {Http, RequestOptions, Response, Headers} from "@angular/http";
import {EnvConfig} from "./env.config";
import {Tutor} from "../objs/tutor.obj";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";

@Injectable()
export class TutorService {

  constructor(private http: Http, private envConfig: EnvConfig) {
  }

  public getAllTutors(): Observable<Tutor[]> {
    let headers = new Headers({'Pragma': 'no-cache'});
    headers.append('Cache-Control', 'not-store,no-cache');
    headers.append('Expires', '0');
    let options = new RequestOptions({headers: headers});
    return this.http.get(this.envConfig.getEnvVariable('endPoint') + '/api/tutors/all', options)
      .map((res: Response) => <Tutor[]>res.json().payload);
  }

  public addTutor(tutor: Tutor): Observable<string> {
    let headers = new Headers({"Content-Type": "application/json"});
    let options = new RequestOptions({headers: headers});
    console.log(this.envConfig.getEnvVariable('endPoint') + "/api/tutors/insert");
    return this.http.put(this.envConfig.getEnvVariable('endPoint') + "/api/tutors/insert", tutor, options)
      .map((res: Response) => <string>res.json().payload);
  }
}
