import {Component, OnDestroy, OnInit} from '@angular/core';
import {Message} from "primeng/primeng";
import {Subscription} from "rxjs/Subscription";
import {MessagingService} from "../shared/services/messaging.service";

@Component({
  selector: 'app-messaging',
  templateUrl: './messaging.component.html'
})
export class MessagingComponent implements OnInit, OnDestroy {
  private messages: Message[] = [];
  private errorMessages: Subscription = new Subscription();
  private successMessages: Subscription = new Subscription();
  private infoMessages: Subscription = new Subscription();
  private warnMessages: Subscription = new Subscription();

  constructor(private messagingService: MessagingService) { }

  ngOnInit() {
    this.errorMessages = this.messagingService.errorMessages.subscribe(
      message => this.messages.push({severity: 'error', summary: 'Error', detail: message})
    );
    this.successMessages = this.messagingService.successMessages.subscribe(
      message => this.messages.push({severity: 'success', summary: 'Success', detail: message})
    );
    this.infoMessages = this.messagingService.infoMessages.subscribe(
      message => this.messages.push({severity: 'info', summary: 'Info', detail: message})
    );
    this.warnMessages = this.messagingService.warnMessages.subscribe(
      message => this.messages.push({severity: 'warn', summary: 'Warning', detail: message})
    );
  }

  ngOnDestroy(){
    this.errorMessages.unsubscribe();
    this.successMessages.unsubscribe();
    this.infoMessages.unsubscribe();
    this.warnMessages.unsubscribe();
  }
}
