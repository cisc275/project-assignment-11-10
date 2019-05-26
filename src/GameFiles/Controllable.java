package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * represents all objects that can be controlled by the user
 *
 */
public class Controllable extends GameObject {
	
	/**
	 * speed with which you move left or right
	 */
	private int xSpeed;
	
	/**
	 * speed with which you move up and down
	 */
	private int ySpeed;
		
	
	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *  a constructor that takes values for all fields as input parameters
	 */
	public Controllable(int x, int y, int width, int height) {
		super(x,y,width,height);
		
	}
	
	
	/**
	 * checks for Controllable object colliding with the walls
	 * 
	 * @author tim mazzarelli
	 * 
	 */ 
	public void boundaries() {
		// if the y is at the top of the screen
		if (this.hitbox.getBounds2D().getMinY() <= Constants.FRAME_Y - Constants.FRAME_Y) {
			int x1 = (int)this.hitbox.getBounds2D().getMinX();
			int x2 = (int)this.hitbox.getBounds2D().getMinX();
			int x3 = (int)this.hitbox.getBounds2D().getMaxX();
			int x4 = (int)this.hitbox.getBounds2D().getMaxX();
			
			this.hitbox.reset();
			this.hitbox.addPoint(x1, height - height);
			this.hitbox.addPoint(x2, height);
			this.hitbox.addPoint(x3, height);
			this.hitbox.addPoint(x4, height - height);
							
		}
		 //  at bottom of screen
		if (this.hitbox.getBounds2D().getMaxY() >= Constants.FRAME_Y) {
			int x1 = (int)this.hitbox.getBounds2D().getMinX();
			int x2 = (int)this.hitbox.getBounds2D().getMinX();
			int x3 = (int)this.hitbox.getBounds2D().getMaxX();
			int x4 = (int)this.hitbox.getBounds2D().getMaxX();
			
			this.hitbox.reset();
			this.hitbox.addPoint(x1, Constants.FRAME_Y - height);
			this.hitbox.addPoint(x2, Constants.FRAME_Y);
			this.hitbox.addPoint(x3, Constants.FRAME_Y);
			this.hitbox.addPoint(x4, Constants.FRAME_Y - height);			
		}
		
		// at right boundary of screen
		if (this.hitbox.getBounds2D().getMaxX() >= Constants.FRAME_X) {
			int y1 = (int)this.hitbox.getBounds2D().getMinY();
			int y2 = (int)this.hitbox.getBounds2D().getMaxY();
			int y3 = (int)this.hitbox.getBounds2D().getMaxY();
			int y4 = (int)this.hitbox.getBounds2D().getMinY();
			
			this.hitbox.reset();
			this.hitbox.addPoint(Constants.FRAME_X - width, y1);
			this.hitbox.addPoint(Constants.FRAME_X - width, y2);
			this.hitbox.addPoint(Constants.FRAME_X, y3);
			this.hitbox.addPoint(Constants.FRAME_X, y4);		
		}
		// at left boundary of screen
		if (this.hitbox.getBounds2D().getMinX() <= Constants.FRAME_X - Constants.FRAME_X) {
			int y1 = (int)this.hitbox.getBounds2D().getMinY();
			int y2 = (int)this.hitbox.getBounds2D().getMaxY();
			int y3 = (int)this.hitbox.getBounds2D().getMaxY();
			int y4 = (int)this.hitbox.getBounds2D().getMinY();
			
			this.hitbox.reset();
			this.hitbox.addPoint(width - width, y1);
			this.hitbox.addPoint(width - width, y2);
			this.hitbox.addPoint(width, y3);
			this.hitbox.addPoint(width, y4);		
		}
	}

	
	/**
	 * gives you xSpeed of the controllable object
	 * @return xSpeed 
	 * @author Tim Mazzarelli
	 */
	public int getxSpeed() {
		return xSpeed;
	}

	/**
	 * sets xSpeed of the controllable object
	 * @param xSpeed
	 * @author Tim Mazzarelli
	 */
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * gives you the ySpeed of your Controllable object
	 * @return int ySpeed
	 * @author Tim Mazzarelli
	 */
	public int getySpeed() {
		return ySpeed;
	}

	/**
	 * sets ySpeed of the controllable object
	 * @param ySpeed
	 * @author Tim Mazzarelli
	 */
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

}
