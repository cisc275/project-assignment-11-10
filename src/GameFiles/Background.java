package GameFiles;

/**
 * represents SideScroll background
 */

public class Background extends GameObject{
	
	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	
    public Background(int x, int y, int width, int height) {
    	super(x, y, width, height);
    	this.hitbox.addPoint(width, height - height);
    	this.hitbox.addPoint(width, height);
    	this.hitbox.addPoint(width + width, height);
    	this.hitbox.addPoint(width + width, height - height);
        this.imgFileName = Constants.ANIMATION_BACKGROUND;
        this.curImg = randy.nextInt(imgFileName.length);
    }
 
    /**
     * moves the background across the screen and reset appropriately
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
     * @author Tim Mazzarelli
     */
    public void bgReset() {
    	this.hitbox.reset();
		this.hitbox.addPoint(x, this.y);
		this.hitbox.addPoint(x, this.height);
		this.hitbox.addPoint(width, this.height);
		this.hitbox.addPoint(width, this.y);
		this.hitbox.addPoint(width, this.y);
    	this.hitbox.addPoint(width, this.height);
    	this.hitbox.addPoint(width + width, this.height);
    	this.hitbox.addPoint(width + width, this.y);	
    }
    
    	
    
    /**
     * setter for x pos
     * @param x New x value
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
     * @param y New y value
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
