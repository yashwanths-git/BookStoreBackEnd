import { CookieService } from 'ngx-cookie-service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent {
  shopId!: any;
  constructor(private cookie:CookieService,private router:Router) {
    
  }
  ngOnInit(): void {
    this.shopId=this.cookie.get('ShopId');
    
  }

  goToAdminHome() {
    this.router.navigate(['/home-page',this.shopId])
  }
}
