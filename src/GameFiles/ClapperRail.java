package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents the clapperrail for the side scroll game 
 *
 */
public class ClapperRail extends Bird {
	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @param speed
	 * @param type
	 * @param hidden
	 * @param carryStick
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	
	public ClapperRail(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
			int yMax, int speed, Type type, boolean hidden, boolean carryStick, boolean isDiving,
			int currY, int xSpeed, int ySpeed) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, type, isDiving, currY, xSpeed, ySpeed);
	}
	
	/**
	 * describes if the bird's coordinates matches with that of a bush on screen
	 */
	boolean hidden; 
	/**
	 * describes if the bird has a stick
	 */
	boolean carryStick; 
	
	public BufferedImage getImg() {
		BufferedImage buffImg;
		try {
    		buffImg = ImageIO.read(new File(System.getProperty("user.dir").replace("\\","/")+"/imgs/cr.png"));
    		return buffImg;
		} catch (IOException e) {
    		e.printStackTrace();
    	}
		return null;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isCarryStick() {
		return carryStick;
	}

	public void setCarryStick(boolean carryStick) {
		this.carryStick = carryStick;
	}
}
