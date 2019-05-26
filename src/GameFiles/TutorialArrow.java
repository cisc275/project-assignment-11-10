/**
 * 
 */
package GameFiles;

/**
 * @author wolginm
 *
 */
public class TutorialArrow extends TutorialObject {

	/**
	 * Creates a Tutorial Arrow with a hitbox of and an img.
	 * @param x			The x location of the object
	 * @param y			The x location of the object
	 * @param w		Width of the object
	 * @param h		Height of the object
	 * @param img Sting array of file paths
 	 */
	public TutorialArrow(int x, int y, int w, int h, String[] img) {
		super(x, y, w, h, img);
	}
	
	@Override
	public void animate(int constant) {
		
	}
}
