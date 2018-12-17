import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { JwtResponse } from '../models/jwt-response';
import { AuthLoginInfo } from '../models/auth-login-info';

const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa('user:31dfd7ff-5a86-4afb-9628-0c107621b6d5')
    })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:9090/login';
  // private signupUrl = 'http://localhost:8080/api/auth/signup';

  constructor(private http: HttpClient) { }

  // JwtResponse(accessToken,type,username,authorities)
  attemptAuth(): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, httpOptions);
  }

  // SignUpInfo(name,username,email,role,password)
  // signUp(info: SignUpInfo): Observable<string> {
  //   return this.http.post<string>(this.signupUrl, info, httpOptions);
  // }
}
