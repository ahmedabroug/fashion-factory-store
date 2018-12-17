import { Component, OnInit } from '@angular/core';
import { BookService } from './services/book.service';
import { Book } from './models/book';
import { AuthService } from './auth/auth.service';
import { TokenStorageService } from './auth/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'fashion-factory-store-front-office-ui';

  books: any;

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getBooks();
  }


  getBooks() {
    this.bookService.getBooks()
      .subscribe(
        (books: any) => {
          this.books = books.content;
        },
        (error) => console.log(error)
      );
  }

  addBook() {

    this.bookService.addBook()
      .subscribe(
        (book: any) => {
          this.getBooks();
        },
        (error) => console.log(error)
      );
  }


}

