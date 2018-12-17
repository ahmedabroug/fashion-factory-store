import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('user:6936352e-b25c-4c45-95c6-e14b04b17ad4')
  })
};

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getBooks(): Observable<any> {
    const url = 'http://localhost:9090/books';
    return this.http.get(url, httpOptions);
  }

  addBook(): Observable<any> {
    const url = 'http://localhost:9090/book';
    return this.http.post(url, {}, httpOptions);
  }
}


