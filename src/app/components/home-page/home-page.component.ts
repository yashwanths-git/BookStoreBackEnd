import { CookieService } from 'ngx-cookie-service';
import { ShopRegistry } from 'src/app/models/ShopRegistry';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonService } from 'src/app/services/common/common.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  shopDetails: ShopRegistry = new ShopRegistry();
  shopId!: any;
  title!: string; 

  constructor(private route: ActivatedRoute,private commonService:CommonService,private cookie:CookieService)  {
  
}
  ngOnInit(): void {

    this.shopId = this.cookie.get('ShopId');
    this.getShopDetails(this.shopId);
      
    }
  getShopDetails(shopId:any) {
    this.commonService.getShopDetailsWithShopId(shopId).subscribe(
      (data) => {
        this.shopDetails = data;
      });
  }
  
}
