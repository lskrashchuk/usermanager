import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router} from "@angular/router";
import {User} from "../user/user";
import {Authority} from "../user/authority";

@Injectable()
export class SecurityService implements CanActivate {

    private router: Router;

    constructor(router: Router) {
        this.router = router;
    }

    canActivate(route: ActivatedRouteSnapshot): boolean {
        let canActivate: boolean = false;
        const authorities = route.data["roles"] as Array<string>;
        const user: User = JSON.parse(localStorage.getItem("CURRENT_USER"));
        if (authorities.length > 0 && user) {
            canActivate = SecurityService.checkAuthorities(authorities, user.authorities);
        }
        return canActivate ? true : SecurityService.denyAccess();
    }

    private static denyAccess(): boolean {
        alert('You don\'t have permissions!');
        //this.router.navigate(['/login']);
        return false;
    }

    private static checkAuthorities(availableAuthorityList: string[], currentAuthorityList: Authority[]): boolean {
        for (let availableAuthority = 0; availableAuthority < availableAuthorityList.length; availableAuthority++)
            for (let userAuthority = 0; userAuthority < currentAuthorityList.length; userAuthority++)
                if (availableAuthorityList[availableAuthority] == currentAuthorityList[userAuthority].name) {
                    return true;
                }
        return false;
    }

    public static hasAuthority(authority: string): boolean {
        const user: User = JSON.parse(localStorage.getItem("CURRENT_USER"));
        if (user != null)
            for (let currentAuthority of user.authorities) {
                if (currentAuthority.name === authority)
                    return true;
            }
        return false;
    }
}
