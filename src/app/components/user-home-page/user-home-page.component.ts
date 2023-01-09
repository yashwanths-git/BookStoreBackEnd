import { CookieService } from 'ngx-cookie-service';
import { BasicService } from './../../services/common/basic.service';
import { RegisteredUser } from './../../models/RegisteredUser';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonService } from 'src/app/services/common/common.service';

@Component({
  selector: 'app-user-home-page',
  templateUrl: './user-home-page.component.html',
  styleUrls: ['./user-home-page.component.css']
})
export class UserHomePageComponent {
  regUser: RegisteredUser=new RegisteredUser();
  title: string = 'Welcome ';
  userId!: any;
  // tempPassword!: string;
  // password: string='';
  regPhoneNumber!: any;
  validcheck: boolean = false;
  constructor(
    private cookie:CookieService,
    private router: Router,
    private commonService: CommonService) { }
  ngOnInit() {
    console.log('user home page');
    // this.regUserId = this.route.snapshot.params['regUserId'];
    // this.regName = this.route.snapshot.params['regName'];
  //   this.regPhoneNumber = this.route.snapshot.params['regPhoneNumber'];
  //   this.tempPassword = this.route.snapshot.params['password'];
  //   for (let i = 0; i < this.tempPassword.length; i++){
  //     let temp:number;
  //  temp = this.tempPassword.charCodeAt(i) - 23;
  //     this.password += (String.fromCharCode(temp));
   
  //   }
 this.userId=  this.cookie.get('RegisterId')
 this.regPhoneNumber=  this.cookie.get('UserPhoneNumber')
    this.userProfile();
   
  }


  
    userProfile() {
      this.commonService.getUserDetailsWithUserId(this.userId).subscribe(
        (data) => {
          if (data.phoneNumber == this.regPhoneNumber) {
            this.regUser = data;
            console.log("reg Phone Number::"+this.regPhoneNumber)
          }
      
          (error:any)=>{
            alert(error.message);
          }
      });
    
  }

        
        
}

