import { OrderDetails } from './../../models/OrderDetails';
import { CommonService } from 'src/app/services/common/common.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-reciept',
  templateUrl: './order-reciept.component.html',
  styleUrls: ['./order-reciept.component.css']
})
export class OrderRecieptComponent  implements OnInit{
  orderId!: any;
  order!: OrderDetails;
  constructor(private route: ActivatedRoute, private commonService: CommonService) {
  
  }
  ngOnInit() {
    this.orderId = this.route.snapshot.params['orderId'];
    this.commonService.getOrderOfUser(this.orderId).subscribe(data => {
      this.order = data;
     // console.log(this.order.books);
      console.log(this.order);
      for (let boo of data.books) {
        console.log("hghfhgfd" + boo.quantity);
        console.log("hghfhgfd" + boo.authorName);
        
  }
    });

 
  
  }
}