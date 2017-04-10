import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {SecurityService} from "../security/security.service";
import {UserAppComponent} from "./user-app.component";

export const routes: Routes = [
    {
        path: 'users', component: UserAppComponent, canActivate: [SecurityService], data: {roles: ['ROLE_ADMIN']}
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class UserRoutingModule {
}
