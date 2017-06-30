import {Injectable} from "@angular/core";
import {Subject} from "rxjs/Subject";

@Injectable()
export class MessagingService {
  public errorMessages: Subject<string> = new Subject<string>();
  public successMessages: Subject<string> = new Subject<string>();
  public infoMessages: Subject<string> = new Subject<string>();
  public warnMessages: Subject<string> = new Subject<string>();

  public addErrorMessage(message: string){
    this.errorMessages.next(message);
  }
  public addSuccessMessage(message: string){
    this.successMessages.next(message);
  }
  public addInfoMessage(message: string){
    this.infoMessages.next(message);
  }
  public addWarningMessage(message: string){
    this.warnMessages.next(message);
  }
}
