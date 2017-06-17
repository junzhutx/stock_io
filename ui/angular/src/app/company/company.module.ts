import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompanyComponent } from './company.component';
import { companyRoutingModule } from './company.routing';
import { CovalentLayoutModule, CovalentStepsModule, CovalentDataTableModule, CovalentPagingModule } from '@covalent/core';

@NgModule({
    declarations: [ CompanyComponent ],
    imports: [
        CommonModule,
        companyRoutingModule,
        CovalentLayoutModule,
        CovalentStepsModule,
        CovalentDataTableModule,
        CovalentPagingModule
    ],
    providers: []
})

export class CompanyModule {}
