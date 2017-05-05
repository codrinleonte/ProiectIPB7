import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from "./dashboard/dashboard.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {ModuleWithProviders} from "@angular/core";
import {ProfileComponent} from "./dashboard/profile/profile.component";
import {HomeComponent} from "./dashboard/home/home.component";

export const router: Routes = [
    { path: '', component: DashboardComponent, children: [
        { path: '', component: HomeComponent },
        { path: 'profile', component: ProfileComponent }
    ] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent }
];

export const routes : ModuleWithProviders = RouterModule.forRoot(router);