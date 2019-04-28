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
	 * describes if the bird's coordinates matches with that of a bush on screen
	 */
	boolean hidden; 
	/**
	 * describes if the bird has a stick
	 */
	boolean carryStick; 
	
	final private int MOVE_AMOUNT = 10;
	
	public ClapperRail(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.setType(Type.CLAPPERRAIL);
	}
	
	public ClapperRail(BufferedImage pic, int xloc, int yloc) {
		super(pic,xloc,yloc);
		this.setType(Type.CLAPPERRAIL);
	}

	public ClapperRail(String string, int i, int j) {
		super(string,i,j);
		this.setType(Type.CLAPPERRAIL);
	}

	public ClapperRail(int i, int j) {
		super("cr.png",i,j);
		this.setType(Type.CLAPPERRAIL);
	}
  
	public void move() {
		x = x + MOVE_AMOUNT;
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
