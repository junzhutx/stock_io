import { Component } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  spaceScreens: Array<any>;
  dailyProcessorVersion: string;
  companyListVersion: string;

  constructor(private http: Http) {
    this.http.get('./data.json')
    .map(response => response.json().screenshots)
    .subscribe(res => this.spaceScreens = res);

    this.http.get('stock-io-daily-processor/service-info/version')
    .map(response => response.json())
    .subscribe(res => this.dailyProcessorVersion = res);

    this.http.get('stock-io-company-list/service-info/version')
    .map(response => response.json())
    .subscribe(res => this.companyListVersion = res);
  }

  likeMe(i) {
    if (this.spaceScreens[i].liked == 0)
      this.spaceScreens[i].liked = 1;
    else
      this.spaceScreens[i].liked = 0;
  }

  deleteMe(i) {
    this.spaceScreens.splice(i,1);
    console.log(i);
  }
}
