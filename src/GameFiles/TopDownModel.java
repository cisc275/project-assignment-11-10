package GameFiles;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    int count = 0; // used to check clock
    
    final int LEFT_BOUND = 0;
    final int BOUND_OFFSET = 134;
    final int RIGHT_BOUND = 800;
    final int CLOCK_TICK_CHECK = 100;
    
   
    
    public TopDownModel() {
    	cr = new ClapperRail(400,200,100,100,new Polygon(),super.createImage(), 0, 0);
    	f = new Fox(200,200,100,100,new Polygon(), super.createImage2(), 3, 3, cr);
		game = new ArrayList<GameObject>();
		game.add(cr);
		game.add(f);
		
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
		Controller theControl = new Controller("topDown");
		theControl.topDownStart();
	}

	
	
}