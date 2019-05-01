package GameFiles;
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

    ClapperRail cr = new ClapperRail("cr.png",100,100);
    Fox f = new Fox("fox.png",400,400);

    int count = 0;
    
    final int LEFT_BOUND = 0;
    final int BOUND_OFFSET = 134;
    final int RIGHT_BOUND = 800;
    final int VELOCITY_MULTIPLYER = 12;
    final int CLOCK_TICK_CHECK = 100;
    
    
    public int foxxDirection() {
    	Random rand = new Random();
    	return rand.nextInt(5);
    }
    
    public int foxyDirection() {
    	Random rand = new Random();
    	return rand.nextInt(5);
    }


    
    public TopDownModel() {
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
    	// needs update with polygon (contains method)
    	/*
    	if(xloc+xChg > (imgWidth - frameWidth) || xloc+xChg < 0) {
    		System.out.println("WHY");
        	xChg = 0;
        	
        }
        if(yloc+yChg > (imgHeight - frameHeight) || yloc+yChg < 0) {
        	yChg = 0;
        }
        */
        cr.setX(cr.getX()+cr.getxSpeed());
        cr.setY(cr.getY()+cr.getySpeed());
        cr.getHitBox().translate(cr.getxSpeed(), cr.getySpeed());
        
        if((f.getX() + BOUND_OFFSET) <= LEFT_BOUND) {
			f.setX(RIGHT_BOUND);
		}
		if((f.getY() + BOUND_OFFSET) <= LEFT_BOUND) {
			f.setY(RIGHT_BOUND);
		}
		if((f.getX() + BOUND_OFFSET) >= RIGHT_BOUND) {
			f.setX(LEFT_BOUND);
		}
		if((f.getY() + BOUND_OFFSET) >= RIGHT_BOUND) {
			f.setY(LEFT_BOUND);
		}
		
		if (count >= CLOCK_TICK_CHECK) {
        f.setX(f.getX()-foxxDirection());
        f.setY(f.getY()-foxyDirection());
        f.getHitBox().translate(-foxxDirection(), -foxyDirection());
        count++;
		}
		if (count >= 3*CLOCK_TICK_CHECK) {
	        f.setX(f.getX()+foxxDirection());
	        f.setY(f.getY()+foxyDirection());
	        count = 0;
	        f.getHitBox().translate(foxxDirection(), foxyDirection());
			}
		else if (count < CLOCK_TICK_CHECK) {f.setX(f.getX()+foxxDirection());
        	f.setY(f.getY()+foxyDirection());
        	count++;
        	f.getHitBox().translate(foxxDirection(), foxyDirection());
		}

        this.collision(g);
    }
    
    
    /**
     * 
     * @param an array list of GameObjects
     * 
     * checks all Game objects against all others in the game, calls polymorphic collision expressions 
     * when there is an intersection (not implemented yet)
     */
    public void collision(ArrayList<GameObject> gme) {
    	for (int k = 0; k < gme.size(); k ++) {
    		//if (count % 1 == 0 && (gme.get(k).getType() == Type.FOX)) System.out.println(gme.get(k) + " vs Polygon " + gme.get(k).getHitBox().getBounds2D());
    		for (int j = k + 1; j < gme.size(); j ++) {
    			if (k != j) { //Entering the dodgy bit.
    				if (gme.get(k).getHitBox().intersects(gme.get(j).getHitBox().getBounds2D())) {
    					System.out.println("Collision found between " + k + " and " + j);
    				}
    			} //Exiting the dogey bit
    		}
    		
    	}
    }	
    
  
	/**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
		Controller theControl = new Controller("topDown");
		theControl.topDownStart();
	}
	
	
	
	
	/**
	 * 
	 * @return a buffered Image
	 * creates buffered images for the various objects
	 * each version returns a different color square
	 */
	public BufferedImage createImage(){
		//System.out.println("Start of createImage");
    	BufferedImage bufferedImage;
    	//System.out.println("Im about to try");
    	try {
    		//System.out.println("im trying");
    		bufferedImage = ImageIO.read(new File("red_square.png"));
    		
    		//System.out.println("I succeded");
    		return bufferedImage;
    	} catch (IOException e) {
    		//System.out.println("im being caught");
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public BufferedImage createImage2(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("blue_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	public BufferedImage createImage3(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("green_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	public BufferedImage createImage4(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("brown_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	

}
