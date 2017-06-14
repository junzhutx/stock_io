import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StockComponent } from './stock.component';
import { stockRoutingModule } from "./stock.routing";

@NgModule({
    declarations: [ StockComponent ],
    imports: [
        CommonModule,
        stockRoutingModule
    ],
    providers: []
})

export class StockModule {}