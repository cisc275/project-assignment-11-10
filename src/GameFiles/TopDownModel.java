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
	/**
	 * clapper rail used by TDM
	 */
	public ClapperRail cr;
	
	/**
	 * fox used by TDM
	 */
    public Fox f;
    
    /**
     * nest used by TDM
     */
    public Nest nest;

    /**
     * clock checker
     */
    int count = 0; 
    
    Powerup tpow = null;
    
    Stick tstick = null;
    
    TutorialObject tdown_key = null;
    
    TutorialObject tup_key = null;
    
    TutorialObject tleft_key = null;
    
    TutorialObject tright_key = null;
    
    TutorialArrow tarrow = null;
    
    Bush b1 = null;
    
    Bush b2 = null;
    
    Bush b3 = null;
    
    int tarrow_cur_height;
    
    int tarrow_cur_width;
    
    
    
    /*
     * checks time for active powerup
     */
   // int pwrCount = 0;
  
    
    /**
     * takes a hashset of integers and moves clapper rail accordingly
     * @param HashSet<Integer> keyPresses
     * @author andrew thompson
     */
    @Override
    public void handleMove(HashSet<Integer> keyPresses) {
    	cr.setxSpeed(0);
    	cr.setySpeed(0);
    //	System.out.println(cr.xSpeed);
    //	System.out.println(keyPresses);
    	if(Quiz.answered == true) {
    		keyPresses.clear();
    		cr.setxSpeed(0);
        	cr.setySpeed(0);
        	Quiz.answered = false;
    	}
    	for(Integer key: keyPresses) {
	    	switch(key) {
	    	
	    	case Constants.RIGHT_KEY_CODE:
	    		//System.out.println("right pressed");
				cr.setxSpeed(cr.getMOVE_AMOUNT());
				break;
	    	case Constants.LEFT_KEY_CODE:
	    	//	System.out.println("left pressed");
				cr.setxSpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case Constants.UP_KEY_CODE:
				cr.setySpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case Constants.DOWN_KEY_CODE:
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
    	nest = new Nest(25, 25, 50, 50);
		game = new ArrayList<GameObject>();
		inTutoral = true;
    }
    
    
    // No fox in by default
    @Override
    protected void defaultSetup() {
    	game.add(cr);
		game.add(nest);
		
		b1 = new Bush(500, 500,150,150);
		game.add(b1);
		cr.bushArr.add(b1);
		
		b2 = new Bush(600, 20,150,150);
		game.add(b2);
		cr.bushArr.add(b2);
		
		b3 = new Bush(20, 450,150,150);
		game.add(b3);
		cr.bushArr.add(b3);
    }
    
    @Override
    protected void postTutorial() {
    	f = new Fox(Constants.FOX_START_LOC_X, Constants.FOX_START_LOC_Y, Constants.FOX_START_SIZE_X, Constants.FOX_START_SIZE_Y, cr);
    	game.add(f);
    	game.add(new Powerup(Constants.FRAME_X, Constants.FRAME_Y - (int)(Constants.POWERUP_HEIGH * Constants.POWERUP_HEIGH_SCALE),
				(int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE), (int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE)));
		game.add(new Stick(300,300,(int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
		game.add(new Stick(500, 250, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE))); 
		game.add(new Stick(400, 400, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
		game.add(new Stick(400, 400, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
    }
    
    /**
     * 
     * @param array list of GameObjects
     * updates the location of all moving objects and then calls the collision method
     * @author Tim Mazzarelli
     */
    public void updateLocation(ArrayList<GameObject> g) {
    	if (inTutoral) {
    		// This is nessasary for the game to work
    		for (GameObject a : g) {
				if (!a.equals(f) && !a.equals(tpow)) {
					a.move();
					a.collision(g);
				}
			}
    		
    		if (tup_key == null) {
    			tup_key = new TutorialObject(1000, 300, Constants.TO_DEFAULT_SIZE, Constants.TO_DEFAULT_SIZE, Constants.ANIMATION_UP_KEY);
    			game.add(tup_key);
    		}
    		
    		if (tdown_key == null && tup_key != null) {
    			tdown_key = new TutorialObject(tup_key.x, tup_key.y + 100, Constants.TO_DEFAULT_SIZE, Constants.TO_DEFAULT_SIZE, Constants.ANIMATION_DOWN_KEY);
    			game.add(tdown_key);
    		}
    		
    		if (tleft_key == null && tup_key != null) {
    			tleft_key = new TutorialObject(tup_key.x - 100, tup_key.y + 100, Constants.TO_DEFAULT_SIZE, Constants.TO_DEFAULT_SIZE, Constants.ANIMATION_LEFT_KEY);
    			game.add(tleft_key);
    		}
    		
    		if (tright_key == null && tup_key != null) {
    			tright_key = new TutorialObject(tup_key.x + 100, tup_key.y + 100, Constants.TO_DEFAULT_SIZE, Constants.TO_DEFAULT_SIZE, Constants.ANIMATION_RIGHT_KEY);
    			game.add(tright_key);
    		}
    		
    		if (tstick == null) {
    			tstick = new Stick(400, 400, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE));
    			tstick.imgFileName = Constants.ANIMATION_TO_STICK;
    			game.add(tstick);
    		}
    		
    		if (tpow == null) {
    			tpow = new Powerup(Constants.FRAME_X, Constants.FRAME_Y - (int)(Constants.POWERUP_HEIGH * Constants.POWERUP_HEIGH_SCALE),
    					(int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE), (int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE));
    			tpow.imgFileName = Constants.ANIMATION_CRAB;
    			game.add(tpow);
    		}
    		
    		if (f == null) {
    			f = new Fox(Constants.FRAME_X, Constants.FRAME_Y / 2, Constants.FOX_START_SIZE_X, Constants.FOX_START_SIZE_Y, cr);
    			game.add(f);
    		}
    		
    		if (tarrow == null) {
    			tarrow_cur_height = (int)(tstick.hitbox.getBounds2D().getMaxY() - nest.hitbox.getBounds2D().getMaxY() - 50);
    			tarrow_cur_width = (int)(tstick.hitbox.getBounds2D().getMaxX() - nest.hitbox.getBounds2D().getMaxX() - 50);
    			tarrow = new TutorialArrow((int)nest.hitbox.getBounds2D().getMaxX(), (int)nest.hitbox.getBounds2D().getMaxY(), 
    					tarrow_cur_width, 
    					tarrow_cur_height,
    					Constants.ANIMATION_ARROW_STATIC);
    			tarrow.curImgTickCount = 0;
				game.add(tarrow);
    		}

    		//---------------------------------------------
    		//	This is the code for the arrow to move well
    		//---------------------------------------------
    		if (tstick.visible) {
    			int tarrow_new_height = (int)(tstick.hitbox.getBounds2D().getMaxY() - nest.hitbox.getBounds2D().getMaxY() - 50);
    			int tarrow_new_width = (int)(tstick.hitbox.getBounds2D().getMaxX() - nest.hitbox.getBounds2D().getMaxX() - 50);
    			if (tarrow_new_width > 10 && tarrow_new_height > 10) {
	    			tarrow.height = (int)(tstick.hitbox.getBounds2D().getMaxY() - nest.hitbox.getBounds2D().getMaxY() - 50);
	    			tarrow.width = (int)(tstick.hitbox.getBounds2D().getMaxX() - nest.hitbox.getBounds2D().getMaxX() - 50);
	    			tarrow.resetPoly();
	    			if (tarrow_new_height != tarrow_cur_height || tarrow_new_width != tarrow_cur_width) {
	        			tarrow.curImg ++;
	    			}
	    			tarrow_cur_height = tarrow_new_height;
	    			tarrow_cur_width = tarrow_new_width;
    			}
    			else {
    				tarrow.visible = false;
    				game.remove(tarrow);
    			}
    		}
    		else if (f.visible) {
    			if (b1.imgFileName.equals(Constants.ANIMATION_BUSH)) {
    				tup_key.visible = tdown_key.visible = tright_key.visible = tleft_key.visible = false;
    				game.remove(tup_key);
    				game.remove(tdown_key);
    				game.remove(tright_key);
    				game.remove(tleft_key);
    				b1.imgFileName = Constants.ANIMATION_BUSH_GLOW;
    			}
    			else if (!cr.hitbox.getBounds2D().intersects(b1.hitbox.getBounds2D()) && f.hitbox.getBounds2D().getMinY() > 0) {
    				f.move();
    				f.collision(game);
    			}
    			else if (cr.hitbox.getBounds2D().intersects(b1.hitbox.getBounds2D())) {
    				f.move();
    				//System.out.println("in bush");
    			}
    			else {
    				f.visible = false;
    				game.remove(f);
    			}
    		}
    		else if (tpow.visible){
				if (b1.imgFileName.equals(Constants.ANIMATION_BUSH_GLOW)) {
					b1.imgFileName = Constants.ANIMATION_BUSH;
				}
				else if (tpow.hitbox.getBounds2D().getCenterX() > b1.hitbox.getBounds2D().getCenterX()) {
					tpow.move();
				}
				if (Powerup.power) {
					Powerup.power = false;
					tpow.visible = false;
					game.remove(tpow);
				}
    		}
    		else {
    			//System.out.println("Hit");
	    		this.postTutorial();
	    		Model.inTutoral = false;
    		}
    	} else {
    		ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
        	for (GameObject a : g) {
    			a.move();
    			a.collision(g);			
    			if (a.removeObject()) toRemove.add(a);
    		}
        	g.removeAll(toRemove);
        	if (Stick.count == Constants.TDM_UPDATELOCATION_STICK_COUNT) {
        		Model.gameOver = true;
        	}
    	}
    }
    
    
    /**
     * handles power up effect
     * @author Peter Jenny
     */
    public void handlePwr() {
    	if(Quiz.correct) {
    		cr.lives += 1;
    		Quiz.correct = false;
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