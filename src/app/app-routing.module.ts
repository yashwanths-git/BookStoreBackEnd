import { UpdateBookPriceComponent } from './components/update-book-price/update-book-price.component';
import { OrderRecieptComponent } from './components/order-reciept/order-reciept.component';
import { TempComponent } from './temp/temp.component';
import { CartComponent } from './components/cart/cart.component';
import { AdminHomePageBookListComponent } from './components/admin-home-page-book-list/admin-home-page-book-list.component';
import { UserHomePageComponent } from './components/user-home-page/user-home-page.component';
import { CreateOrderUserComponent } from './components/create-order-user/create-order-user.component';
import { StarterPageComponent } from './components/starter-page/starter-page.component';
import { LoginSigninAdminComponent } from './components/login-signin-admin/login-signin-admin.component';
import { UserOrAdminSelectionComponent } from './components/user-or-admin-selection/user-or-admin-selection.component';
import { UpdateBookButComponent } from './components/update-book-but/update-book-but.component';
import { CreateBookComponent } from './components/create-book/create-book.component';
import { UpdateBookComponent } from './components/update-book/update-book.component';
import { DeleteBookComponent } from './components/delete-book/delete-book.component';
import { ListAllBooksComponent } from './components/list-all-books/list-all-books.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInPageComponent } from './components/sign-in-page/sign-in-page.component';
import { ListOfOrdersUserComponent } from './components/list-of-orders-user/list-of-orders-user.component';
//TODO: start from this point
const routes: Routes = [
  {path: '',component: StarterPageComponent},
  
  { path: '', redirectTo: 'StarterPageComponent',pathMatch: 'full'},
//  { path: 'BookList', component: app-home-page }
 // { path: '', redirectTo: 'sign-in-page', pathMatch: 'full' },
  { path: 'sign-in-page', component: SignInPageComponent },
  { path: 'sign-in-page-admin', component: LoginSigninAdminComponent },
  { path: 'home-page/:shopId', component: HomePageComponent },
  { path: 'admin-home-page', component: AdminHomePageBookListComponent },
  { path: 'create-book', component: CreateBookComponent },
  { path: 'list-all-books', component: ListAllBooksComponent },
  { path: 'user-home-page', component: UserHomePageComponent },
  { path: 'delete-book', component: DeleteBookComponent },
  { path: 'update-book', component: UpdateBookButComponent },
  {path:'update-stock-page/:bookId/:contactNumber',component:UpdateBookComponent},
  {path:'update-price-page/:bookId/:contactNumber',component:UpdateBookPriceComponent},
  { path: 'create-order', component: CreateOrderUserComponent },
  { path: 'cart', component: CartComponent },
  { path: 'routingcart', component: CartComponent },
  { path: 'temp', component: TempComponent },
  { path: 'list-all-orders', component: ListOfOrdersUserComponent },
  { path: 'order-receipt/:orderId', component: OrderRecieptComponent },


  {path:'**',component: StarterPageComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
