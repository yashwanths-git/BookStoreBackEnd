import { UpdateBookButComponent } from './components/update-book-but/update-book-but.component';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignInPageComponent } from './components/sign-in-page/sign-in-page.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ListAllBooksComponent } from './components/list-all-books/list-all-books.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BookDetailsComponent } from './components/book-details/book-details.component';
import { StarterPageComponent } from './components/starter-page/starter-page.component';
import { LoginSigninAdminComponent } from './components/login-signin-admin/login-signin-admin.component';
import { PracComponent } from './components/prac/prac.component';
import { CreateBookComponent } from './components/create-book/create-book.component';
import { UpdateBookComponent } from './components/update-book/update-book.component';
import { DeleteBookComponent } from './components/delete-book/delete-book.component';
import { HomePageDashBoardComponent } from './components/home-page-dash-board/home-page-dash-board.component';
import { UserOrAdminSelectionComponent } from './components/user-or-admin-selection/user-or-admin-selection.component';
import { UserHomePageNavigationBarComponent } from './components/user-home-page-navigation-bar/user-home-page-navigation-bar.component';
import { UserHomePageComponent } from './components/user-home-page/user-home-page.component';
import { CreateOrderUserComponent } from './components/create-order-user/create-order-user.component';
import { UserHomeBookListComponent } from './components/user-home-book-list/user-home-book-list.component';
import { AdminHomePageBookListComponent } from './components/admin-home-page-book-list/admin-home-page-book-list.component';
import { UserBookListWithAddToCartComponent } from './components/user-book-list-with-add-to-cart/user-book-list-with-add-to-cart.component';
import { CookieService } from 'ngx-cookie-service';
import { UserMyOrdersPageComponent } from './components/user-my-orders-page/user-my-orders-page.component';
import { UserMyProfileComponent } from './components/user-my-profile/user-my-profile.component';

import { SearchBookPipe } from './pipes/search-book.pipe';
import { ShopBookGraphicalViewComponent } from './components/shop-book-graphical-view/shop-book-graphical-view.component';
import { CartComponent } from './components/cart/cart.component';
import { TempComponent } from './temp/temp.component';
import { OrderRecieptComponent } from './components/order-reciept/order-reciept.component';
import { ListOfOrdersUserComponent } from './components/list-of-orders-user/list-of-orders-user.component';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { UpdateBookPriceComponent } from './components/update-book-price/update-book-price.component';


@NgModule({
  declarations: [
    AppComponent,
    SignInPageComponent,
    NavigationBarComponent,
    SideBarComponent,
    HomePageComponent,
    ListAllBooksComponent,
    BookDetailsComponent,
    StarterPageComponent,
    LoginSigninAdminComponent,
    PracComponent,
    CreateBookComponent,
    UpdateBookComponent,
    DeleteBookComponent,
    UpdateBookButComponent,
    HomePageDashBoardComponent,
    UserOrAdminSelectionComponent,
    UserHomePageNavigationBarComponent,
    UserHomePageComponent,
    CreateOrderUserComponent,
    UserHomeBookListComponent,
    AdminHomePageBookListComponent,
    UserBookListWithAddToCartComponent,
    UserMyOrdersPageComponent,
    UserMyProfileComponent,

    SearchBookPipe,
     ShopBookGraphicalViewComponent,
     CartComponent,
     TempComponent,
     OrderRecieptComponent,
     ListOfOrdersUserComponent,
     UpdateBookPriceComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    SweetAlert2Module.forRoot()
  ],
  providers: [[CookieService],],
  bootstrap: [AppComponent]
})
export class AppModule { }
