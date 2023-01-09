import { CookieService } from 'ngx-cookie-service';
import { CommonService } from './../../services/common/common.service';
import { BookSale } from './../../models/BookSale';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-all-books',
  templateUrl: './list-all-books.component.html',
  styleUrls: ['./list-all-books.component.css']
})
export class ListAllBooksComponent {
  books!: BookSale[];
  searchName!: any;
  shopId!: any;
  constructor(private commonService: CommonService,
    private cookie:CookieService) { }

  ngOnInit(): void {
    console.log("inside book list");
    this.shopId=this.cookie.get('ShopId');
    this.getBooks();
  }

  private getBooks() {
    this.commonService.getBooksByShopId(this.shopId).subscribe(data =>{
      this.books = data;
    })
  }


}
