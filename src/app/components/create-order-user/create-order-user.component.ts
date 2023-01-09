import { CookieService } from 'ngx-cookie-service';
import { CustomerAddress } from './../../models/CustomerAddress';
import { OrderDetails, Paid } from './../../models/OrderDetails';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/services/common/common.service';
import Swal from 'sweetalert2';
import { flush } from '@angular/core/testing';

@Component({
  selector: 'app-create-order-user',
  templateUrl: './create-order-user.component.html',
  styleUrls: ['./create-order-user.component.css']
})
export class CreateOrderUserComponent {

  orderForm: FormGroup;
  orderDetails: OrderDetails = new OrderDetails();
  customerAddress: CustomerAddress = new CustomerAddress();
  customerPhoneNumber!: any;
  customerName!: any;
  submitted = false;
  paid: string ='YES' ;
  alertMessage!: string;

  constructor(
    private fb: FormBuilder, 
    private commonService: CommonService, 
    private cookie:CookieService,
    private router: Router) {
      
    this.orderForm = this.fb.group({
      email: ['',[Validators.required]],
     // customerName: ['', [Validators.required]],
      doorNo: ['', [Validators.required]],     
      streetName: ['', [Validators.required]],     
      city: ['', [Validators.required]],     
      state: ['', [Validators.required]],     
      
    });
    
   }

  ngOnInit(): void {
    this.customerPhoneNumber = this.cookie.get('UserPhoneNumber');
    this.customerName = this.cookie.get('NameOfUser');
    this.alertMessage = "Order Successfully Placed " + this.customerName;
  }

  onSubmit(){
    this.orderDetails = new OrderDetails();
    this.orderDetails.customerName = this.customerName;
    this.orderDetails.phoneNumber=this.customerPhoneNumber;
    this.orderDetails.email = this.form['email'].value;
    this.orderDetails.paid = Paid.YES;
    this.customerAddress.city = this.form['city'].value;
    this.customerAddress.doorNo = this.form['doorNo'].value;
    this.customerAddress.streetName = this.form['streetName'].value;
    this.customerAddress.state = this.form['state'].value;
console.log(this.paid)
    this.submitted = true;
   this.saveOrder();
  }

  saveOrder() {
    this.commonService.placeOrder(this.orderDetails, this.customerAddress)
      .subscribe((data: any) => {
        console.log(data);
        Swal.fire({
          title: this.alertMessage,
          showClass: {
            popup: 'animate__animated animate__fadeInDown'
          },
          hideClass: {
            popup: 'animate__animated animate__fadeOutUp'
          }
        })
        this.goToHome();
      },
        (error: any) => {
          console.log(error)
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong !',
          
          })
  });
    // this.orderDetails = new Book();
  }

  get form(){
    return this.orderForm.controls
  }

  goToHome() {
    this.commonService.setCartList ([]);
    this.router.navigate(['/list-all-orders']);
  }

}
