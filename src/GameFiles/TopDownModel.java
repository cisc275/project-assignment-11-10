package GameFiles;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
/**
 * Model clapperrail game
 *
 */
public class TopDownModel extends Model {
	public ClapperRail cr;
    public Fox f;
    public Nest nest;

    int count = 0; // used to check clock
    /**
     * takes a hashset of integers and moves clapper rail accordingly
     * @param HashSet<Integer> keyPresses
     * @author andrew thompson
     */
    @Override
    public void handleMove(HashSet<Integer> keyPresses) {
    	cr.setxSpeed(0);
    	cr.setySpeed(0);
    	
    	for(Integer key: keyPresses) {
	    	switch(key) {
	    	case Constants.RIGHT:
				cr.setxSpeed(cr.getMOVE_AMOUNT());
				break;
	    	case Constants.LEFT:
				cr.setxSpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case Constants.UP:
				cr.setySpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case Constants.DOWN:
	    		cr.setySpeed(cr.getMOVE_AMOUNT());
				break;
			}
    	}
    }
    /**
     * initializes new TopDownModel and creates an ArrayList of GameObject
     * @author Tim Mazzarelli
     */
    public TopDownModel() {
    	cr = new ClapperRail(Constants.CLAPPER_RAIL_START_LOC_X, Constants.CLAPPER_RAIL_START_LOC_Y,
    			Constants.CLAPPER_RAIL_START_SIZE_X, Constants.CLAPPER_RAIL_START_SIZE_Y);
    	f = new Fox(Constants.FOX_START_LOC_X, Constants.FOX_START_LOC_Y, Constants.FOX_START_SIZE_X, Constants.FOX_START_SIZE_Y, cr);
    	nest = new Nest(25, 25, 50, 50);
		game = new ArrayList<GameObject>();
		game.add(cr);
		game.add(f);
		game.add(nest);	
    }
    
    
    /**
     * 
     * @param array list of GameObjects
     * updates the location of all moving objects and then calls the collision method
     * @author Tim Mazzarelli
     */
    public void updateLocation(ArrayList<GameObject> g) {
    	for (GameObject a : g) {
			a.move();
			a.collision(g);			
		}
    	if (Stick.count == Constants.TDM_UPDATELOCATION_STICK_COUNT) {
    		System.out.println("game over");
    		Model.gameOver = true;
    	}
    }
    /**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
		new Controller("topDown");
		
	}

	
	
}