package GameFiles;
import java.util.ArrayList;

import javax.swing.JButton;
/**
 * all logic for the side scroll game
 *
 */
public class SideScrollModel extends Model {
		
	/**
	 * a list of the buttons in our game
	 */
	private Fish fish;
	private Trash trash1;
	private Trash trash2;
	private Trash trash3;
	private Osprey osprey;
	private int currY;
	private boolean isDiving = false;
	
	public void advanceWorld() {
		fish.setX(fish.getX()-1);
		trash1.setX(trash1.getX() -1);
		trash2.setX(trash2.getX() -1);
		trash3.setX(trash3.getX() -1);
		if((fish.getX() + 134) <= 0) {
			fish.setX(800);
		}
		if((trash1.getX() + 134) <= 0) {
			trash1.setX(800);
		}
		if((trash2.getX() + 134) <= 0) {
			trash2.setX(800);
		}
		if((trash3.getX() + 134) <= 0) {
			trash3.setX(800);
		}
		if (osprey.getY() >= 550) {
			osprey.speed = -50;
		}
		if ((osprey.getY() == currY) && (osprey.isDiving() == true)) {
			osprey.speed = 0;
			osprey.
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
	public void miniMap() {
		
		
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.start();
		
	}
	
}
