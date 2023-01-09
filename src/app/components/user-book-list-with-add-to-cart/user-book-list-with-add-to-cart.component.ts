import { UserBook } from 'src/app/models/UserBook';
import { CookieService } from 'ngx-cookie-service';
import { BasicService } from './../../services/common/basic.service';
// import { UserBook } from './../../models/UserBook';
import { BookSaleUser } from './../../models/BookSaleUser';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookSale } from 'src/app/models/BookSale';
import { CommonService } from 'src/app/services/common/common.service';

@Component({
  selector: 'app-user-book-list-with-add-to-cart',
  templateUrl: './user-book-list-with-add-to-cart.component.html',
  styleUrls: ['./user-book-list-with-add-to-cart.component.css']
})
export class UserBookListWithAddToCartComponent {
  books!: BookSale[];
  booksCart: UserBook[] = [];;
  user: Array<UserBook> = [];
  dum!: number;
tempCount: number = 0;
  userId!: any;
  searchName!: any;


  constructor(private commonService: CommonService,
   private cookie:CookieService
  ) { }

  ngOnInit(): void {
    console.log("inside book list");
    this.getBooks();
    this.userId =  this.cookie.get('UserId');
    this.booksCart = this.commonService.getCartList();
 
  }

  private getBooks() {
    this.commonService.getBookList().subscribe(data =>{
      this.books = data;
    })
  }
  

  addToCart(bookId: number, shopContactNumber: number) {
    console.log("a::"+bookId)
    
    if (this.booksCart != null || undefined) {
      this.dum = 1;
      
      for (let book of this.booksCart) {
        
        console.log("add to cart::" + bookId)
        if (book.bookId == bookId && book.shopPhoneNumber == shopContactNumber) {
          book.setNumberOfBooksNeeded(book.getNumberOfBooksNeeded() + 1);
          this.tempCount = book.numberOfBooksNeeded;
          alert("Book already added so value is updated by "+this.tempCount )
          this.dum = 2;
        }
      }
      if (this.dum == 1) {
        console.log("all Ok")
        let toCart = new UserBook;
        // let temp: any|UserBook[];    this.booksCart.push(toCart);
      
    toCart.setBookId(bookId);
    toCart.setShopPhoneNumber(shopContactNumber);
        toCart.setNumberOfBooksNeeded(1);
        this.user = this.booksCart; 
        this.user.push(toCart);
        this.booksCart = this.user;
        this.commonService.setCartList(this.booksCart);
        alert("Added to cart");
  
      }
    }
     else{
        console.log("all Ok")
            let toCart = new UserBook;
            // let temp: any|UserBook[];    this.booksCart.push(toCart);
          
        toCart.setBookId(bookId);
        toCart.setShopPhoneNumber(shopContactNumber);
            toCart.setNumberOfBooksNeeded(1);
        
            this.user.push(toCart);
            this.booksCart = this.user;
        
            this.commonService.setCartList(this.booksCart);
            alert("Added to cart");

      }
      console.log(this.booksCart)
    }
    //     else {
    //       let toCart = new UserBook;
    //       toCart.setBookId(bookId);
    //       toCart.setShopPhoneNumber(shopContactNumber);
    //       toCart.numberOfBooksNeeded=1;


    //       this.booksCart.push(toCart);
    //       this.commonService.setCartList(this.booksCart);
        
    //     }
    //   }
    
    // }
   
  //   else {
      
      
  // console.log("all Ok")
  //     let toCart = new UserBook;
  //     // let temp: any|UserBook[];    this.booksCart.push(toCart);
    
  // toCart.setBookId(bookId);
  // toCart.setShopPhoneNumber(shopContactNumber);
  //     toCart.setNumberOfBooksNeeded(1);
  
  //     this.user.push(toCart);
  //     this.booksCart = this.user;
  
  //     this.commonService.setCartList(this.booksCart);

      
    
  //     }

      

  }
  
 
  
 
                
    



