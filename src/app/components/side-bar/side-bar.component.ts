import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
  ngOnInit(): void {
      
  
    const btn:any= document.querySelector("#btn");;
    const sidebar: any= document.querySelector(".sidebar");;
    const searchBtn: any = document.querySelector(".bx-search");

   


    
    btn.onclick = function () : void{
      sidebar?.classList.toggle("active")
    };
    searchBtn.onclick = function ():void {
      sidebar?.classList.toggle("active")
    };
  }
}
