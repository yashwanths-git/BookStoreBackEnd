import { Time } from "@angular/common";
import { BookSaleUser } from "./BookSaleUser";
import { CustomerAddress } from "./CustomerAddress";
import { RegisteredUser } from "./RegisteredUser";
import { ShopRegistry } from "./ShopRegistry";

export class OrderDetails {
    orderId!:number;
	customerName!:string;
	books!:BookSaleUser[];

	price!:number;
 phoneNumber!:number;
	  shopContactNumber!:number;
	 shopName!:string;
 totalNumberOfBooks!:number;
	 email!:string;
	

	 paid!:Paid;




 date!:Date;


 time!:Time;
	  address!:CustomerAddress;
	
	
	 registeredUserRef!:RegisteredUser;
	
	  shopRegisterRef!:ShopRegistry;
}

export enum Paid {
    YES,
	NO,
	TEMP
}