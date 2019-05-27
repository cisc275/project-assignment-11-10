package GameFiles;

/**
 * Objects in the game that the user will not be able to control
 *
 */
public class NonControllable extends GameObject {

	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	
	public NonControllable(int x, int y, int width, int height) {
		super(x,y,width,height);
	}

}
