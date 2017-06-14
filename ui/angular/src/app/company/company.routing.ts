import { CompanyComponent } from './company.component';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

const companyRoutes: Routes = [
    { path: 'company', component: CompanyComponent }
]

export const companyRoutingModule: ModuleWithProviders = RouterModule.forChild(companyRoutes);