import { Router } from '@angular/router';
import { CommonService } from 'src/app/services/common/common.service';
import { Component } from '@angular/core';
import { BookSale } from 'src/app/models/BookSale';
import { UserBook } from 'src/app/models/UserBook';
import { BookSaleUser } from 'src/app/models/BookSaleUser';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  finalPrice: number = 0;
  items: number = 0;
  cartBooks!: UserBook[];
  tempCountOfBook!: number;
  cartBooksDisplay: Array<BookSaleUser> = [];
  tempBook!: BookSale;
  booksCart: UserBook[] = [];
  incTempBook!: number;
  temp!: BookSale;
  

  constructor(private commonService: CommonService, private router: Router) { }
  ngOnInit(): void {
    this.cartBooks = this.commonService.getCartList()
    console.log(this.cartBooks);
    this.items = this.cartBooks.length;
    for (let book of this.cartBooks) {
      this.commonService.getBookByIdAndContactNumber(book.bookId, book.shopPhoneNumber).subscribe(data => {
        this.tempBook = data;
        this.tempCountOfBook = book.numberOfBooksNeeded;
        this.storeCart();
      })
      
   
    }

    
  }
  storeCart() {

    let tempCart = new BookSaleUser();
    tempCart.bookId = this.tempBook.bookId;
    tempCart.bookName = this.tempBook.bookName;
    tempCart.authorName = this.tempBook.authorName;
    tempCart.Quantity = this.tempCountOfBook;
    tempCart.price = this.tempBook.price;
    tempCart.shopContactNumber = this.tempBook.contactNumber;
    this.finalPrice = this.finalPrice + (tempCart.price * tempCart.Quantity)
    this.cartBooksDisplay.push(tempCart);
  }

  totalOfEachBook(quantity: number, price: number): number {

    return quantity * price;

  }

  clearCart() {
    console.log('clear');
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Remove All!'

    }).then((result) => {
      if (result.isConfirmed) {
        this.commonService.setCartList([]);
        Swal.fire(
          'Removed !',
          'Cart  has been deleted.',
          'success'
        )
        this.router.navigateByUrl('/temp', { skipLocationChange: true }).then(() => {
          this.router.navigate(['/cart']); // navigate to same route
        });
      //  this.router.navigate(['/cart'])

      }
    })
  }
  increase(bookId: number, shopPhoneNumber: number) {

    //  // product.Quantity ++;
    //   for (let book of this.cartBooks) {
    //     this.commonService.getBookByIdAndContactNumber(bookId, shopPhoneNumber).subscribe(data => {
    //   // this.bookSale=   data
    //       // data.(book.getNumberOfBooksNeeded() + 1);
    //       // console.log( "temp"+data);
    //       book.setNumberOfBooksNeeded(book.getNumberOfBooksNeeded() + 1);
    //     })
    //   }
    this.booksCart = this.commonService.getCartList();

    this.commonService.getBookByIdAndContactNumber(bookId, shopPhoneNumber).subscribe(data => {
      this.temp = data;

      this.incTempBook = this.temp.availableQuantity;
      for (let book of this.booksCart) {
        
    
        if (book.bookId == bookId && book.shopPhoneNumber == shopPhoneNumber && this.incTempBook > book.getNumberOfBooksNeeded())
        {
          // console.log("
          book.setNumberOfBooksNeeded(book.getNumberOfBooksNeeded() + 1);
        //  this.router.navigate(['/temp'])
        this.router.navigateByUrl('/temp', { skipLocationChange: true }).then(() => {
          this.router.navigate(['/cart']); // navigate to same route
      }); 
          //this.toHome()
        }
      
      
      }

      console.log("jhgjk"+this.incTempBook);
    });
   console.log("6567"+this.incTempBook);
    // for (let book of this.booksCart) {
        
    
    //   if (book.bookId == bookId && book.shopPhoneNumber == shopPhoneNumber && this.incTempBook > book.getNumberOfBooksNeeded())
    //   {
    //     // console.log("
    //     book.setNumberOfBooksNeeded(book.getNumberOfBooksNeeded() + 1);
    //   //  this.router.navigate(['/temp'])
    //   this.router.navigateByUrl('/temp', { skipLocationChange: true }).then(() => {
    //     this.router.navigate(['/cart']); // navigate to same route
    // }); 
    //     //this.toHome()
    //   }
    
    
    // }
    // this.ngOnInit();
    
  }
  toHome() {
    this.router.navigate(['/user-home-page'])
    this.toCart();
  }
  toCart() {
   // this.router.navigate(['/cart'])

  }

  decrease(bookId: number, shopPhoneNumber: number) {


    // for (let book of this.cartBooks) {
    //   this.commonService.getBookByIdAndContactNumber(bookId, shopPhoneNumber).subscribe(data => {
    //     console.log( "temp"+data);
    //     book.setNumberOfBooksNeeded(book.getNumberOfBooksNeeded() - 1);
       
    //   })
    // }
      
      
    this.booksCart = this.commonService.getCartList();

    for (let book of this.booksCart) {
          
      
      if (book.bookId == bookId && book.shopPhoneNumber == shopPhoneNumber&&book.getNumberOfBooksNeeded()>0) {
        book.setNumberOfBooksNeeded(book.getNumberOfBooksNeeded() - 1);
        
        this.router.navigateByUrl('/temp', { skipLocationChange: true }).then(() => {
          this.router.navigate(['/cart']); // navigate to same route
      }); 
      }
      
      
    }
  }
}

  

