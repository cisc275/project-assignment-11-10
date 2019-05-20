package GameFiles;
import java.awt.EventQueue;

import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

/**
 * main controller for the game, starts and maintains all of our models and views
 * @author tmazz
 *
 */

public class Controller implements KeyListener, ActionListener{
	/**
	 *  for whichever model you are in
	 */
	private Model model;
	
	/**
	 * for whichever view you are in
	 */
	private View view;
	
	/**
	 * timer for the game
	 */
	private Timer time;
	
	/**
	 * action defined later for running game
	 */
	
	private Action drawAction;
	
	/**
	 * to determine whichever game you're in
	 */
	String selected;
	
	/**
	 * hashset of the keys that are being pressed, for key handling
	 */
	HashSet<Integer> keyPresses = new HashSet<>();
	
	/**
	 * Picks what to draw and control depending on the string you pass in
	 * @param selection
	 */
	public Controller(String selection) {
		
		selected = selection;
		
		if (selected.equals("sel")){
			view = new SelectionView(new ArrayList<GameObject>());
			view.addActionListener(this);	
		}

		if(selected.equals("topDown")) {
			// clapper rail game
			
			model = new TopDownModel();
			model.game = new ArrayList<GameObject>(); 
//			model = new TopDownModel();
			view = new TopDownView(model.game);
			model.game.add(((TopDownModel)model).cr);
			model.game.add(((TopDownModel)model).f);
			model.game.add(((TopDownModel)model).nest);
			
			model.game.add(new Powerup(Constants.FRAME_X, Constants.FRAME_Y - (int)(Constants.POWERUP_HEIGH * Constants.POWERUP_HEIGH_SCALE),
					(int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE), (int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE)));
			model.game.add(new Stick(300,300,(int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
			model.game.add(new Stick(500, 250, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE))); 
			model.game.add(new Stick(400, 400, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
			model.game.add(new TutorialObject(300, 150, 483, 110, Constants.ANIMATION_SPACEBAR));
			model.game.add(new TutorialObject(700, 300, 122, 122, Constants.ANIMATION_UP_KEY));
			Bush b1 = new Bush(500, 500,150,150);
			model.game.add(b1);
			((TopDownModel)model).cr.bushArr.add(b1);
			Bush b2 = new Bush(600, 20,150,150);
			model.game.add(b2);
			((TopDownModel)model).cr.bushArr.add(b2);
			Bush b3 = new Bush(20, 450,175,175);
			model.game.add(b3);
			((TopDownModel)model).cr.bushArr.add(b3);
			
			view.addKeyListener(this);
			this.start();
		}
		// sideScroll game
		else if(selected.equals("sideScroll")) {
			model = new SideScrollModel();	
			view = new SideScrollView(model.game);
			model.defaultSetup();
			
			view.addKeyListener(this);
			view.addActionListener(this);
			this.start();
		}
		// sidescroll game without tutorial
		else if(selected.equals("sideScrollNT")) {
			model = new SideScrollModel();	
			view = new SideScrollView(model.game);
			
			model.inTutoral = false;
			model.defaultSetup();
			model.postTutorial();
			
			view.addKeyListener(this);
			view.addActionListener(this);
			this.start();
		}
		
		
	}
		
	/**
	 * starts timers and actions for sideScroll
	 */
	public void start() {

		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			model.updateLocation(model.game);
    			view.updateView(model.game);
    			if (Mate.caughtUp) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				new Quiz("sides");
    				time.stop();
    			}
    			else if(Stick.count == Constants.STICK_END_COUNT) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				View.frame.dispose();
    				new EndScreen();
    				time.stop();
    			}
    			else if(ClapperRail.lives == Constants.CLAPPER_RAIL_LIVES_END_STATE) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				View.frame.dispose();
    				new LoseScreen("cr");
    				time.stop();
    			}
    		}
    	};
    	time = new Timer(Constants.TIMER_TICK_RATE, drawAction);
    	time.start();
	}

	/**
	 * decides which button to follow
	 * @param e
	 * @author Tim Mazzarelli
	 */
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SelectionView.clapperRail) {
			view.dispose();
			new Controller("topDown");
		}
		else if (e.getSource() == SelectionView.osprey){
			view.dispose();
        	new Controller("sideScroll");
        }
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	// sets speed according to game input
	
	/**
	 * adds keypress to set of currently pressed keys, gives set to model to handle
	 * @author andrew thompson
	 */
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		keyPresses.add(e.getKeyCode());
		model.handleMove(keyPresses);
		//System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
			case 192:
				try {
					Serialize.dumpGame(model);
				
					TutorialObject nc = new TutorialObject(1200, 50, 352, 18, Constants.ANIMATION_MODEL_DUMP_STATUS_MSG);
					model.game.add(nc);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 49:
					view.debugHitBoxes =  !view.debugHitBoxes;
			case Constants.ESCAPE_KEY_CODE:
				new Controller("sel");
		}
	}	
	/**
	 * removes keypress to set of currently pressed keys, gives set to model to handle
	 * @author andrew thompson
	 */
	@Override
	public synchronized void keyReleased(KeyEvent e) {
		keyPresses.remove(e.getKeyCode());
		model.handleMove(keyPresses);
		
		
	}

	
	
}
