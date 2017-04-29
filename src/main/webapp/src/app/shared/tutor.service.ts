
// service class that interacts with backend endpoints.
import {SearchPayload} from "./search.payload.obj";
import {Http} from "@angular/http";
import {EnvConfig} from "./env.config";
export class TutorService {

  constructor(private http: Http, private envConfig: EnvConfig){}

  /**
   * Get HTTP request to backend to retrieve tutors.
   * @param searchPayload
   */
  public getTutors(searchPayload?:SearchPayload){
    if (searchPayload == null){

    }
    else {
      this.http.get(this.envConfig.getEnvVariable('endPoint') + "/")
    }
  }
}
