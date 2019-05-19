package GameFiles;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;


/**
 * all logic for the side scroll game
 *
 */
public class SideScrollModel extends Model {
	
	/**
	 * osprey used by the Model for key inputs
	 */
	Osprey o;
	
	/**
	 * to see if the final quiz question was answered correctly
	 */
	static boolean right;
	
	public SideScrollModel() {
		o = new Osprey(Constants.OSPREY_STARTX, 100, 50, 50);
		game = new ArrayList<GameObject>();
		game.add(o);
	}
	
	 /**
     * takes an ArrayList of GameObjects and moves them while checking for collision
     * @param g
     * @author Tim Mazzarelli
     */
	public void updateLocation(ArrayList<GameObject> g) {
    	ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
    	for (GameObject a : g) {
			a.move();
			a.collision(g);			
			if (a.removeObject()) toRemove.add(a);
		}
    	g.removeAll(toRemove);
		if (Mate.caughtUp) {
			Model.gameOver = true;
		}
		
	}
	
	 /**
     * takes a hashset of integers and moves osprey accordingly
     * @param HashSet<Integer> keyPresses
     * @author andrew thompson
     */
	@Override
	public void handleMove(HashSet<Integer> keyPresses) {
		if(!o.isDiving) {
			o.setYSpeed(0);
			for(Integer key: keyPresses) {
				switch(key) {
				case Constants.UP_KEY_CODE:
					if(!o.isDiving) {
						o.setYSpeed(-o.getMaxYSpeed());
					}
					break;
				case Constants.DOWN_KEY_CODE:
					if(!o.isDiving) {
						 o.setYSpeed(o.getMaxYSpeed());
					}
					
					break;
				case Constants.SPACE_KEY_CODE:
					o.dive();
				}
			}
		}
	}
	
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
	
	