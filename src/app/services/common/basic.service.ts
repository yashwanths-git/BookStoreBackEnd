import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { UserBook } from 'src/app/models/UserBook';

@Injectable({
  providedIn: 'root'
})
export class BasicService {

  isUserLogin = new BehaviorSubject<boolean>(true);
  showSideMenu = new BehaviorSubject<boolean>(false);

  userName!: any;
  constructor() { }
  public setUserType(isUser: boolean) {
    this.isUserLogin.next(isUser);
  }

  public setSideMenuView(view: boolean) {
    this.showSideMenu.next(view);
  }

  



}
