/**
 * Created by Andrew on 5/3/2017.
 */
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Observer} from "rxjs/Observer";
import 'rxjs/add/operator/share'

@Injectable()
export class LoadingService {
  loading$: Observable<string>;
  private _observer: Observer<string>;

  constructor(){
    this.loading$ = new Observable<string>(observer => this._observer = observer).share();
  }

  public toggleLoadingIndicator(flag){
    if (this._observer){
      this._observer.next(flag);
    }
  }
}
