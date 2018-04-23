
package testsmallgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author teodora
 */
public class Obstacle extends GameObject{
    private Handler handler;
    //Random r = new Random();
    int health = 5;
    
    public Obstacle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    
    
    }

    
    public void tick() {
       x += velX;
       y += velY;
       for(int i=0; i < handler.object.size(); i++){
        GameObject temp = handler.object.get(i);
            if(temp.getId() == ID.Bullet){
                if(getBounds().intersects(temp.getBounds())){
                //is the breakable wall getting hit by bullet
                health = health - 1; // must be hit 5 times
                handler.removeObject(temp); //remove bullet
                if (health == 0) handler.removeObject(this);
                    //remove this wall from map
                    
                    
                }
            }  
       
        }
    }   

    
    public void render(Graphics g) {
       g.setColor(Color.yellow);
       g.fillRect(x, y, 32, 32);
    }

    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32,32);
    }
    
}
