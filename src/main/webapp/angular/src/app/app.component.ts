import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css',
  '../../node_modules/bootstrap/dist/css/bootstrap.css']
})
export class AppComponent {
  title = 'app';
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
