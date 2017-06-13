import { Component } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { ITdDataTableColumn, IPageChangeEvent, TdDataTableService, ITdDataTableSelectEvent, ITdDataTableSortChangeEvent, TdDataTableSortingOrder } from '@covalent/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  filteredStocks: Array<any>;
  filteredTotal: number;
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 10;
  sortBy: string = '';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  // "Symbol","Name","LastSale","MarketCap","IPOyear","Sector","industry","Summary Quote",
  columns: ITdDataTableColumn[] = [
    { name: 'symbol', label: 'Symbol', tooltip: 'Stock Symbol' },
    { name: 'name', label: 'Name', tooltip: 'Company Name' },
    { name: 'ipoyear', label: 'IPO Year', tooltip: 'IPO Year' },
    { name: 'sector', label: 'Sector', tooltip: 'Sector' },
    { name: 'industry', label: 'Industry', tooltip: 'industry' }
  ];

  // test only
  dailyProcessorVersion: string;
  companyListVersion: string;

  constructor(private http: Http, private tdDataService: TdDataTableService) {
    this.http.get('stock-io-daily-processor/service-info/version')
    .map(response => response.json())
    .subscribe(res => this.dailyProcessorVersion = res);

    this.getCompanyList();
  }

  getCompanyList() {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let theUrl = 'stock-io-company-list/lists?page='+(this.currentPage-1)+'&count='+this.pageSize;
    this.http.post(theUrl, {}, options)
    .map(response => response.json())
    .subscribe(res => {
      this.filteredStocks = res.companies;
      this.filteredTotal = res.totalElements;
    });
  }

  page(pagingEvent: IPageChangeEvent): void {
    this.fromRow = pagingEvent.fromRow;
    this.currentPage = pagingEvent.page;
    this.pageSize = pagingEvent.pageSize;
    this.getCompanyList();
  }

  // sort(sortEvent: ITdDataTableSortChangeEvent): void {
  //   this.sortBy = sortEvent.name;
  //   this.sortOrder = sortEvent.order;
  //   this.filter();
  // }

  // filter() {
  //   let newData: Array<any> = this.stocks;
  //   this.filteredTotal = this.stocks.length;
  //   newData = this.tdDataService.sortData(newData, this.sortBy, this.sortOrder);
  //   newData = this.tdDataService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
  //   this.filteredStocks = newData;
  // }
}
