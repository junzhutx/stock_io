import { Component, OnInit } from '@angular/core';
import { ITdDataTableColumn, IPageChangeEvent, TdDataTableService,
  ITdDataTableSelectEvent, ITdDataTableSortChangeEvent, TdDataTableSortingOrder
} from '@covalent/core';
import { Http, RequestOptions, Headers } from '@angular/http';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.scss']
})
export class CompanyComponent implements OnInit {
  filteredStocks: Array<any>;
  filteredTotal: number;
  fromRow = 1;
  currentPage = 1;
  pageSize = 10;
  sortBy = '';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  // "Symbol","Name","LastSale","MarketCap","IPOyear","Sector","industry","Summary Quote",
  columns: ITdDataTableColumn[] = [
    { name: 'symbol', label: 'Symbol', tooltip: 'Stock Symbol' },
    { name: 'name', label: 'Name', tooltip: 'Company Name' },
    { name: 'ipoYear', label: 'IPO Year', tooltip: 'IPO Year' },
    { name: 'sector', label: 'Sector', tooltip: 'Sector' },
    { name: 'industry', label: 'Industry', tooltip: 'industry' }
  ];

  constructor(private http: Http, private tdDataService: TdDataTableService) { }

  ngOnInit() {
    this.getCompanyList();
  }

  getCompanyList() {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    const theUrl = 'stock-io-company-list/lists?page=' + (this.currentPage - 1) + '&count=' + this.pageSize;
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
