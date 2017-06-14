import { Component } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  // Nav bar demo
  tabLinks = [
    {label: 'Company', link: 'company'},
    {label: 'Stock', link: 'stock'},
  ];

  // test only
  dailyProcessorVersion: string;
  companyListVersion: string;

  constructor(private http: Http) {
    this.http.get('stock-io-daily-processor/service-info/version')
    .map(response => response.json())
    .subscribe(res => this.dailyProcessorVersion = res);
  }
}
