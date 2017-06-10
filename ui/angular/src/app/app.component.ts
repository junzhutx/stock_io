import { Component } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { ITdDataTableColumn, IPageChangeEvent, TdDataTableService, ITdDataTableSelectEvent, ITdDataTableSortChangeEvent, TdDataTableSortingOrder } from '@covalent/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  stocks: Array<any>;
  filteredStocks: Array<any>;
  filteredTotal: number;
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 10;
  sortBy: string = '';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  // "Symbol","Name","LastSale","MarketCap","IPOyear","Sector","industry","Summary Quote",
  columns: ITdDataTableColumn[] = [
    { name: 'Symbol', label: 'Symbol', tooltip: 'Stock Symbol' },
    { name: 'Name', label: 'Name', tooltip: 'Company Name' },
    { name: 'LastSale', label: 'Last Sale', tooltip: 'Last Trading Price' },
    { name: 'MarketCap', label: 'Market Cap', tooltip: 'Market Cap' },
    { name: 'IPOyear', label: 'IPO Year', tooltip: 'IPO Year' },
    { name: 'Sector', label: 'Sector', tooltip: 'Sector' },
    { name: 'industry', label: 'Industry', tooltip: 'industry' }
  ];

  // test only
  dailyProcessorVersion: string;
  companyListVersion: string;

  constructor(private http: Http, private tdDataService: TdDataTableService) {
    this.http.get('stock-io-daily-processor/service-info/version')
    .map(response => response.json())
    .subscribe(res => this.dailyProcessorVersion = res);

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    this.http.post('stock-io-company-list/lists/20170601', {}, options)
    .map(response => response.json().companies)
    .subscribe(res => {
      this.stocks = res;
      this.filter();
    });
  }

  page(pagingEvent: IPageChangeEvent): void {
    this.fromRow = pagingEvent.fromRow;
    this.currentPage = pagingEvent.page;
    this.pageSize = pagingEvent.pageSize;
    this.filter();
  }

  sort(sortEvent: ITdDataTableSortChangeEvent): void {
    this.sortBy = sortEvent.name;
    this.sortOrder = sortEvent.order;
    this.filter();
  }

  filter() {
    let newData: Array<any> = this.stocks;
    this.filteredTotal = this.stocks.length;
    newData = this.tdDataService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this.tdDataService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredStocks = newData;
  }
}
