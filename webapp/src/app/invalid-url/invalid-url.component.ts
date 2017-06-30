import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-invalid-url',
  templateUrl: './invalid-url.component.html'
})
export class InvalidUrlComponent implements OnInit {

  constructor(private router: Router) {
    console.log("404 error occurred");
  }

  ngOnInit() {
    console.log("rerouting to /home");
    setTimeout(()=> {this.router.navigate(['/home'])}, 5000);
  }

}
