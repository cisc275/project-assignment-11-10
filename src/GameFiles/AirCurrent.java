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
		this.img = createImage();
		this.setType(Type.AIRCURRENT);
	}
	
	public Polygon acReset() {
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x + width, y);
		this.hitbox.addPoint(width/ 2 + x, y + height);
		return this.hitbox;
	}
	
	@Override
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
			if(this.hitbox.xpoints[1] <= 0) {
				acReset();
			}
		}
	
	
	
	/**
	 * handles collision with osprey
	 * @param o
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		acReset();
		if (Osprey.xSpeed <= -2) {
		o.setXSpeed((Osprey.getXSpeed() + Constants.FISH_AC));
		}
		else {o.setXSpeed(-2);};
	}
	
	/**
     * returns a BufferedImage that is unscaled
     * @author andrew thompson
     */
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(Constants.IMG_AIRCURRENT));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}

	
	
}

