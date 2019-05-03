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
	 * moves aircurrent according to it's xSpeed and loops it back around if it goes
	 * off screen
	 * @author tim Mazzarelli
	 */
	
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
		if((this.hitbox.xpoints[3] <= 0)) {
			this.hitbox.reset();
			this.hitbox.addPoint(x, y);
			this.hitbox.addPoint(x, y + height);
			this.hitbox.addPoint(x + width, y + height);
			this.hitbox.addPoint(x + width, y);
			
		}
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
		o.setXSpeed(Osprey.getXSpeed() + AC);
		}
		else {};
	}
	
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("brown_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}

	
	
}

