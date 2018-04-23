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
public class Enemy extends GameObject {
    Handler handler;
    private int left , right, up, down;
    public Enemy(int x, int y, ID id, Handler handler ) {
        super(x, y, id);
        this.handler = handler;
        this.left = left;
    	this.right = right;
    	this.up = up;
    	this.down = down;
    }
    
    
    public void tick() {
        x += velX;
        y += velY;
        
        collision();
        //movement
       
        
        if(handler.isUp()) velY = -3;
        else if(!handler.isDown()) velY= 0;
        
        if(handler.isDown()) velY = 3;
        else if(!handler.isUp()) velY= 0;
        
        if(handler.isRight()) velX = 3;
        else if(!handler.isLeft()) velX= 0;
        
        if(handler.isLeft()) velX = -3;
        else if(!handler.isRight()) velX= 0;
        
        
        
       
    }
    
    private void collision(){
        for(int i=0; i < handler.object.size(); i++){
            GameObject temp = handler.object.get(i);
            if(temp.getId() == ID.Block){
                if(getBounds().intersects(temp.getBounds())){
                //bounds of tank touching boundss of block
                    x += velX *-1;
                    y += velY *-1;
                }
            }
            if(temp.getId() == ID.Obstacle){
                if(getBounds().intersects(temp.getBounds())){
                //bounds of tank touching boundss of block
                    x += velX *-1;
                    y += velY *-1;

                }
            }
        }
    }
    
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 48);
    }

   
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
    
}
