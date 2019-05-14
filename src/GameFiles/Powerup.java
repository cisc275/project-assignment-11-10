package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Powerup extends Collectable {

	/**
	 * @param x
	 * @param y 
	 * @param width
	 * @param height
	 * 
	 * A constructor that takes values for all fields as input parameters
	 */
	public Powerup(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.xSpeed = 0;
		this.imgFileName = Constants.ANIMATION_FISH;
	}

	/**
	 * @param ClapperRail cr
	 * 
	 * deals with collision with respect to ClapperRail
	 * 
	 * @author tim mazzarelli
	 */
	@Override
	public void handleCollision(ClapperRail cr) {
		this.resetPoly();
		new Quiz("td");
	}
	
	@Override
	public void handleCollision(Osprey o) {
		resetPoly();
		new Quiz("sides");
	}


	private BufferedImage createImage(){
		BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(Constants.IMG_FISH));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}

}
