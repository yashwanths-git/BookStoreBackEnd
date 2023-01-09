import { Paid } from './../../../../../bookStore/src/app/models/OrderDetails';
import { CustomerAddress } from './../../models/CustomerAddress';
import { UserBook } from 'src/app/models/UserBook';
import { OrderDetails } from './../../models/OrderDetails';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookSale } from 'src/app/models/BookSale';
import { RegisteredUser } from 'src/app/models/RegisteredUser';
import { ShopRegistry } from 'src/app/models/ShopRegistry';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  private cartList!: UserBook[];
  public getCartList(): UserBook[] {
    return this.cartList;
  }
  public setCartList(value: UserBook[]) {
    this.cartList = value;
  }


  
private baseURL= "http://localhost:8080"
  private baseURLAdmin = "http://localhost:8080/admin";
  private baseURLUser = "http://localhost:8080/user";
  private baseURLNonRegisterUser = "http://localhost:8080/nonRegisteredUser";
  // private baseURL

  constructor(private httpClient: HttpClient) { }

  getBookList(): Observable<BookSale[]>{
    return this.httpClient.get<BookSale[]>(`${this.baseURLNonRegisterUser}` +'/readAllBooks');
  }
  getBooksByShopId(shopId:number): Observable<BookSale[]> {
    return this.httpClient.get<BookSale[]>(`${this.baseURLAdmin}` +'/readBooksByShopId/'+`${shopId}`);
  }
  addBook(book:BookSale): Observable<Object>{
    return this.httpClient.post(`${this.baseURLAdmin}`+'/createBook/'+`${book.bookId}`+'/'+`${book.bookName}`+'/'+`${book.authorName}`+'/'+`${book.availableQuantity}`+'/'+`${book.price}`+'/'+`${book.contactNumber}`,book);
  }
  //TODO:start from here -19/12/2022
  // createOrder(orderDetails:OrderDetails): Observable<Object>{
  //   return this.httpClient.post(`${this.baseURLUser}`+'/createOrder/'+`${book.bookId}`+'/'+`${book.bookName}`+'/'+`${book.authorName}`+'/'+`${book.availableQuantity}`+'/'+`${book.price}`+'/'+`${book.contactNumber}`,book);
  // } 
  getBookByIdAndContactNumber(bookId:number,contactNumber:number): Observable<BookSale>{
    return this.httpClient.get<BookSale>(`${this.baseURLAdmin}` +'/readByBookIdAndContactNumber/'+`${bookId}`+'/'+`${contactNumber}`);
  }

  updateBookById( newCount:number, book: BookSale): Observable<String>{
    return this.httpClient.put<String>(`${this.baseURLAdmin}`+'/updateAvailabilityByBookId/'+`${book.contactNumber}`+'/'+`${book.bookId}`+'/'+`${newCount}`, book);
  }


  updatePriceBookById( newPrice:number, book: BookSale): Observable<String>{
    return this.httpClient.put<String>(`${this.baseURLAdmin}`+'/updatePriceByBookId/'+`${book.contactNumber}`+'/'+`${book.bookId}`+'/'+`${newPrice}`, book);
  }

  deleteBook(bookId: number,contactNumber:number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURLAdmin}`+'/deleteByBookId/'+`${bookId}`+'/'+`${contactNumber}`);
  }

   //Register User!!
   registerUser(user:RegisteredUser): Observable<Object>{
    return this.httpClient.post (`${this.baseURL}` +'/registry/register/'+`${user.name}`+'/'+`${user.userName}`+'/'+`${user.password}`+'/'+`${user.phoneNumber}`,user)
   }
  //Get Shop Info
  
  getShopDetails(phoneNumber: number,password: string): Observable<ShopRegistry> {
    return this.httpClient.get<ShopRegistry>(`${this.baseURL}` + '/shopRegistry/shopDetailsWithPhoneNumber/' + `${phoneNumber}` + '/' + `${password}`)
  }
  getShopDetailsWithShopId(shopId:any): Observable<ShopRegistry> {
    return this.httpClient.get<ShopRegistry>(`${this.baseURLAdmin}` + '/readShopByShopId/' + `${shopId}` )
  }
  //GET /shopRegistry/shopName/{phoneNumber}
  getShopName(phoneNumber: number): Observable<string>{
    return this.httpClient.get<string>(`${this.baseURL}` + '/shopRegistry/shopName/' + `${phoneNumber}` )

  }
  //Register Shop
  registerShop(shopRegistry: ShopRegistry) : Observable<Object>{
    return this.httpClient.post (`${this.baseURL}` +'/shopRegistry/registerShop/'+`${shopRegistry.shopName}`+'/'+`${shopRegistry.userName}`+'/'+`${shopRegistry.password}`+'/'+`${shopRegistry.phoneNumber}`,shopRegistry)
  }
  //Get User Data
  getUserDetails(phoneNumber:number,password:string): Observable<RegisteredUser>{
    return this.httpClient.get<RegisteredUser>(`${this.baseURL}`+'/registry/getUserDetails/'+`${phoneNumber}`+'/'+`${password}`)
  }
  getUserDetailsWithUserId(UserId:any): Observable<RegisteredUser> {
    return this.httpClient.get<RegisteredUser>(`${this.baseURLUser}` + '/getUserDetailsWithUserId/' + `${UserId}` )
  }
  getUserDetailsWithPhoneNumber(phoneNumber:number): Observable<RegisteredUser>{
    return this.httpClient.get<RegisteredUser>(`${this.baseURL}`+'/registry/getUserDetailsWithPhoneNumber/'+`${phoneNumber}`)
  }
  //Placing Order 
  placeOrder(orderDetails:OrderDetails,customerAddress:CustomerAddress): Observable<Object>{
    return this.httpClient.post(`${this.baseURLUser}`+'/createOrder/'+`${orderDetails.customerName}`+'/'+`${orderDetails.phoneNumber}`+'/'+`${orderDetails.email}`+'/'+`${Paid[orderDetails.paid]}`+'/'+`${customerAddress.city}`+'/'+`${customerAddress.doorNo}`+'/'+`${customerAddress.streetName}`+'/'+`${customerAddress.state}`,this.getCartList());
  }
  //get orders of the user

  
  getOrdersOfUser(phoneNumber:number): Observable<OrderDetails[]>{
    return this.httpClient.get<OrderDetails[]>(`${this.baseURLUser}`+'/readByPhoneNumber/'+`${phoneNumber}`)
  }
  //get  single order of the user
  getOrderOfUser(orderId:number): Observable<OrderDetails>{
    return this.httpClient.get<OrderDetails>(`${this.baseURLUser}`+'/readByOrderId/'+`${orderId}`)
  }
}
  
