import { BookSale } from './../../models/BookSale';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonService } from 'src/app/services/common/common.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent {
  message!: string;
  newCount: number | any;
  bookForm: FormGroup;
  book:BookSale =new BookSale;
  // bookTemp:BookSale =new BookSale;
 
  
  bookId:number|any;
  contactNumber:number|any;
 
  submitted = false;

  constructor(
    private fb: FormBuilder, 
    private commonService: CommonService,private route: ActivatedRoute, 
    private router: Router) {
      
    this.bookForm = this.fb.group({
      newCount :['', [Validators.required]],
   
      
      });
   }

  ngOnInit(): void {
    this.bookId = this.route.snapshot.params['bookId'];
    this.contactNumber = this.route.snapshot.params['contactNumber'];
    
    this.getBookByIdAndContactNumber(this.bookId, this.contactNumber);

  }
  getBookByIdAndContactNumber(bookId:number,contactNumber:number) {
    this.commonService.getBookByIdAndContactNumber(bookId,contactNumber).subscribe(data =>{
      this.book = data;
     
    })
  }

  onSubmit(){
 
// console.log(this.book)
    // this.book = new BookSale();
    // this.book.bookId = this.form['bookId'].value;
   this.newCount=this.form['newCount'].value;
    // this.book.contactNumber = this.form['contactNumber'].value;
    this.submitted = true;
    if (this.newCount > 0) {
      this.updateBook();

    }
    else {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Enter Number Greater Than Zero!',
      })
   }
   
  }

  
  updateBook(){
    this.commonService.updateBookById(this.newCount, this.book)
      .subscribe((data: any) => {
        this.message = data;
        console.log(data);
       
      
      }),
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Book Stock has  been updated!!!',
        showConfirmButton: false,
        timer: 1500
      }).then((result) => {
        if (true) {
         this.goToBookList();
        }
},
    
        (error: any) => console.log(error));
      
    // this.book = new Book();
  }

  get form(){
    return this.bookForm.controls
  }

  goToBookList() {
    console.log("check"+this.message);
    this.router.navigate(['/list-all-books']);
  
  }
//  this.book = this.commonService.getBookByIdAndContactNumber;




  // newCount: number | any;
  // bookForm: FormGroup;
  
  // book: BookSale = new BookSale();
  // submitted = false;

  // constructor(
  //   private fb: FormBuilder, 
  //   private commonService: CommonService, 
  //   private router: Router) {
      
  //   this.bookForm = this.fb.group({
  //     bookId: ['', [Validators.required]],
  //     newCount :['', [Validators.required]],
  //     contactNumber: ['', [Validators.required]],     
      
  //     });
  //  }

  // ngOnInit(): void {
  // }

  // onSubmit(){
  //   this.book = new BookSale();
  //   this.book.bookId = this.form['bookId'].value;
  //  this.newCount=this.form['newCount'].value;
  //   this.book.contactNumber = this.form['contactNumber'].value;
  //   this.submitted = true;
  //   this.updateBook();
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

  // get form(){
  //   return this.bookForm.controls
  // }

  // goToBookList(){
  //   this.router.navigate(['/list-all-books']);
  // }



}
