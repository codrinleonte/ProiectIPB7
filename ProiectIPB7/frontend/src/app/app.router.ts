import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from "./dashboard/dashboard.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {ModuleWithProviders} from "@angular/core";
import {ProfileComponent} from "./dashboard/profile/profile.component";
import {HomeComponent} from "./dashboard/home/home.component";
import {SubmitComponent} from "./dashboard/submit/submit.component";
import {GradesComponent} from "./dashboard/grades/grades.component";
import {ComissionComponent} from "./dashboard/comission/comission.component";
import {EvaluationComponent} from "./dashboard/evaluation/evaluation.component";
import {ManagestudsComponent} from "./dashboard/managestuds/managestuds.component";
import {EditexamsComponent} from "./dashboard/editexams/editexams.component";
import {ActivationComponent} from "./dashboard/activation/activation.component";

export const router: Routes = [
    { path: '', component: DashboardComponent, children: [
        { path: '', component: HomeComponent },
        { path: 'profile', component: ProfileComponent },
        { path: 'submit', component: SubmitComponent },
        { path: 'grades', component: GradesComponent },
        { path: 'commission', component: ComissionComponent },
        { path: 'evaluation', component: EvaluationComponent },
        { path: 'managestuds', component: ManagestudsComponent },
        { path: 'editexams', component: EditexamsComponent }
    ] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'activation', component: ActivationComponent }
];

export const routes : ModuleWithProviders = RouterModule.forRoot(router);