import { BasicService } from './../../services/common/basic.service';
import { ShopRegistry } from './../../models/ShopRegistry';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonService } from 'src/app/services/common/common.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login-signin-admin',
  templateUrl: './login-signin-admin.component.html',
  styleUrls: ['./login-signin-admin.component.css']
})
export class LoginSigninAdminComponent implements OnInit {


  regShop: ShopRegistry = new ShopRegistry();
  shopRegistry:ShopRegistry=new ShopRegistry;
  signUpFormShop: FormGroup;
  signInFormShop: FormGroup;

  submitted = false;
  notFound: boolean = false;
  isChecked = false;
  inCorrect: boolean = false;
  tempPass!: string;
  pass: string='';

  constructor(
    private fb: FormBuilder, 
    private commonService: CommonService, 
    private cookie: CookieService,
    private basicService:BasicService,
    private router: Router) {
      
    this.signUpFormShop = this.fb.group({
      shopName: ['', [Validators.required]],
      userName: ['', [Validators.required]],
      password: ['',[Validators.required]],
      phoneNumber: ['',[Validators.required]],
      
    });
    
      
    this.signInFormShop = this.fb.group({
      phoneNumber: ['', [Validators.required]],
      password: ['',[Validators.required]],
      
      });
   }



  ngOnInit(): void {
    const loginText:any = document.querySelector(".title-text .login");
    const loginForm :any= document.querySelector("form.login");
    const loginBtn :any= document.querySelector("label.login");
    const signupBtn:any = document.querySelector("label.signup");
    const signupLink:any = document.querySelector("form .signup-link a");
    signupBtn.onclick = (() => {
      loginForm.style.marginLeft = "-50%";
      loginText.style.marginLeft = "-50%";
    });
    loginBtn.onclick = (() => {
      loginForm.style.marginLeft = "0%";
      loginText.style.marginLeft = "0%";
    });
    signupLink.onclick = (() => {
      signupBtn.click();
      return false;
    });
  }

//Signup
  onSubmit(){
    this.shopRegistry = new ShopRegistry();
    this.shopRegistry.shopName = this.form['shopName'].value;
    this.shopRegistry.userName = this.form['userName'].value;
    this.shopRegistry.password = this.form['password'].value;
    this.shopRegistry.phoneNumber = this.form['phoneNumber'].value;
   
    this.submitted = true;
    if (this.shopRegistry.phoneNumber.toString().length == 10) {

    if (this.shopRegistry.password.length >= 8) {
      this.saveShop();
    }
    else {
      Swal.fire({
        icon: 'error',
        // title: 'Oops...',
        text: 'Password Must Be Atleast 8 Characters !',
      
      })
    }
  }
  else {
    Swal.fire({
      icon: 'error',
      // title: 'Oops...',
      text: 'Phone Number Should Be 10 Digits!',
    })
  

  }
  }

  saveShop(){
    this.commonService.registerShop(this.shopRegistry)
      .subscribe((data: any) => {
        console.log(data);
        // this.goToBookList();
        Swal.fire('Registered Successfully')

        // alert("You have successfully registered");
      },
          (error: any) => {
          if (error?.status == 200) {
            Swal.fire(' Shop Registered Successfully')
            location.reload();
          }
          else {
            console.log(error)
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Something went wrong !',
            })
          }
        }
      );
    // this.book = new Book();
  }
  get form(){
    return this.signUpFormShop.controls
  }
  //SignIn/LogIn
  onSubmitLoginAdmin() {
    if (!this.signInFormShop.valid) {
    alert("Phone Number or Password Incorrect");
      return;
    } else {
     
      //this.inCorrect = false;
      this.notFound = false;
      
        this.commonService.getShopDetails(this.signInFormShop.value.phoneNumber,this.signInFormShop.value.password).subscribe(
          (data) => {
            if (
              data.password == this.signInFormShop.value.password &&
              data.phoneNumber == this.signInFormShop.value.phoneNumber)
             {
         
              this.inCorrect = false;
              this.notFound = false;
              this.cookie.set('ShopId', `${data.shopId}`);
              this.cookie.set('ShopName', `${data.shopName}`);
              this.cookie.set("UserName", `${data.userName}`)
              this.cookie.set("PhoneNumber", `${data.phoneNumber}`)

               console.log(this.signInFormShop.value);
              this.tempPass = data.password;
             
             
             
              //tempPass = data.password;
    for (let i = 0; i < this.tempPass.length; i++){
         let temp:number;
      temp = this.tempPass.charCodeAt(i) + 23;
      this.pass += (String.fromCharCode(temp));
    }
    this.regShop.password = this.pass;
   // console.log(this.user.password);
              this.cookie.set("All", `${data}`)
             
              this.basicService.setSideMenuView(Object.keys(this.cookie.getAll()).length != 0);
              console.log("wllll");
              this.router.navigate(['/home-page', data.phoneNumber]);
            } else {
              this.inCorrect = true;
            }
          },
          (error) => {
            // if (error.status == 404) {

            //   this.notFound = true;
            // }
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Please Check Phone Number/Password !',
            
            })
          }
        );
    }
    
    }

}


