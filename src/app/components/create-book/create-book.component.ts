import { CookieService } from 'ngx-cookie-service';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookSale } from 'src/app/models/BookSale';
import { CommonService } from 'src/app/services/common/common.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent {
  title: string = 'Add Book';
  shopPhoneNumber!: any;
  bookForm: FormGroup;
  book: BookSale = new BookSale();
  submitted = false;

  constructor(
    private fb: FormBuilder, 
    private commonService: CommonService, 
    private router: Router,
    private cookie: CookieService) {
      
    this.bookForm = this.fb.group({
      bookId: ['', [Validators.required]],
      bookName: ['', [Validators.required]],
      authorName: ['',[Validators.required]],
      availableQuantity: ['',[Validators.required]],
      price: ['',[Validators.required]],
      // contactNumber: ['', [Validators.required]],     
      
      });
   }

  ngOnInit(): void {
    this.shopPhoneNumber= this.cookie.get('PhoneNumber');
  }

  onSubmit(){
    this.book = new BookSale();
    this.book.bookId = this.form['bookId'].value;
    this.book.bookName = this.form['bookName'].value;
    this.book.authorName = this.form['authorName'].value;
    this.book.availableQuantity = this.form['availableQuantity'].value;
    // this.book.bookGenre = this.form['bookGenre'].value;
    this.book.price = this.form['price'].value;
    this.book.contactNumber = this.shopPhoneNumber;
    this.submitted = true;
    this.saveBook();
  }

  saveBook(){
    this.commonService.addBook(this.book)
      .subscribe((data: any) => {
        console.log(data);
        Swal.fire(
          'Book Added Successfully !',
          '',
          'success'
        )
        this.goToBookList();
      },
        (       error: any) => {Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong!',
        })});
    // this.book = new Book();
  }

  get form(){
    return this.bookForm.controls
  }

  goToBookList(){
    this.router.navigate(['/list-all-books']);
  }


}
