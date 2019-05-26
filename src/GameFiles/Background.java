package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents SideScroll background
 */

public class Background extends GameObject{
	
    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * 
     * constructor for Background
     */
	
    public Background(int x, int y, int width, int height) {
    	super(x, y, width, height);
    	this.hitbox.addPoint(width, height - height);
    	this.hitbox.addPoint(width, height);
    	this.hitbox.addPoint(width + width, height);
    	this.hitbox.addPoint(width + width, height - height);
        this.imgFileName = Constants.ANIMATION_BACKGROUND;
        this.curImg = randy.nextInt(imgFileName.length);
        this.setType(Type.BACKGROUND);
    }
 
    /**
     * moves the background across the screen and reset appropriately
     * @param window
     * @author Tim Mazzarelli
     */
    public void move() {
    	this.hitbox.translate(Osprey.xSpeed, Constants.BACKGROUND_YSPEED);
    	if (this.hitbox.getBounds2D().getCenterX() <= Constants.FRAME_X - Constants.FRAME_X){	 
    		bgReset();
    	}
    }
    
    
    /**
     * resets the background to do our scroll
     * 
     * @author Tim Mazzarelli
     */
    public void bgReset() {
    	this.hitbox.reset();
		this.hitbox.addPoint(0, this.y);
		this.hitbox.addPoint(0, this.y + this.height);
		this.hitbox.addPoint(width, this.y + this.height);
		this.hitbox.addPoint(width, this.y);
		this.hitbox.addPoint(width, 0);
    	this.hitbox.addPoint(width, height);
    	this.hitbox.addPoint(width + width, height);
    	this.hitbox.addPoint(width + width, 0);	
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
}
