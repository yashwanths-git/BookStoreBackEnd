import { OrderDetails } from './../../models/OrderDetails';
import { CookieService } from 'ngx-cookie-service';
import { CommonService } from 'src/app/services/common/common.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-of-orders-user',
  templateUrl: './list-of-orders-user.component.html',
  styleUrls: ['./list-of-orders-user.component.css']
})
export class ListOfOrdersUserComponent {
  userPhoneNumber!: any;
  orderList!: OrderDetails[];
  constructor(private commonService:CommonService,private cookie:CookieService,private router:Router) {
  
  }
  ngOnInit() {
    this.userPhoneNumber = this.cookie.get('UserPhoneNumber');
    this.getOrdersOfUser();
    
  }

  
  private getOrdersOfUser() {
    this.commonService.getOrdersOfUser(this.userPhoneNumber).subscribe(data =>{
      this.orderList = data;
    })
  }
  
  goToOrder(orderId: number) {
     this.router.navigate(['/order-receipt',orderId])
   }

}
