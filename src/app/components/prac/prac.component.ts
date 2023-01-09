import { CommonService } from './../../services/common/common.service';
import { BookSale } from './../../models/BookSale';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-prac',
  templateUrl: './prac.component.html',
  styleUrls: ['./prac.component.css']
})
export class PracComponent {
  title: string = 'Add Book';

  bookForm: FormGroup;
  book: BookSale = new BookSale();
  submitted = false;

  constructor(
    private fb: FormBuilder, 
    private commonService: CommonService, 
    private router: Router) {
      
    this.bookForm = this.fb.group({
      bookId: ['', [Validators.required]],
      bookName: ['', [Validators.required]],
      authorName: ['',[Validators.required]],
      availableQuantity: ['',[Validators.required]],
      price: ['',[Validators.required]],
      contactNumber: ['', [Validators.required]],     
      
      });
   }

  ngOnInit(): void {
  }

  onSubmit(){
    this.book = new BookSale();
    this.book.bookId = this.form['bookId'].value;
    this.book.bookName = this.form['bookName'].value;
    this.book.authorName = this.form['authorName'].value;
    this.book.availableQuantity = this.form['availableQuantity'].value;
    // this.book.bookGenre = this.form['bookGenre'].value;
    this.book.price = this.form['price'].value;
    this.book.contactNumber = this.form['contactNumber'].value;
    this.submitted = true;
    this.saveBook();
  }

  saveBook(){
    this.commonService.addBook(this.book)
      .subscribe((data: any) => {
        console.log(data);
        this.goToBookList();
      },
        (       error: any) => console.log(error));
    // this.book = new Book();
  }

  get form(){
    return this.bookForm.controls
  }

  goToBookList(){
    this.router.navigate(['/list-all-books']);
  }



}
