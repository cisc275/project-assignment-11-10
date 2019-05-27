package GameFiles;

import java.awt.Polygon;

/**
 * represents air currents that osprey can use to fly faster 
 *
 */
public class AirCurrent extends Collectable {	 
	
	
	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	
	public AirCurrent(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.hitbox = acReset();
		this.imgFileName = Constants.ANIMATION_AIRCURRENT;
		this.curImg = randy.nextInt(imgFileName.length);
	}
	
	/**
	 * @return Returns the reset polygon
	 * 
	 * specific reset for our air current
	 * 
	 * @author tim Mazzarelli
	 */
	
	
	public Polygon acReset() {
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x + (width/Constants.AIRCURRENT_OFFSET), y);
		this.hitbox.addPoint(x + width, y + (height/Constants.AIRCURRENT_OFFSET));
		this.hitbox.addPoint(x, y + (height/Constants.AIRCURRENT_OFFSET));
		return this.hitbox;
	}
	
	/**
	 * moves the air current across our screen
	 * 
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void move() {
		this.hitbox.translate(this.getxSpeed(), Constants.COLLECTABLE_YSPEED); //ySpeed is 0 for all collectables
			if(this.hitbox.getBounds2D().getMaxX() <= Constants.FRAME_X - Constants.FRAME_X) {
				acReset();
			}
			animate(Constants.AIRCURRENT_ANIMATION_TICK_RATE);
	}
	
	
	
	/**
	 * handles collision with osprey
	 * @param o Game Osprey
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		Osprey.negHitOs = true; // for animation, negative collision means red
		acReset();
		o.setXSpeed((Osprey.getXSpeed() + Constants.FISH_AC));
		if (Osprey.xSpeed >= Constants.OSPREY_MIN_SPEED) {
			o.setXSpeed(Constants.OSPREY_MIN_SPEED);
		}
	}
		
	
}

