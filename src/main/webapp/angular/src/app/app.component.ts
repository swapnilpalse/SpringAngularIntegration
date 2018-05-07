import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css',
  '../../node_modules/bootstrap/dist/css/bootstrap.css']
})
export class AppComponent implements OnInit {
  public submitted:boolean;      
  roomsearch:FormGroup;
  rooms:Room[];  
   ngOnInit(){
       this.roomsearch=new FormGroup({
        checkin:new FormControl(''),
           checkout:new FormControl('')   
       });
       
       this.rooms=ROOMS;
   }
    onSubmit({value,valid}: {value:Roomsearch, valid:boolean}){
     console.log(value);   
    }
    
    
    
  public intro_attractions =require("./images/intro_attractions.jpg");
  public intro_room =require("./images/intro_room.jpg");
    public intro_pool =require("./images/intro_pool.jpg");
    public intro_dining =require("./images/intro_dining.jpg");
    public intro_wedding =require("./images/intro_wedding.jpg");
      public arrow =require("./images/arrow.png");
      public dining_rooftop =require("./images/dining_rooftop.jpg");
public dining_smoothiebar =require("./images/dining_smoothiebar.jpg");
public dining_lattes =require("./images/dining_lattes.jpg");
    public twitter =require("./images/twitter.png");  
      public facebook =require("./images/facebook.png");     
      public youtube =require("./images/youtube.png");    
      
    
}

export interface Roomsearch{
        checkin:string;
        checkout:string;
    }

export interface Room{
        id:string;
        roomNumber:string;
    price:string;
    links:string;
    }

var ROOMS:Room[]=[{
 "id":"123465",
  "roomNumber":"4109",
  "price": "125",
   "links":""    
},
    {
 "id":"423465",
  "roomNumber":"4110",
  "price": "456",
   "links":""    
},
    {
 "id":"853465",
  "roomNumber":"4111",
  "price": "250",
   "links":""    
}]


