/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsmallgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Goal : Not to have key lag, easy transitions and response
 * Use of this class: Set key states T/F (Press/Release)
 * @author teodora
 */
public class KeyControls implements KeyListener{
    Handler handler;// allowes us to access handler created in GAME - not a new class
    
    public KeyControls(Handler handler){
    this.handler = handler;
   
    }
   
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for (int i =0; i< handler.object.size(); i ++){
            //loop thorough all objects
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){//find player
                
                if (tempObject.getId() == ID.Player && key == KeyEvent.VK_W) handler.setUp(true);
                if (key == KeyEvent.VK_S) handler.setDown(true);
                if (key == KeyEvent.VK_A) handler.setLeft(true);
                if (key == KeyEvent.VK_D) handler.setRight(true);
                /*handler.addObject(new Bullet(tempObject.getX()+16, tempObject.getY()+26, ID.Bullet, handler));
                if (key == KeyEvent.VK_SPACE) handler.setSpace(true);//shooting I tried with spacebar but buggy*/
            } if(tempObject.getId() == ID.Enemy){//find player2
                
                if (tempObject.getId() == ID.Enemy && key == KeyEvent.VK_UP) handler.setUp(true);
                if (key == KeyEvent.VK_DOWN) handler.setDown(true);
                if (key == KeyEvent.VK_LEFT) handler.setLeft(true);
                if (key == KeyEvent.VK_RIGHT) handler.setRight(true);
                
            }
        }
        
    
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for (int i =0; i< handler.object.size(); i ++){
            //loop thorough all objects
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){//find player
                if (tempObject.getId() == ID.Player && key == KeyEvent.VK_W) handler.setUp(false);
                if (key == KeyEvent.VK_S) handler.setDown(false);
                if (key == KeyEvent.VK_A) handler.setLeft(false);
                if (key == KeyEvent.VK_D) handler.setRight(false);
                if (key == KeyEvent.VK_SPACE) handler.setSpace(false);//shooting
            }
            if(tempObject.getId() == ID.Enemy){//find player2
                
                if (tempObject.getId() == ID.Enemy && key == KeyEvent.VK_UP) handler.setUp(false);
                if (key == KeyEvent.VK_DOWN) handler.setDown(false);
                if (key == KeyEvent.VK_LEFT) handler.setLeft(false);
                if (key == KeyEvent.VK_RIGHT) handler.setRight(false);
                
            }
        }
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }
            
}
