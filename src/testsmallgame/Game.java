package testsmallgame;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    private BufferedImage map = null;
    private BufferedImage floor = null;
    
    public int hp = 50;
    
    private Camera camera;
    
    public Game(){
        new Window(1000, 563, "Wizard Game", this);
        
         //start();
          
         handler = new Handler();
         camera = new Camera(0,0);
        
         this.addKeyListener(new KeyControls(handler));
         this.addMouseListener(new MouseInput(handler,camera));
         
         BufferedImageLoader loader = new BufferedImageLoader();
         map = loader.loadImage("Resources/custom_map.png");//always check path!!!
         floor = loader.loadImage("Resources/Background.bmp");
        
        try {
            //handler.addObject(new Tank(200, 100, ID.Player, handler)); //called in loadmap
            loadMap(map);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
         start();
    }
    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta=0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
             while(delta >= 1){
                tick();
                //updates++;
                delta--;
            }
            //render();
            repaint();
            frames++;
        
        if (System.currentTimeMillis() -  timer > 1000){
            timer +=1000;
            frames = 0;
            }
        }
        stop();
    }
    public void tick(){
        //update method
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player){
                camera.tick(handler.object.get(i));
            }
        }
        
        handler.tick(); 
        
        
    }
    
   // public void render(){
    protected void paintComponent(Graphics g) {
        //load
//        BufferStrategy bs = this.getBufferStrategy();
//        if (bs == null){
//            this.createBufferStrategy(3); //preload frames
//            return;
//        }
       // Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g; //cast to use camera
        ///////
        
        //background first
        g.setColor(Color.red);
        g.fillRect(0, 0, 1000, 563);
         /* for (int x=0; x<1000; x=x+100){
            for(int y=0; y<563; y=y+220){
            g.drawImage(floor, x, y, null); //fill entire map with floor image
            } 
        }*/
        
        g2d.translate(-camera.getX(), -camera.getY());
       
      
        //objects later
        handler.render(g);
        
        g2d.translate(camera.getX(), camera.getY());
        
        //health bar
        g.setColor(Color.gray);
        g.fillRect(4, 4, 100, 32);
        g.setColor(Color.green);
        g.fillRect(4, 4, hp*2, 32);
        g.setColor(Color.black);
        g.drawRect(4, 4, 100, 32);
        /////..
        g.dispose();
       // bs.show();
        
    }
    
    //load the game map
    private void loadMap(BufferedImage image) throws IOException{
        int w = image.getWidth();
        int h = image.getHeight();
        int right = image.getWidth()/2; //500
        
        for(int xx=0; xx< w; xx++){
            for(int yy=0; yy<h; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;//magic
                if (red == 255) handler.addObject(new Block (xx*32, yy*32, ID.Block));
                if (blue == 255) handler.addObject(new Tank(xx*32, yy*32, ID.Player, handler));
                if (green == 255) handler.addObject(new Obstacle (xx*32, yy*32, ID.Obstacle, handler));
            }
        }
         handler.addObject(new Enemy(100, 100, ID.Enemy, handler));
       
       
    }
    
    public static void main(String[] args) {
        new Game();
    }
    

}