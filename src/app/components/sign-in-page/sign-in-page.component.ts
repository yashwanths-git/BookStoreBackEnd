import { BasicService } from './../../services/common/basic.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
// import anime from 'animejs/lib/anime.es.js';
import * as anime from 'animejs';
import { CookieService } from 'ngx-cookie-service';
import { RegisteredUser } from 'src/app/models/RegisteredUser';
import { CommonService } from 'src/app/services/common/common.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css']
})
export class SignInPageComponent implements OnInit {

  //SignUpForm 
  user: RegisteredUser = new RegisteredUser;
  signUpForm: FormGroup;
  submitted = false;
  success = false
  //LogInForm
  login1Form: FormGroup;
  notFound: boolean = false;
  isChecked = false;
  inCorrect: boolean = false;
  tempPass!: string;
  pass: string='';
   alertMessage: string="";

  constructor(
    private fb: FormBuilder,
    private commonService: CommonService,private basicService:BasicService,
    private cookie: CookieService,
   
    private router: Router) {
      
    this.signUpForm = this.fb.group({
      name: ['', [Validators.required]],
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]],
      phoneNumber: ['', [Validators.required]],
      
    });
    this.login1Form = this.fb.group({
      phoneNumber: [' ', [Validators.required]],
      password: [' ', [Validators.required]],
      
    });
  }






  ngOnInit(): void {
    this.user = new RegisteredUser();

    const loginText: any = document.querySelector(".title-text .login");
    const loginForm: any = document.querySelector("form.login");
    const loginBtn: any = document.querySelector("label.login");
    const signupBtn: any = document.querySelector("label.signup");
    const signupLink: any = document.querySelector("form .signup-link a");
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
  get form() {
    return this.signUpForm.controls
  }
  onSubmit() {
    this.user = new RegisteredUser();
    this.user.name = this.form['name'].value;
    this.user.userName = this.form['userName'].value;
    this.user.password = this.form['password'].value;
    this.user.phoneNumber = this.form['phoneNumber'].value;
   
    this.submitted = true;
    if (this.user.phoneNumber.toString().length == 10) {
      if (this.user.password.length >= 8) {
      

        this.saveUser();
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
    console.log(this.user.phoneNumber.toString().length)

    }
    
  }

  saveUser() {
    this.commonService.registerUser(this.user)
      .subscribe((data: any) => {
        this.alertMessage = data;
        this.test();
        this.success = true;
       
        Swal.fire('Registered Successfully')
        // this.goToBookList();
      },
        (error: any) => {
          if (error?.status == 200) {
            Swal.fire('Registered Successfully')
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
  test() {
    if (this.success == false) {
      //alert("User successfully registered")
    }
    else {
      // alert("User registration failed");
    }
  }
  //Login\
  onSubmitLogin() {
    if (!this.login1Form.valid) {
    // alert("Phone Number or Password Incorrect");
      return;
    } else {
     
      //this.inCorrect = false;
      this.notFound = false;
      
        this.commonService.getUserDetails(this.login1Form.value.phoneNumber,this.login1Form.value.password).subscribe(
          (data) => {
            if (
              data.password == this.login1Form.value.password &&
              data.phoneNumber == this.login1Form.value.phoneNumber)
             {
         
              this.inCorrect = false;
              this.notFound = false;
              this.cookie.set('RegisterId', `${data.regUserId}`);
              this.cookie.set('NameOfUser', `${data.name}`);
              this.cookie.set("UserName", `${data.userName}`)
              this.cookie.set("UserPhoneNumber", `${data.phoneNumber}`)

               console.log(this.login1Form.value);
             
              this.tempPass = data.password;
             
             
             
              //tempPass = data.password;
    for (let i = 0; i < this.tempPass.length; i++){
         let temp:number;
      temp = this.tempPass.charCodeAt(i) + 23;
      this.pass += (String.fromCharCode(temp));
    }
    this.user.password = this.pass;
   // console.log(this.user.password);
              this.cookie.set("All", `${data}`)
             
              this.basicService.setSideMenuView(Object.keys(this.cookie.getAll()).length != 0);
              this.router.navigate(['/user-home-page']);
            } else {
              this.inCorrect = true;
            }
          },
          (error) => {
            console.log(error)

            // if (error.status == 404) {

            //   this.notFound = true;
            // }
            { Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Please Check Phone Number/Password !',
            
            })}
          }
        );
    }
    
    }
  }


