import { CookieService } from 'ngx-cookie-service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookSale } from 'src/app/models/BookSale';
import { CommonService } from 'src/app/services/common/common.service';

@Component({
  selector: 'app-update-book-but',
  templateUrl: './update-book-but.component.html',
  styleUrls: ['./update-book-but.component.css']
})
export class UpdateBookButComponent {
  searchName!: any;

  books!: BookSale[];
  shopId!: any;;
  // bookId!:number|any;

 

  constructor(
    private commonService: CommonService,
    private cookie:CookieService,
   
    private router: Router) { 
   } 

  ngOnInit(): void {
    console.log("inside book list");
    this.shopId=this.cookie.get('ShopId')
    
    this.getBooks();
  }
  goToBookUpdateStock(bookId:number,contactNumber:number){
    this.router.navigate(['/update-stock-page',bookId,contactNumber]);
  }
  goToBookUpdatePrice(bookId:number,contactNumber:number){
    this.router.navigate(['/update-price-page',bookId,contactNumber]);
  }

  private getBooks() {
    this.commonService.getBooksByShopId(this.shopId).subscribe(data =>{
      this.books = data;
    })
  }

//TODO:start with this  point!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  // getBookById(bookId: number){
  //   this.router.navigate(['BookDetail', bookId]);
  // }

  // updateBook(){
  //   this.commonService.updateBookById(this.newCount,  this.book)
  //     .subscribe((data: any) => {
  //       console.log(data);
  //       this.goToBookList();
  //     },
  //       (       error: any) => console.log(error));
  //   // this.book = new Book();
  // }

  // deleteBook(bookId: number,contactNumber:number){
  //   this.commonService.deleteBook(bookId,contactNumber).subscribe(data => {
  //     console.log(data);
  //     this.router.navigate(['/delete-book']);
  //    // 
  //   })
    
  

}
