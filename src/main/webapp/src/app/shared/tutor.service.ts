// service class that interacts with backend endpoints.
import {Http, RequestOptions, Response, Headers} from "@angular/http";
import {EnvConfig} from "./env.config";
import {Tutor} from "./tutor.obj";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";

@Injectable()
export class TutorService {

  constructor(private http: Http, private envConfig: EnvConfig){}

  public getAllTutors(): Observable<Tutor[]>{
    let headers = new Headers({'Pragma':'no-cache'});
    headers.append('Cache-Control', 'not-store,no-cache');
    headers.append('Expires', '0');
    let options = new RequestOptions({ headers: headers });
    return this.http.get(this.envConfig.getEnvVariable('endPoint') + '/tutors/all', options)
      .map((res: Response) => <Tutor[]>res.json().payload);
  }

  public addTutor(tutor: Tutor){
    this.http.put(this.envConfig.getEnvVariable('endPoint') + "/insert", tutor);
  }
}
