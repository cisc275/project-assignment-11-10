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
        try {
            this.img = ImageIO.read(new File(Constants.IMG_BACKGROUND));
        }
        catch (Exception e) { 
        	System.out.println(e); 
        }
    }
 
    /**
     * Method that draws the image onto the Graphics object passed
     * @param window
     * @author Tim Mazzarelli
     */
    public void move() {

    	this.hitbox.translate((int)Osprey.xSpeed, 0); 
    	if (this.hitbox.xpoints[0] > -View.frame.getWidth()){	  

    	}
    	else {
    		
    		this.hitbox.reset();
    		this.hitbox.addPoint(this.width, this.y);
    		this.hitbox.addPoint(this.width, this.y + this.height);
    		this.hitbox.addPoint(this.width + this.width, this.y + this.height);
    		this.hitbox.addPoint(this.width, this.y);
    	}
    	}
    
    		

    	
    
    /**
     * setter for x pos
     * @param x,
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * getter for x pos
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * setter for y pos
     * @param y,
     */
    public void setY(int y) {
    	this.y = y;
    }
    
    /**
     * getter for y pos
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * getter for image width
     */
    public int getImageWidth() {
        return image.getWidth();
    }
}
