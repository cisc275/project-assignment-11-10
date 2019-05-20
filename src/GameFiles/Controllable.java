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
	int xSpeed;
	
	/**
	 * speed with which you move up and down
	 */
	
	int ySpeed;
	
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
		if (this.hitbox.ypoints[0] <= 0) {
			int x1 = this.hitbox.xpoints[0];
			int x2 = this.hitbox.xpoints[1];
			int x3 = this.hitbox.xpoints[2];
			int x4 = this.hitbox.xpoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(x1, 0);
			this.hitbox.addPoint(x2, height);
			this.hitbox.addPoint(x3, height);
			this.hitbox.addPoint(x4, 0);
							
		}
		
		if (this.hitbox.ypoints[1] >= View.frame.getHeight()) {
			int x1 = this.hitbox.xpoints[0];
			int x2 = this.hitbox.xpoints[1];
			int x3 = this.hitbox.xpoints[2];
			int x4 = this.hitbox.xpoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(x1, View.frame.getHeight() - height);
			this.hitbox.addPoint(x2, View.frame.getHeight());
			this.hitbox.addPoint(x3, View.frame.getHeight());
			this.hitbox.addPoint(x4, View.frame.getHeight() - height);			
		}
		if (this.hitbox.xpoints[3] >= View.frame.getWidth()) {
			int y1 = this.hitbox.ypoints[0];
			int y2 = this.hitbox.ypoints[1];
			int y3 = this.hitbox.ypoints[2];
			int y4 = this.hitbox.ypoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(View.frame.getWidth() - width, y1);
			this.hitbox.addPoint(View.frame.getWidth() - width, y2);
			this.hitbox.addPoint(View.frame.getWidth(), y3);
			this.hitbox.addPoint(View.frame.getWidth(), y4);		
		}
		
		if (this.hitbox.xpoints[0] <= 0) {
			int y1 = this.hitbox.ypoints[0];
			int y2 = this.hitbox.ypoints[1];
			int y3 = this.hitbox.ypoints[2];
			int y4 = this.hitbox.ypoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(0, y1);
			this.hitbox.addPoint(0, y2);
			this.hitbox.addPoint(width, y3);
			this.hitbox.addPoint(width, y4);		
		}
		
	}

	

}
