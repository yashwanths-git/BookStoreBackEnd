import { CookieService } from 'ngx-cookie-service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookSale } from 'src/app/models/BookSale';
import { CommonService } from 'src/app/services/common/common.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-delete-book',
  templateUrl: './delete-book.component.html',
  styleUrls: ['./delete-book.component.css']
})
export class DeleteBookComponent {
  searchName!: any;
  books!: BookSale[];
  shopId!: any;

  constructor(private commonService: CommonService,
    private cookie: CookieService,
    private router: Router) { }

  ngOnInit(): void {
    console.log("inside book list");
    this.shopId = this.cookie.get("ShopId");
    this.getBooks();
  }

  private getBooks() {
    this.commonService.getBooksByShopId(this.shopId).subscribe(data => {
      this.books = data;
    })
  }
  //TODO:start with this  point!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  // getBookById(bookId: number){
  //   this.router.navigate(['BookDetail', bookId]);
  // }

  // updateBook(bookId: number){
  //   this.router.navigate(['BookUpdate', bookId]);
  // }

  deleteBook(bookId: number, contactNumber: number) {
    
    

    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Delete!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.commonService.deleteBook(bookId, contactNumber).subscribe(data => {
          console.log(data);
        })
        Swal.fire(
          'Deleted!',
          'Book has been deleted.',
          'success'
        )
        // this.router.navigateByUrl('/temp', { skipLocationChange: true }).then(() => {
        //   this.router.navigateByUrl(['/delete-book']); // navigate to same route
        // });
        location.reload();
      }
    })
      
        // this.router.navigate(['/delete-book']);
        // 
      
}
    
    
    
      
    
    
  
  goToBookList(){
   
  }


}
