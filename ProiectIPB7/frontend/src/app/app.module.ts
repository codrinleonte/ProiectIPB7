import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {routes} from './app.router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MaterialModule } from '@angular/material';
import 'hammerjs';
import { ProfileComponent } from './dashboard/profile/profile.component';
import { HomeComponent } from './dashboard/home/home.component';
import { PanelButtonComponent } from './dashboard/home/panel-button/panel-button.component';
import { SubmitComponent } from './dashboard/submit/submit.component';
import { GradeDialogComponent } from './dashboard/grade-dialog/grade-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    ProfileComponent,
    HomeComponent,
    PanelButtonComponent,
    SubmitComponent,
    GradeDialogComponent
  ],
    entryComponents: [GradeDialogComponent],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        BrowserAnimationsModule,
        routes,
        MaterialModule.forRoot()
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
