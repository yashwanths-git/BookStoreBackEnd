import { ShopRegistry } from "./ShopRegistry";

export class BookSale{
     bookUniqueNumber!:number;
	
    bookId!: number;
    bookName!: string;
	 authorName!:string;
	price!:number;
	availableQuantity!:number;
	shopName!:string;
    contactNumber!: number;
    shopRegisterRef!:ShopRegistry;
}