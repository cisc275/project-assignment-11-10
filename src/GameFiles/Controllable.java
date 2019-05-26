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
	 * @param y
	 * @param x
	 * @param width
	 * @param height		
		Constructor for controllable object
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
			int x1 = this.hitbox.xpoints[0];
			int x2 = this.hitbox.xpoints[1];
			int x3 = this.hitbox.xpoints[2];
			int x4 = this.hitbox.xpoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(x1, height - height);
			this.hitbox.addPoint(x2, height);
			this.hitbox.addPoint(x3, height);
			this.hitbox.addPoint(x4, height - height);
							
		}
		
		// if object is at the bottom of the screen
		
		if (this.hitbox.getBounds2D().getMaxY() >= Constants.FRAME_Y) {
			int x1 = this.hitbox.xpoints[0];
			int x2 = this.hitbox.xpoints[1];
			int x3 = this.hitbox.xpoints[2];
			int x4 = this.hitbox.xpoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(x1, Constants.FRAME_Y - height);
			this.hitbox.addPoint(x2, Constants.FRAME_Y);
			this.hitbox.addPoint(x3, Constants.FRAME_Y);
			this.hitbox.addPoint(x4, Constants.FRAME_Y - height);			
		}
		
		// if the object is at the right of the screen
		if (this.hitbox.getBounds2D().getMaxX()  >= Constants.FRAME_X) {
			int y1 = this.hitbox.ypoints[0];
			int y2 = this.hitbox.ypoints[1];
			int y3 = this.hitbox.ypoints[2];
			int y4 = this.hitbox.ypoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(Constants.FRAME_X - width, y1);
			this.hitbox.addPoint(Constants.FRAME_X - width, y2);
			this.hitbox.addPoint(Constants.FRAME_X, y3);
			this.hitbox.addPoint(Constants.FRAME_X, y4);		
		}
		
		// if the object is at the left of the screen
		
		if (this.hitbox.getBounds2D().getMinX() <= Constants.FRAME_X - Constants.FRAME_X) {
			int y1 = this.hitbox.ypoints[0];
			int y2 = this.hitbox.ypoints[1];
			int y3 = this.hitbox.ypoints[2];
			int y4 = this.hitbox.ypoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(width - width, y1);
			this.hitbox.addPoint(width - width, y2);
			this.hitbox.addPoint(width, y3);
			this.hitbox.addPoint(width, y4);		
		}
		
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

}
