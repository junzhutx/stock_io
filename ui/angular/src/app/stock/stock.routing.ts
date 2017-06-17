import { StockComponent } from './stock.component';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

const stockRoutes: Routes = [
    { path: 'stock', component: StockComponent }
];

export const stockRoutingModule: ModuleWithProviders = RouterModule.forChild(stockRoutes);
