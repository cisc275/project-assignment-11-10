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
	private static final int AC = 1;
	 
	
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox
	 * @param img
	 * @param xSpeed
	 
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public AirCurrent(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed) {
		super(x,y,width,height, hitbox, img, xSpeed);
		this.img = createImage();
		this.setType(Type.AIRCURRENT);
	}
	
	
	/**
	 * handles collision with osprey
	 * @param o
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x, y + height);
		this.hitbox.addPoint(x + width, y + height);
		this.hitbox.addPoint(x + width, y);
		if (Osprey.xSpeed <= -2) {
		o.setXSpeed((Osprey.getXSpeed() + AC));
		}
		else {o.setXSpeed(-2);};
	}
	
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File(Constants.IMG_AIRCURRENT));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}

	
	
}

