package GameFiles;
import java.awt.EventQueue;
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
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;


public class Controller implements KeyListener{
	
	private TopDownModel topDownModel;
	private TopDownView topDownView;
	private SideScrollModel sideScrollModel;
	private SideScrollView sideScrollView;
	private Timer time;
	private Action drawAction;
	boolean collision;
	String selected;
	ArrayList<GameObject> game;

	
	public Controller(String selection) {
		selected = selection;
		if(selected.equals("topDown")) {
			game = new ArrayList<GameObject>();
			topDownModel = new TopDownModel(10,10,10,10);
			game.add(new GameObject(topDownModel.createImage(),100,100));
			game.add(new GameObject(topDownModel.createImage2(),400,400));
			game.add(new GameObject(topDownModel.createImage3(),200,200));
			game.add(new GameObject(topDownModel.createImage4(), 500, 550));
			game.add(new GameObject(topDownModel.createImage4(), 0, -60));
			topDownView = new TopDownView(game);
			topDownView.addKeyListener(this);

    }
		else if(selected.equals("sideScroll")) {
			game = new ArrayList<GameObject>();
			sideScrollModel = new SideScrollModel();
			game.add(new GameObject(sideScrollModel.createImage(),200,200));
			game.add(new GameObject(sideScrollModel.createImage2(),300,550));
			game.add(new GameObject(sideScrollModel.createImage3(),500,550));
			game.add(new GameObject(sideScrollModel.createImage4(), 400, 50));
			sideScrollView = new SideScrollView(game);
			sideScrollView.addKeyListener(this);

		}
		//topDownView.addActionListener(this);
		//game = new ArrayList<GameObject>();
		//game.add(new GameObject(pic,100,100));
		//System.out.println("DID IT DO ANYTHING DIFFERENT????????????????????");
		//game.add(new GameObject(topDownModel.createImage2(),400,400));
		//System.out.println("HOW ABOUT NOW?????????????????");
		//game.add(new GameObject(topDownModel.createImage3(),200,200));
	}
	
	public void topDownStart() {
		//System.out.println("topDownStart is starting");
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			System.out.println("im performing actions");
    			collision = topDownModel.updateLocation(game);
    			topDownView.updateView(game,collision);
    		}
    	};
    	
    	time = new Timer(50, drawAction);
    	time.start();
	}
	public void sideScrollStart() {
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			//System.out.println("im performing actions");
    			sideScrollModel.advanceWorld(game);
    			sideScrollView.updateView(game);
    		}
    	};
    	
    	time = new Timer(50, drawAction);
    	time.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
<
		//System.out.println("pressed");
		if(e.getKeyCode() == 39) { //right arrow key
			if(selected.equals("topDown")) {
				topDownModel.setxChg(5);
				collision = topDownModel.updateLocation(game);
				topDownView.updateView(game,collision);
			}
		}
		else if(e.getKeyCode() == 37) { //left arrow key
			//xIncr = -5;
			if(selected.equals("topDown")) {
				topDownModel.setxChg(-5);
				collision = topDownModel.updateLocation(game);
				topDownView.updateView(game,collision);
			}
		}
		else if(e.getKeyCode() == 38) { //up arrow key
			//yIncr = -5;
			if(selected.equals("topDown")) {
				topDownModel.setyChg(-5);
				collision = topDownModel.updateLocation(game);
				topDownView.updateView(game,collision);
			}
			else if(selected.equals("sideScroll")) {
				sideScrollModel.advanceBird(game, -5);
				sideScrollView.updateView(game);
			}
		}
		else if(e.getKeyCode() == 40) { //down arrow key
			//yIncr = 5;
			if(selected.equals("topDown")) {
				topDownModel.setyChg(5);
				collision = topDownModel.updateLocation(game);
				topDownView.updateView(game,collision);
			}
			else if(selected.equals("sideScroll")) {
				sideScrollModel.advanceBird(game, 5);
				sideScrollView.updateView(game);
			}
		}
		/*
		else if (e.getKeyCode() == 32) {
			if (selected.equals("sideScroll")){
				sideScrollModel.dive(game);
				sideScrollView.updateView(game);
			}
		}
		*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(selected.equals("topDown")) {
			topDownModel.setxChg(0);
			topDownModel.setyChg(0);
		}
	}
	
	
}
