import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookSale } from 'src/app/models/BookSale';
import { CommonService } from 'src/app/services/common/common.service';

@Component({
  selector: 'app-user-home-book-list',
  templateUrl: './user-home-book-list.component.html',
  styleUrls: ['./user-home-book-list.component.css']
})
export class UserHomeBookListComponent {
  books!: BookSale[];
  searchName!: any;


  constructor(private commonService: CommonService,
    private router: Router) { }

  ngOnInit(): void {
    console.log("inside book list");
    this.getBooks();
  }

  private getBooks() {
    this.commonService.getBookList().subscribe(data =>{
      this.books = data;
    })
  }
//TODO:start with this  point
  getBookById(bookId: number){
    this.router.navigate(['BookDetail', bookId]);
  }

}
