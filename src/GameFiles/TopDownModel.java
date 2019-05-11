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
    
    final int LEFT_BOUND = 0;
    final int BOUND_OFFSET = 134;
    final int RIGHT_BOUND = 800;
    final int CLOCK_TICK_CHECK = 100;
    
    @Override
    public void handleMove(HashSet<Integer> keyPresses) {
    	cr.setxSpeed(0);
    	cr.setySpeed(0);
    	
    	for(Integer key: keyPresses) {
	    	switch(key) {
	    	case 39: //right arrow key
				cr.setxSpeed(cr.getMOVE_AMOUNT());
				break;
	    	case 37: //left arrow key
				cr.setxSpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case 38: //up arrow key
				cr.setySpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case 40: //down arrow key
				cr.setySpeed(cr.getMOVE_AMOUNT());
				break;
			}
    	}
    }
    
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
     */
    public void updateLocation(ArrayList<GameObject> g) {
    	for (GameObject a : g) {
			a.move();
			a.collision(g);			
		}
    	
    	if (Stick.count == Constants.TDM_UPDATELOCATION_STICK_COUNT) {
    		Model.gameOver = true;
    	}
    }
    
 
    /**
     * 
     * @param an array list of GameObjects
     * 
     * checks all Game objects against all others in the game, calls polymorphic collision expressions 
     * when there is an intersection (not implemented yet)
     */
    
    
  
    /**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
		new Controller("topDown");
		
	}

	
	
}