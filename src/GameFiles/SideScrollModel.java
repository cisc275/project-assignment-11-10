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

	
	Background backOne;
	Background backTwo;
	Osprey o;
	static boolean right;
	

	
	public SideScrollModel() {
		o = new Osprey(100, 100, 50, 50);
		game = new ArrayList<GameObject>();
		game.add(o);
	}
	
	
	public void advanceWorld(ArrayList<GameObject> g) {
		for (GameObject a : g) {
			a.move();
			a.collision(g);
		}
		if (Mate.caughtUp) {
			Model.gameOver = true;
		}
		
	}
	@Override
	public void handleMove(HashSet<Integer> keyPresses) {
		for(Integer key: keyPresses) {
			switch(key) {
			case Constants.UP:
				if ((o.hitbox.xpoints[0] == 0) ||  (o.hitbox.xpoints[0] == 450)) {
					o.setYSpeed(0);
				}
				else {
					o.setYSpeed(-o.getMaxYSpeed());
				}
				break;
			case Constants.DOWN:
				if ((o.hitbox.xpoints[0] == 0) ||  (o.hitbox.xpoints[0] == 450)) {
					o.setYSpeed(0);
				}
				else {
					o.setYSpeed(o.getMaxYSpeed());
				}
				break;
			case Constants.SPACE:
				o.dive();
			}
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
	
	