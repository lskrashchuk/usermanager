import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {User} from "../user/user";
import {Observable} from "rxjs";

@Injectable()
export class AuthorizationService {

    constructor(private http: Http) {
    }

    login(user: User): Observable<Boolean> {
        console.log('в начале метода логин');
        const body = JSON.stringify({username: user.username, password: user.password});
        const options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
        return this.http.post('/login', body, options)
            .map(this.extractData)
            .catch(AuthorizationService.handleError);
    }

    logout(): void {
        localStorage.removeItem("CURRENT_USER");
    }

    private extractData(response: Response) {
        const token = response.json().token;
        let user = response.json().user;
        if (token && user) {
            user.token = token;
            localStorage.setItem("CURRENT_USER", JSON.stringify(user));
            return true;
        }
        return false;
    }

    private static handleError(error: Response | any) {
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText}`;
            errMsg += `${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }
}
