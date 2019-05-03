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
	Osprey o;
	boolean cr = false;
	boolean os = false;
	
	public Controller(String selection) {
		
		selected = selection;
		
		if (selected.equals("sel")){
			view = new SelectionView();
			view.addActionListener(this);
		}

		
		if(selected.equals("topDown")) {
			game = new ArrayList<GameObject>();
			model = new TopDownModel();
			//c = ((TopDownModel)model).cr;
			game.add(((TopDownModel)model).cr);
			game.add(((TopDownModel)model).f);
			game.add(new Stick(200,200,100,300,new Polygon(),model.createImage2(),5));
			game.add(new Bush(500, 550,100,300,new Polygon(),model.createImage2()));
			game.add(new Bush(0, -60,100,300,new Polygon(),model.createImage2()));
			view = new TopDownView(game);
			view.addKeyListener(this);
			this.topDownStart();

		}
		else if(selected.equals("sideScroll")) {
			Background backOne = new Background();
			Background backTwo = new Background(backOne.getImageWidth(), 0);
			o = new Osprey(100, 100, 50, 50, new Polygon(), null, -5, 0, false);
			Trash t = new Trash(850, 650, 50, 50, new Polygon(), null,  -4);
			Fish f = new Fish(800, 650, 50, 50, new Polygon(), null, -10);
			AirCurrent a = new AirCurrent(900, 150, 50, 50, new Polygon(), null, -3);
			Mate m = new Mate(1000, 200, 50, 50, new Polygon(), null, -1, false);
			game = new ArrayList<GameObject>();
			game.add(o);
			game.add(f);
			game.add(t);
			game.add(a);
			game.add(m);
			
			model = new SideScrollModel();
			
			view = new SideScrollView(game, backOne, backTwo);
			view.addKeyListener(this);
			
		}
	}
	
	/**
	 * starts timers and actions for topDown
	 */
	public void topDownStart() {
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			model.updateLocation(game);
    			view.updateView(game);
    		}
    	};
    	
    	time = new Timer(50, drawAction);
    	time.start();
	}
	
		
	/**
	 * starts timers and actions for sideScroll
	 */
	public void sideScrollStart() {
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			model.advanceWorld(game);
    			view.updateView(game);
    		}
    	};
    	
    	time = new Timer(50, drawAction);
    	time.start();
	}

	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SelectionView.clapperRail) {
			Controller c = new Controller("topDown");
		}
		else {
        	Controller c = new Controller("sideScroll");
			c.sideScrollStart();
			
        }
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 39) { //right arrow key
			if(selected.equals("topDown")) {
				((TopDownModel)model).cr.setxSpeed(((TopDownModel)model).cr.getMOVE_AMOUNT());
			}
		}
		else if(e.getKeyCode() == 37) { //left arrow key
			if(selected.equals("topDown")) {
				((TopDownModel)model).cr.setxSpeed(-((TopDownModel)model).cr.getMOVE_AMOUNT());
			}
		}
		else if(e.getKeyCode() == 38) { //up arrow key
			if(selected.equals("topDown")) {
				((TopDownModel)model).cr.setySpeed(-((TopDownModel)model).cr.getMOVE_AMOUNT());
			}
			else if(selected.equals("sideScroll")) {
				if ((o.hitbox.xpoints[0] == 0) ||  (o.hitbox.xpoints[0] == 450))
				 o.setYSpeed(0);
				else {
				o.setYSpeed(-5);
			}
		}
		}
		else if(e.getKeyCode() == 40) { //down arrow key
			if(selected.equals("topDown")) {
				((TopDownModel)model).cr.setySpeed(((TopDownModel)model).cr.getMOVE_AMOUNT());
			}
			else if(selected.equals("sideScroll"))  {
				if ((o.hitbox.xpoints[0] == 0) ||  (o.hitbox.xpoints[0] == 450))
					 o.setYSpeed(0);
					else {
					o.setYSpeed(5);
				}
			}
		}
		
		else if (e.getKeyCode() == 32) {
			if (selected.equals("sideScroll")){
				o.dive();
			}

		
	}
	}	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(selected.equals("topDown")) {
			((TopDownModel)model).cr.setxSpeed(0);
			((TopDownModel)model).cr.setySpeed(0);
		}
	}

	
	
}
