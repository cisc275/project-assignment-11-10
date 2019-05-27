package GameFiles;

/**
 * super class for both bird objects
 */
public class Bird extends Controllable{
	
	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	
	public Bird(int x, int y, int width, int height) {
		super(x,y,width, height);		
	}
}
