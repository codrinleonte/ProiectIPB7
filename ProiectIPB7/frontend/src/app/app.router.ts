import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from "./dashboard/dashboard.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {ModuleWithProviders} from "@angular/core";

export const router: Routes = [
    { path: '', component: DashboardComponent, children: [

    ] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent }
];

export const routes : ModuleWithProviders = RouterModule.forRoot(router);