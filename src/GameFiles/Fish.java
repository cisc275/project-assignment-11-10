package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents fish that will give both birds a boost
 *
 */
public class Fish extends Collectable {
	
	final int AC = 1;
	
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

	public Fish(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed) {
		super(x,y,width,height, hitbox, img, xSpeed);
		this.img = createImage();
		this.setType(Type.FISH);
	}
	

	/**
	 * calls ClapperRail handleCollision passing in this
	 * @param cr
	 * @author andrew thompson
	 */
	public void handleCollision(ClapperRail cr) {
		cr.handleCollision(this);
	}

	/** handles fish collision with osprey
	 * @param o
	 * @author Timothy Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x, y + height);
		this.hitbox.addPoint(x + width, y + height);
		this.hitbox.addPoint(x + width, y);
		if (Osprey.xSpeed >= -10) {
			o.setXSpeed((Osprey.getXSpeed() - AC));
		}
			else {o.setXSpeed(-10);
			};
		}
	
	// creates image for fish
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("fish_west1.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
}
