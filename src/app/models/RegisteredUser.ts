import { OrderDetails } from "./OrderDetails";

export class RegisteredUser{
    regUserId!:number;
	name!:string;
	 userName!:string;
	password!:string;
	phoneNumber!:number;


	listOfOrders!:OrderDetails[];
}