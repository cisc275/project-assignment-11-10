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
		
		if (selected.equals(Constants.SELECTION_STRING)){
			// selection screen
			view = new SelectionView(new ArrayList<GameObject>());
			view.addActionListener(this);	
		}

		if(selected.equals(Constants.TOP_DOWN_STRING)) {
			// clapper rail game
			
			model = new TopDownModel();
			view = new TopDownView(model.game);
			model.defaultSetup();
			
			view.addKeyListener(this);
			this.start();
		}
		else if (selected.equals(Constants.TOP_DOWN_NT_STRING)) {
			// skip tutorial if replaying after loss
			model = new TopDownModel();	
			view = new TopDownView(model.game);
			
			Model.inTutoral = false;
			model.defaultSetup();
			model.postTutorial();
			
			view.addKeyListener(this);
			view.addActionListener(this);
			this.start();
		}
		
		// sideScroll game
		else if(selected.equals(Constants.SIDE_SCROLL_STRING)) {
			model = new SideScrollModel();	
			view = new SideScrollView(model.game);
			model.defaultSetup();
			
			view.addKeyListener(this);
			view.addActionListener(this);
			this.start();
		}
		// sidescroll game without tutorial
		else if(selected.equals(Constants.SIDE_SCROLL_NT_STRING)) {
			model = new SideScrollModel();	
			view = new SideScrollView(model.game);
			
			Model.inTutoral = false;
			model.defaultSetup();
			model.postTutorial();
			
			view.addKeyListener(this);
			view.addActionListener(this);
			this.start();
		}
		
		
	}
		
	/**
	 * starts timers and actions for sideScroll
	 * @author andrew thompson
	 */
	public void start() {

		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			model.handlePwr();
    			model.updateLocation(model.game);
    			view.updateView(model.game);
    			if (Mate.caughtUp) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				new Quiz(Constants.SIDE_SCROLL_STRING);
    				time.stop();
    			}
    			else if(Stick.count == Constants.STICK_END_COUNT) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				View.frame.dispose();
    				new EndScreen(Constants.TOP_DOWN_STRING);
    				time.stop();
    			}
    			else if(ClapperRail.lives == Constants.CLAPPER_RAIL_LIVES_END_STATE) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				View.frame.dispose();
    				new LoseScreen(Constants.TOP_DOWN_STRING);
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
	/**
	 * required method to implement, does nothing in our case
	 */
	@Override
	public void keyTyped(KeyEvent e) {}

	// sets speed according to game input
	
	/**
	 * adds keypress to set of currently pressed keys, gives set to model to handle
	 * @author andrew thompson
	 */
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		keyPresses.add(e.getKeyCode());
		model.handleMove(keyPresses);
		switch (e.getKeyCode()) {
			case Constants.TILDA_KEY_CODE:
				try {
					Serialize.dumpGame(model);
				
					TutorialObject nc = new TutorialObject(1200, 50, 352, 18, Constants.ANIMATION_MODEL_DUMP_STATUS_MSG);
					model.game.add(nc);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case Constants.ONE_KEY_CODE:
					view.debugHitBoxes =  !view.debugHitBoxes;
					break;
			case Constants.ESCAPE_KEY_CODE:
				try {
					Serialize.dumpGame(model);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				model = new Model();
				model.setGame(new ArrayList<>());
				view = new View();
				new Controller(Constants.SELECTION_STRING);
				break;
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

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the view
	 */
	public View getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * @return the time
	 */
	public Timer getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Timer time) {
		this.time = time;
	}

	/**
	 * @return the drawAction
	 */
	public Action getDrawAction() {
		return drawAction;
	}

	/**
	 * @param drawAction the drawAction to set
	 */
	public void setDrawAction(Action drawAction) {
		this.drawAction = drawAction;
	}

	/**
	 * @return the selected
	 */
	public String getSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(String selected) {
		this.selected = selected;
	}

	/**
	 * @return the keyPresses
	 */
	public HashSet<Integer> getKeyPresses() {
		return keyPresses;
	}

	/**
	 * @param keyPresses the keyPresses to set
	 */
	public void setKeyPresses(HashSet<Integer> keyPresses) {
		this.keyPresses = keyPresses;
	}

	
	
}
