import { CookieService } from 'ngx-cookie-service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookSale } from 'src/app/models/BookSale';
import { CommonService } from 'src/app/services/common/common.service';

@Component({
  selector: 'app-shop-book-graphical-view',
  templateUrl: './shop-book-graphical-view.component.html',
  styleUrls: ['./shop-book-graphical-view.component.css']
})
export class ShopBookGraphicalViewComponent {

  books!: BookSale[];
  searchName!: any;
  shopId!: any;

  constructor(private commonService: CommonService,
    private router: Router,private cookie:CookieService) { }

  ngOnInit(): void {
    console.log("inside book list");
this.shopId= this.cookie.get('ShopId')
    this.getBooks();
  }

  private getBooks() {
    this.commonService.getBooksByShopId(this.shopId).subscribe(data =>{
      this.books = data;
    })
  }

}
