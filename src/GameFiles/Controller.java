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



public class Controller implements KeyListener, ActionListener{
	private Model model;
	private View view;
	private Timer time;

	private Action drawAction;
	String selected;
	ArrayList<GameObject> game;
	HashSet<Integer> keyPresses = new HashSet<>();
	
	
	public Controller(String selection) {
		
		selected = selection;
		
		if (selected.equals("sel")){
			view = new SelectionView();
			view.addActionListener(this);	
		}

		
		if(selected.equals("topDown")) {
			// clapper rail game
		
			game = new ArrayList<GameObject>();
			view = new TopDownView(game);
			System.out.println(view.getWidth());
			System.out.println(view.getHeight());
			model = new TopDownModel();
			game.add(((TopDownModel)model).cr);
//			game.add(((TopDownModel)model).f);
			game.add(((TopDownModel)model).nest);
			
			game.add(new Fish(3000, (int) (view.getHeight() * 0.91), 50, 50));
			game.add(new Stick(300,300,40,80));
			game.add(new Stick(500, 250 ,40,40));
			game.add(new Stick(400, 400 ,80,40));
			Bush b1 = new Bush(500, 500,150,150);
			game.add(b1);
			((TopDownModel)model).cr.bushArr.add(b1);
			Bush b2 = new Bush(600, 20,150,150);
			game.add(b2);
			((TopDownModel)model).cr.bushArr.add(b2);
			Bush b3 = new Bush(20, 450,175,175);
			game.add(b3);
			((TopDownModel)model).cr.bushArr.add(b3);
			
			
			view.addKeyListener(this);
			this.start();

		}
		// sideScroll game
		else if(selected.equals("sideScroll")) {
			game = new ArrayList<GameObject>();
			
			view = new SideScrollView(game);
			System.out.println(view.getWidth());
			System.out.println(view.getHeight());
			
			Background backOne = new Background(0, 0, view.getWidth(), view.getHeight());
			Background backTwo = new Background(view.getWidth(), 0, 
					view.getWidth(), view.getHeight());
			System.out.println(backOne.getX());
			System.out.println(backTwo.getX());
			
			Trash t = new Trash(view.getWidth() + 200, view.getHeight() - (view.getHeight() / 3), 
					view.getWidth() / 20, view.getHeight()/ 15);
			Trash t2 = new Trash(view.getWidth() + 20, view.getHeight() - (view.getHeight() / 9), 
					view.getWidth() / 20, view.getHeight()/ 15);
			Fish f = new Fish(view.getWidth() + 400, (int) (view.getHeight() * 0.87), 
					(int) (view.getWidth() * 0.05), (int) (view.getHeight() * 0.05));
			Fish f2 = new Fish(view.getWidth() + 250, 600, 50, 50);
			Fish f3 = new Fish(view.getWidth() + 100, 650, 50, 50);
			AirCurrent a = new AirCurrent(view.getWidth() + 20, 55, 250, 250);
			AirCurrent a2 = new AirCurrent(view.getWidth()  + 100, 100, 200, 200);
			AirCurrent a3 = new AirCurrent(view.getWidth()  + 500, 200, 200, 200);
			Mate m = new Mate(view.getWidth() + 400, 200, 200, 50); // suposed to be 50 50, this is for the memes
			model = new SideScrollModel();	
			game.add(backOne);
			game.add(backTwo);
			game.add(((SideScrollModel)model).o);
			game.add(f);
			game.add(f2);
			game.add(f3);
			game.add(t);
			game.add(t2);
			game.add(a);
			game.add(a2);
			game.add(a3);
			game.add(m);
		
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
    			model.updateLocation(game);
    			view.updateView(game);
    			if (Model.gameOver) {
    				view.dispose();
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
