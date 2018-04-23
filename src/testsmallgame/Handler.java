/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsmallgame;
import java.util.LinkedList;
import java.awt.Graphics;
/**
 *
 * @author teodora
 */
public class Handler {
   protected LinkedList<GameObject> object = new LinkedList<GameObject>();
   private boolean up = false, down = false, right = false, left = false;
   private boolean space = false;
   public void tick(){
       for (int i = 0; i < object.size(); i++){
           GameObject tempObject = object.get(i);
           tempObject.tick();
       }
   
   }
   public void render(Graphics g){
       for (int i = 0; i < object.size(); i++){
           GameObject tempObject = object.get(i);
           tempObject.render(g);
       }
   }
   //add and remove objects to linked list
   public void addObject(GameObject thisObject){
       object.add(thisObject);
   }
   public void removeObject(GameObject thisObject){
        object.remove(thisObject);
   } 

   
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
    
    
    public boolean isSpace() {
        return up;
    }

   
    public void setSpace(boolean space) {
        this.space = space;
    }

}
