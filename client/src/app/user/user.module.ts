import {NgModule} from "@angular/core";
import {UserAppComponent} from "./user-app.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {UserService} from "./user.service";
import {UserRoutingModule} from "./user-routing.module";
@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        RouterModule,
        HttpModule,
        ReactiveFormsModule,
        CommonModule,
        UserRoutingModule
    ],
    declarations: [
        UserAppComponent
    ],
    providers: [
        UserService
    ]
})
export class UserModule {
}
