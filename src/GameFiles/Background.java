package GameFiles;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Background extends GameObject{
	private BufferedImage image;
	 
    private int x;
    private int y;
   
  
   
    /**
     * @param x
     * @param y
     * 
     * constructor for Background
     */
 
    public Background(int x, int y, int width, int height) {
    	super(x, y, width, height);
    	
        
        // Try to open the image file background.png
        try {
            this.img = ImageIO.read(new File(Constants.IMG_BACKGROUND));
           
        }
        catch (Exception e) { System.out.println(e); }
     
 
    }
 
    /**
     * Method that draws the image onto the Graphics object passed
     * @param window
     * @author Tim Mazzarelli
     */
    public void move() {
    	if (this.hitbox.xpoints[0] > -Constants.FRAME_X){
    	this.hitbox.translate((int)Osprey.xSpeed, 0);     
        }
    	else {
    		this.hitbox.reset();
    		this.hitbox.addPoint(this.width, this.y);
    		this.hitbox.addPoint(this.width, this.y + this.height);
    		this.hitbox.addPoint(this.width + this.width, this.y + this.height);
    		this.hitbox.addPoint(this.width, this.y);
    		this.hitbox.translate((int)Osprey.xSpeed, 0); 
    		
    	}
    	
    	  
      
 
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getImageWidth() {
        return image.getWidth();
    }

	
 
}
