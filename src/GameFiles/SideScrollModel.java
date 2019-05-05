package GameFiles;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


/**
 * all logic for the side scroll game
 *
 */
public class SideScrollModel extends Model {
		
	/**
	 * a list of the buttons in our game
	 */
	
	Background backOne;
	Background backTwo;

	
	public SideScrollModel() {
	}
	
	
	public void advanceWorld(ArrayList<GameObject> g) {
		for (GameObject a : g) {
			a.move();
			a.collision(g);
		}
		
	}
	/**
	 * 
	 * this method will contain the logic for moving the background image
	 * to create the illusion that the foreground images are moving
	 */
	
	/**
	 *  
	 * this method will contain the logic for advancing the icon on 
	 * the minimap to show progress during the birds migration
	 */
	public void miniMap(ArrayList<GameObject> g) {
		g.get(0).setY(g.get(0).getY() + 5);
	}
	
	public static void main(String[] args) {
		new Controller("sideScroll");
		
		
	}
}
	
	