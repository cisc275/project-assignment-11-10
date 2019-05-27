package GameFiles;

/**
 * 
 *represents all collectable items in both games
 */
public class Collectable extends GameObject {
	
	/**
	 * describes the speed with which collectables move
	 */	
	private int xSpeed;
	

	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *  a constructor that takes values for all fields as input parameters
	 */
	 
	public Collectable(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.xSpeed = -randy.nextInt(Constants.COLLECTABLE_RANDOM_SPEED) - Constants.COLLECTABLE_RANDOM_OFFSET;

	}
	
	
	/**
	 * moves the aircurrent according to x speed and resets if it goes back over the left screen
	 * @author Tim Mazzarelli
	 */
	public void move() {
		this.hitbox.translate(this.xSpeed, Constants.COLLECTABLE_YSPEED);
		if(this.hitbox.getBounds2D().getMaxX() <= Constants.FRAME_X - Constants.FRAME_X) {
			resetPoly();
		}
	}
	
	
	/**
	 * gives you xSpeed of the collectable object
	 * @return Value of xSpeed 
	 * @author Tim Mazzarelli
	 */
	public int getxSpeed() {
		return xSpeed;
	}
	
	/**
	 * sets your xSpeed of the collectable object
	 * @param xSpeed  New xSpeed
	 * @author Tim Mazzarelli
	 */

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	
}
