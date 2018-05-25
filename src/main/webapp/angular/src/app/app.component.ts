import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {Http,Response} from '@angular/http';
//import {Observable} from 'rxjs/Rx';
import { map } from 'rxjs/operators';
import { HttpService } from './http.service';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css',
  '../../node_modules/bootstrap/dist/css/bootstrap.css']
})
export class AppComponent implements OnInit {
  constructor(private service:HttpService){
      } 

  private baseUrl:string   = 'http://localhost:8080';    
  public submitted:boolean;      
  roomsearch:FormGroup;
  rooms:Room[];  
   ngOnInit(){
       this.roomsearch=new FormGroup({
        checkin:new FormControl(''),
           checkout:new FormControl('')   
       });
       
   }
    onSubmit({value}: {value:Roomsearch}){
     this.getAll().subscribe(rooms=>this.rooms=rooms,
     err=>{
         console.log(err);
        }
     );
    }
    reserveRoom(value:string){
     console.log(value);   
    }
    
    getAll(){
      //this.mapRoom(this.http.get(this.baseUrl+'/room/reservation/v1?checkin=2017-03-01&checkout=2017-03-08').pipe(map((res:Response)=>res.json())));
      //return this.http.get(this.baseUrl+'/room/reservation/v1?checkin=2017-03-01&checkout=2017-03-08').pipe(map((res:Response)=>res.json()));
      console.log(this.service.getData());
       return this.service.getData();   
    }
    
    mapRoom(response:Response):Room[]{
      return response.json().content;
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

