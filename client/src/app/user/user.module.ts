import {NgModule} from "@angular/core";
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
    ],
    providers: [
        UserService
    ]
})
export class UserModule {
}
