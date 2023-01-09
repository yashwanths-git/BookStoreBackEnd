export class UserBook{
     cartId!: number;
     numberOfBooksNeeded!: number;
      shopPhoneNumber!: number;
      bookId!: number;



     public getNumberOfBooksNeeded(): number {
          return this.numberOfBooksNeeded;
     }
     public setNumberOfBooksNeeded(value: number) {
          this.numberOfBooksNeeded = value;
     }
     public getBookId(): number {
          return this.bookId;
     }
     public setBookId(value: number) {
          this.bookId = value;
     }
     public getShopPhoneNumber(): number {
          return this.shopPhoneNumber;
     }
     public setShopPhoneNumber(value: number) {
          this.shopPhoneNumber = value;
     }

}