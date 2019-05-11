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

	public Fish(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.img = createImage();
		this.setType(Type.FISH);
	}
	
	

	/** handles fish collision with osprey
	 * @param o
	 * @author Timothy Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		resetPoly();
		
		if (Osprey.xSpeed >= Constants.FISH_X_SPEED_TEST) {
			o.setXSpeed((Osprey.getXSpeed() - Constants.FISH_AC));
		}
			else {o.setXSpeed(Constants.FISH_X_SPEED_TEST);
			};
		}
	
	@Override
	public void handleCollision(ClapperRail c) {
		resetPoly();
	}
	
	
	// creates image for fish
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File(Constants.IMG_FISH));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
}
