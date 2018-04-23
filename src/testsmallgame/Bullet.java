/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsmallgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author teodora
 */
public class Bullet extends GameObject {

    private Handler handler;
    
    public Bullet(int x, int y, ID id, Handler handler, int mx, int my) {
        super(x, y, id);
        this.handler = handler;
        velX = (mx - x)/20;// speed
        velY = (my - y)/20;//
        
    }

   
    public void tick() {
       x += velX;
       y += velY;
     // y -= 10;
     
     for(int i=0; i < handler.object.size(); i++){
        GameObject temp = handler.object.get(i);
            if(temp.getId() == ID.Block){
                if(getBounds().intersects(temp.getBounds())){
                //bullet touching bounds of block
                    handler.removeObject(this);
                    //remove instance of bullet
                    
                    
                }
            }  
     
     }
        
        
      
    
    }

   
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 8, 8);
        
    }

    
    public Rectangle getBounds() {
       return new Rectangle(x,y, 8, 8);
    }
    
}
