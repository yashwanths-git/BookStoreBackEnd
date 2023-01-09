import { BookSale } from './../models/BookSale';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchBook'
})
export class SearchBookPipe implements PipeTransform {



  transform(bookSale : BookSale[],searchName:String|any): BookSale[] {

    if(!bookSale || !searchName){
      return bookSale;
    }
    return bookSale.filter(book => 
      book.bookName.toLocaleLowerCase().includes(searchName.toLocaleLowerCase()) ||
      book.authorName.toLocaleLowerCase().includes(searchName.toLocaleLowerCase()) ||
      book.shopName.toLocaleLowerCase().includes(searchName.toLocaleLowerCase()) ||
    book.bookId==(searchName)
      //book.bookmentStatus.toLocaleLowerCase().includes(searchName.toLocaleLowerCase())
      );
  }
  }


