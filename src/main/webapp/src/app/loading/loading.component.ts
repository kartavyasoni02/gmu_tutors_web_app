import {Component, ElementRef, OnDestroy, OnInit} from '@angular/core';
import {LoadingService} from "../shared/services/loading.service";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html'
})
export class LoadingComponent implements OnInit, OnDestroy {
  private isLoading: boolean = false;
  private subscription: Subscription;

  // ElementRef object in case we want to manipulate any DOM elements in this component
  constructor(public el: ElementRef, public loadingService: LoadingService) { }

  private toggleLoadingAction(loading){
    this.isLoading = loading;
    if (this.isLoading) this.invokeAnimation();
  }
  private invokeAnimation(){
    // function here is just a placeholder -> can put custom animation triggers here
  }

  ngOnInit() {
    this.subscription = this.loadingService.loading$.subscribe(loading => this.toggleLoadingAction(loading));
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
}
