package GameFiles;

import java.awt.Polygon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents air currents that osprey can use to fly faster 
 *
 */
public class AirCurrent extends Collectable {	 
	
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public AirCurrent(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.hitbox = acReset();
		this.imgFileName = Constants.ANIMATION_AIRCURRENT;
		this.setType(Type.AIRCURRENT);
	}
	
	/**
	 * @param none
	 * @return Polygon hitbox
	 * 
	 * specific reset for our air current
	 * 
	 * @author tim Mazzarelli
	 */
	
	
	public Polygon acReset() {
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x + width/2, y);
		this.hitbox.addPoint(x + width, y + height/2);
		this.hitbox.addPoint(x, y + height/2);
		return this.hitbox;
	}
	
	/**
	 * @param none
	 * @return none
	 * 
	 * moves the air current across our screen
	 * 
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
			if(this.hitbox.xpoints[2] <= 0) {
				acReset();
			}
		}
	
	
	
	/**
	 * handles collision with osprey
	 * @param Osprey o
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		acReset();
		o.setXSpeed((Osprey.getXSpeed() + Constants.FISH_AC));
		if (Osprey.xSpeed >= Constants.OSPREY_MIN_SPEED) {
			o.setXSpeed(-2);
		}
	}
	
//	/**
//     * returns a BufferedImage that is unscaled
//     * @author andrew thompson
//     */
//	private BufferedImage createImage(){
//		BufferedImage bufferedImage;
//    	try {
//    		bufferedImage = ImageIO.read(new File(Constants.IMG_AIRCURRENT));
//    		return bufferedImage;
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    	return null;
//	}

	
	
}

