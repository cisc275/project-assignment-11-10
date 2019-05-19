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
	
	
	/**
	 * The tutorial fish
	 */
	private Fish tfish = null;
	
	/**
	 * The tutorial aircurrent
	 */
	private AirCurrent tair = null;
	
	/**
	 * The tutorial spacebar
	 */
	private TutorialObject tspace = null;
	
	
	public SideScrollModel() {
		o = new Osprey(Constants.OSPREY_STARTX, 150, 50, 50);
		game = new ArrayList<GameObject>();
		game.add(o);
		inTutoral = true;
	}
	
	 /**
     * takes an ArrayList of GameObjects and moves them while checking for collision
     * @param g
     * @author Tim Mazzarelli
     */
	public void updateLocation(ArrayList<GameObject> g) {
		if (inTutoral) {
			// Movement of the background and bird, this MUST be here.
			for (GameObject a : g) {
				if (!a.equals(tfish) && !a.equals(tair)) {
					a.move();
					a.collision(g);
				}
			}
			
			// Does the fish exist yet????
			if (tfish == null) {
				tfish = new Fish(1920, (int) (700), (int) (1920 * 0.05), (int) (1080 * 0.05));
				game.add(tfish);
			}
			
			// Does the aircurrent exist yet?????
			if (tair == null) {
				tair = new AirCurrent(1920  + 500, 150, 200, 200);
				game.add(tair);
			}
			
			//---------------------------------------
			//	If we are still working with the 
			//		fish, this will run.  Once we
			//		are done with it, its visibility
			//		goes false, and we skip this.
			//---------------------------------------
			if (tfish.visible) {
				if (tfish.hitbox.getBounds2D().getMinX() > Constants.OSPREY_STARTX) {
					tfish.move();
					//System.out.println(tfish + " " + o);
				}
				else if (tspace == null) {
					tspace = new TutorialObject(300, 300, 483, 110, Constants.ANIMATION_SPACEBAR);
					game.add(tspace);
				}
				else if (tfish.hitbox.intersects(o.hitbox.getBounds2D())){
					tfish.visible = false;
					tspace.visible = false;
				}
				
			} else if (tair.visible) {
				if (tair.hitbox.getBounds2D().getMinX() > 500) {
					tair.move();
					System.out.println(tair);
				}
			}
			
			
			
		}	
		else {
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
	}
	
	@Override
	protected void defaultSetup() { 
		game.add(new Background(0, 0, 1920, 1080));
		game.add(o);
		game.add(new InvisibleWall(0, Constants.OSPREY_WATER_LEVEL, 1920, 50));
		
	}
	
	protected void postTutorial() {
		game.add(new Fish(1920 + 400, (int) (1080 * 0.87), (int) (1920 * 0.05), (int) (1080 * 0.05)));
		game.add(new Fish(1920 + 250, 600, 50, 50));
		game.add(new Fish(1920 + 100, 650, 50, 50));
		game.add(new Trash(1920 + 20, 1080 - (1080 / 9), 1920 / 20, 1080/ 15));
		game.add(new Trash(1920 + 200, 1080 - (1080 / 3), 1920 / 20, 1080/ 15));
		game.add(new AirCurrent(1920 + 20, 55, 250, 250));
		game.add(new AirCurrent(1920  + 100, 100, 200, 200));
		game.add(new AirCurrent(1920  + 500, 200, 200, 200));
		game.add(new Powerup(1920, 800, 50, 50));
		game.add(new Mate(1920, 200, 200, 50));// suposed to be 50 50, this is for the memes
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
	
	