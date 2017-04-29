import {Injectable} from "@angular/core";
@Injectable()
export class EnvConfig {
  constructor() {
  }

  public getEnvVariable(value): string {
    let environment: string;
    let data = {};
    let port: string;
    let url: string;

    environment = window.location.hostname;
    port = location.port;
    url = environment+":"+port;

    console.log("url :", url);

    switch (url) {
      case 'localhost:4200':
        data = {
          endPoint: 'http://localhost:8150'
        };
    }
    return data[value];
  }
}
