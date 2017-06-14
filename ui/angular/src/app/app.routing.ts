import { Routes, RouterModule } from '@angular/router';

const appRoutes: Routes = [
    { path: '', redirectTo: 'company', pathMatch: 'full' }
];

export const appRoutingModule = RouterModule.forRoot(appRoutes);
