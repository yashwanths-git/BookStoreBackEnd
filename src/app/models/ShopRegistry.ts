import { BookSale } from "./BookSale";
import { OrderDetails } from "./OrderDetails";

export class ShopRegistry{
    shopId!:number;
 shopName!:string;
 userName!:string;

    password!:string;
phoneNumber!:number;
bookSales!:BookSale[];
listOfOrdersRef!:OrderDetails[];
}